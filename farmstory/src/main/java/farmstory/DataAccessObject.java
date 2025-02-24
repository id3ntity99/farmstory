package farmstory;

import java.util.List;

public interface DataAccessObject<T extends DataTransferObject> {
  void insert(T dto) throws DataAccessException;

  T select(T dto) throws DataAccessException;

  List<T> selectAll() throws DataAccessException;

  void update(T dto) throws DataAccessException;

  void delete(T dto) throws DataAccessException;
}
