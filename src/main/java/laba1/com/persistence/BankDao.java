package laba1.com.persistence;

import laba1.com.entity.Bank;
import org.apache.log4j.Logger;

import java.util.List;

public class BankDao extends AbstractDao<Bank> {
    private static final Logger LOG = Logger.getLogger(BankDao.class);
    private static final String SELECT_FROM_BANK = "SELECT * FROM bank";
    private static final String DELETE_BANK = "DELETE FROM bank " + "WHERE " + COLUMN_ID + " = ?";
    private static String COLUMN_BANK_NAME = "bank_name";
    private static final String INSERT_INTO_BANK = "INSERT INTO bank (" + COLUMN_BANK_NAME + ") VALUE (?)";
    private static final String UPDATE_BANK = "UPDATE bank " + COLUMN_BANK_NAME + "= ? WHERE " + COLUMN_ID + " = ?";

    @Override
    public List<Bank> getAll() {
        return getAll(SELECT_FROM_BANK,
                resultSet -> new Bank(resultSet.getInt(COLUMN_ID),
                        resultSet.getString(COLUMN_BANK_NAME)));
    }

    @Override
    public boolean create(Bank entity) {
        return createUpdate(INSERT_INTO_BANK,
                preparedStatement -> preparedStatement.setString(1, entity.getBankName()));
    }

    @Override
    public boolean update(Bank entity) {
        return createUpdate(UPDATE_BANK, preparedStatement -> {
            preparedStatement.setString(1, entity.getBankName());
            preparedStatement.setInt(2, entity.getId());
        });
    }

    @Override
    public boolean remove(Bank entity) {
        LOG.debug("Deleting a bank: " + entity);
        return createUpdate(DELETE_BANK,
                preparedStatement -> preparedStatement.setInt(1, entity.getId()));

    }
}
