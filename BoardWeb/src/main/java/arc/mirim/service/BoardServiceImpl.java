package arc.mirim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arc.mirim.domain.BoardVO;
import arc.mirim.domain.Criteria;
import arc.mirim.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper brdMapper;
	
	@Override
	public void register(BoardVO board) {
		brdMapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return brdMapper.read(bno);
	}

	@Override
	public void modify(BoardVO board) {
		brdMapper.update(board);
	}

	@Override
	public void remove(Long bno) {
		brdMapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return brdMapper.getList();
	}

	@Override
	public List<BoardVO> getSearch(Criteria cri) {
		
		return brdMapper.getSearch(cri);
	}

}
