package farmstory;

import java.util.List;
import farmstory.util.ConnectionHelper;

/**
 * @deprecated "Entity마다 사용하는 Query가 다르므로 본 클래스를 활용하기에는 어려움이 있음"
 */
@Deprecated
public class DefaultDAO<T extends DataTransferObject> implements DataAccessObject<T> {
  protected final ConnectionHelper helper;

  public DefaultDAO(ConnectionHelper helper) {
    this.helper = helper;
  }

  @Override
  public void insert(T dto) throws DataAccessException {

  }

  @Override
  public T select(T dto) throws DataAccessException {
    return null;
  }

  @Override
  public List<T> selectAll() throws DataAccessException {
    return null;
  }

  @Override
  public void update(T dto) throws DataAccessException {

  }

  @Override
  public void delete(T dto) throws DataAccessException {

  }
}
