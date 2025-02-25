package farmstory;

public interface CountableDAO<T extends DataTransferObject> extends DataAccessObject<T> {
  int count();
}
