package farmstory.dao;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import farmstory.CountableDAO;
import farmstory.dto.ArticleDTO;
import farmstory.dto.OrderDTO;
import farmstory.util.ConnectionHelper;

public class ArticleDAO implements CountableDAO<ArticleDTO> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDAO.class.getName());
	private final ConnectionHelper helper;

	public ArticleDAO(ConnectionHelper helper) {
		this.helper = helper;
	}

	@Override
	public void insert(ArticleDTO dto) {
		// TODO Auto-generated method stub
	}

	@Override
	public ArticleDTO select(ArticleDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ArticleDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ArticleDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderDTO> selectAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}
}
