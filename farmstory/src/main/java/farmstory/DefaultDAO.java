package farmstory;

import java.util.List;
import farmstory.util.ConnectionHelper;

public class DefaultDAO<T extends DataTransferObject> implements DataAccessObject<T> {
  protected final ConnectionHelper helper;

  public DefaultDAO(ConnectionHelper helper) {
    this.helper = helper;
  }

  @Override
  public void insert(T dto) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public T select(T dto) throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<T> selectAll() throws DataAccessException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(T dto) throws DataAccessException {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(T dto) throws DataAccessException {
    // TODO Auto-generated method stub

  }
}
