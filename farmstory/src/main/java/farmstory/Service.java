package farmstory;

import java.util.List;

public abstract class Service<T extends DataTransferObject> {
  protected final DataAccessObject<T> dao;

  protected Service(DataAccessObject<T> dao) {
    this.dao = dao;
  }

  protected DataAccessObject<T> getDAO() {
    return this.dao;
  }

  protected abstract void create(T dto);

  protected abstract void get(T dto);

  protected abstract List<T> getAll();

  protected abstract void update(T dto);

  protected abstract void delete(T dto);
}
