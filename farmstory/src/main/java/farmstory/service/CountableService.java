package farmstory.service;

import farmstory.DataTransferObject;

public interface CountableService<T extends DataTransferObject> extends Service<T> {
  int count();
}
