package laba1.com.persistence;

import laba1.com.entity.TaxedDeposit;
import org.apache.log4j.Logger;

import java.util.List;

public class TaxedDepositDao extends AbstractDao<TaxedDeposit> {
    private static final Logger LOG = Logger.getLogger(DepositTypeDao.class);

    private static final String COLUMN_DEPOSIT_TYPE_ID = "deposit_type_id";
    private static final String COLUMN_TAX = "tax";

    private static final String SELECT_FROM_TAXED_DEPOSIT = "SELECT * FROM taxed_deposit";

    private static final String INSERT_INTO_TAXED_DEPOSIT = "INSERT INTO taxed_deposit ("
            + COLUMN_DEPOSIT_TYPE_ID + ", "
            + COLUMN_TAX + ") VALUE (?, ?, ?)";

    private static final String UPDATE_TAXED_DEPOSIT = "UPDATE taxed_deposit "
            + COLUMN_DEPOSIT_TYPE_ID + "= ?, "
            + COLUMN_TAX + "= ? WHERE "
            + COLUMN_ID + " = ?";

    private static final String DELETE_TAXED_DEPOSIT = "DELETE FROM taxed_deposit " + "WHERE "
            + COLUMN_ID + " = ?";

    @Override
    public List<TaxedDeposit> getAll() {
        return getAll(SELECT_FROM_TAXED_DEPOSIT, resultSet -> new TaxedDeposit(resultSet.getInt(COLUMN_ID),
                resultSet.getInt(COLUMN_DEPOSIT_TYPE_ID),
                resultSet.getInt(COLUMN_TAX)));
    }

    @Override
    public boolean create(TaxedDeposit entity) {
        return createUpdate(INSERT_INTO_TAXED_DEPOSIT, preparedStatement -> {
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setInt(2, entity.getDepositTypeId());
            preparedStatement.setInt(3, entity.getTax());
        });
    }

    @Override
    public boolean update(TaxedDeposit entity) {
        return createUpdate(UPDATE_TAXED_DEPOSIT, ps -> {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getDepositTypeId());
            ps.setInt(3, entity.getTax());
        });
    }

    @Override
    public boolean remove(TaxedDeposit entity) {
        LOG.debug("Deleting taxed deposit: " + entity);
        return createUpdate(DELETE_TAXED_DEPOSIT,
                preparedStatement -> preparedStatement.setInt(1, entity.getId()));
    }
}
