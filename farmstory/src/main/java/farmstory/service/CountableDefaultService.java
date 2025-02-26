package farmstory.service;

import java.util.List;
import farmstory.CountableDAO;
import farmstory.DataTransferObject;
import farmstory.exception.DataAccessException;

public class CountableDefaultService<T extends DataTransferObject> implements CountableService<T> {

  private final CountableDAO<T> dao;

  public CountableDefaultService(CountableDAO<T> dao) {
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

  @Override
  public int count() {
    return dao.count();
  }
}
