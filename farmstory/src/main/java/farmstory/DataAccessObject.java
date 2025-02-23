package farmstory;

import java.util.List;

public interface DataAccessObject<T extends DataTransferObject> {
  void insert(T dto);

  T select(T dto);

  List<T> selectAll();

  void update(T dto);

  void delete(T dto);
}
