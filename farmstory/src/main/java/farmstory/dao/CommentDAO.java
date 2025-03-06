package farmstory.dao;

import java.util.List;

import farmstory.CountableDAO;
import farmstory.dto.CommentDTO;
import farmstory.exception.DataAccessException;


public class CommentDAO implements CountableDAO<CommentDTO>{

	@Override
	public void insert(CommentDTO dto) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CommentDTO select(CommentDTO dto) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentDTO> selectAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CommentDTO dto) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CommentDTO dto) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() throws DataAccessException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
