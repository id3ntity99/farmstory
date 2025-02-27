package farmstory.service;

import java.util.List;

import farmstory.dao.ArticleDAO;
import farmstory.dto.ArticleDTO;
import farmstory.exception.DataAccessException;

public class ArticleService implements Service<ArticleDTO> {
	private final ArticleDAO articleDAO;
	
	public ArticleService(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	
	
	@Override
	public void create(ArticleDTO dto) throws DataAccessException {
		//게시글 작성
		articleDAO.insert(dto);
		
	}

	@Override
	public ArticleDTO get(ArticleDTO dto) throws DataAccessException {
		//게시글 조회
		return articleDAO.select(dto);
	}

	@Override
	public List<ArticleDTO> getAll() throws DataAccessException {
		//모든 게시글 조회
		return articleDAO.selectAll();
	}

	@Override
	public void update(ArticleDTO dto) throws DataAccessException {
		//게시글 수정
		articleDAO.update(dto);		
	}

	@Override
	public void delete(ArticleDTO dto) throws DataAccessException {
		//게시글 삭제
		articleDAO.delete(dto);
	}
	
}
