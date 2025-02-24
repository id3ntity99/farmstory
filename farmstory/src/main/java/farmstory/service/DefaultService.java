package farmstory.service;

import java.util.List;
import farmstory.DataAccessException;
import farmstory.DataAccessObject;
import farmstory.DataTransferObject;

public class DefaultService<T extends DataTransferObject> implements Service<T> {
  private final DataAccessObject<T> dao;

  public DefaultService(DataAccessObject<T> dao) {
    this.dao = dao;
  }

  @Override
  public void create(T dto) throws DataAccessException {
    dao.insert(dto);
  }

  @Override
  public T get(T dto) throws DataAccessException {
    return dao.select(dto);

  }

  @Override
  public List<T> getAll() throws DataAccessException {
    return dao.selectAll();
  }

  @Override
  public void update(T dto) throws DataAccessException {
    dao.update(dto);
  }

  @Override
  public void delete(T dto) throws DataAccessException {
    dao.delete(dto);
  }
}
