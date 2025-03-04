package farmstory.dao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.DataAccessObject;
import farmstory.dto.TermsDTO;
import farmstory.util.ConnectionHelper;

public class TermsDAO implements DataAccessObject<TermsDTO> {
  private static final Logger LOGGER = LoggerFactory.getLogger(TermsDAO.class.getName());
  private final ConnectionHelper helper;

  public TermsDAO(ConnectionHelper helper) {
    this.helper = helper;
  }


  @Override
  public void insert(TermsDTO dto) {
    // TODO Auto-generated method stub
  }

  @Override
  public TermsDTO select(TermsDTO dto) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<TermsDTO> selectAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void update(TermsDTO dto) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(TermsDTO dto) {
    // TODO Auto-generated method stub

  }
}
