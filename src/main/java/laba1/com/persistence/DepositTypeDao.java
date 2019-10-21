package laba1.com.persistence;

import laba1.com.entity.DepositType;
import org.apache.log4j.Logger;

import java.util.List;

public class DepositTypeDao extends AbstractDao<DepositType> {
    private static final Logger LOG = Logger.getLogger(DepositTypeDao.class);

    private static final String COLUMN_DEPOSIT_TYPE = "deposit_type";
    private static final String COLUMN_DEPOSIT_TYPE_ID = "deposit_type_id";

    private static final String SELECT_FROM_DEPOSIT_TYPE = "SELECT * FROM deposit_type";

    private static final String INSERT_INTO_DEPOSIT_TYPE = "INSERT INTO deposit_type (" + COLUMN_DEPOSIT_TYPE + ") VALUE (?)";

    private static final String UPDATE_DEPOSIT_TYPE = "UPDATE deposit_type " + COLUMN_DEPOSIT_TYPE + "= ? WHERE " + COLUMN_DEPOSIT_TYPE_ID + " = ?";

    private static final String DELETE_DEPOSIT_TYPE = "DELETE FROM deposit_type " + "WHERE " + COLUMN_DEPOSIT_TYPE_ID + " = ?";

    @Override
    public List<DepositType> getAll() {
        return getAll(SELECT_FROM_DEPOSIT_TYPE,
                resultSet -> new DepositType(resultSet.getInt(COLUMN_DEPOSIT_TYPE_ID),
                        resultSet.getString(COLUMN_DEPOSIT_TYPE)));
    }

    @Override
    public boolean create(DepositType entity) {
        return createUpdate(INSERT_INTO_DEPOSIT_TYPE,
                preparedStatement -> preparedStatement.setString(1, entity.getDepositType()));
    }

    @Override
    public boolean update(DepositType entity) {
        return createUpdate(UPDATE_DEPOSIT_TYPE, preparedStatement -> {
            preparedStatement.setString(1, entity.getDepositType());
            preparedStatement.setInt(2, entity.getDepositTypeId());
        });
    }

    @Override
    public boolean remove(DepositType entity) {
        LOG.debug("Deleting a bank: " + entity);
        return createUpdate(DELETE_DEPOSIT_TYPE,
                preparedStatement -> preparedStatement.setInt(1, entity.getDepositTypeId()));
    }
}
