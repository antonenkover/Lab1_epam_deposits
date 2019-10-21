package laba1.com.persistence;

import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T> implements EntityDao<T> {
    private static final Logger LOG = Logger.getLogger(AbstractDao.class);
    protected static String COLUMN_ID = "id";

    public List<T> getAll(String query, EntityMapper<T> mapper) {
        List<T> result = new ArrayList<>();
        try (PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                result.add(entity);
            }

        } catch (SQLException e) {
            LOG.error("Error occured while getting all entities.");
        }

        return result;
    }

    public boolean createUpdate(String query, StatementMapper<T> statementMapper) {
        try (PreparedStatement preparedStatement = DataSourceFactory.getPreparedStatement(query)) {
            statementMapper.map(preparedStatement);

            int result = preparedStatement.executeUpdate();

            return result == 1;

        } catch (SQLException e) {
            LOG.error("Error occured while creating entity");
        }

        return false;
    }

}
