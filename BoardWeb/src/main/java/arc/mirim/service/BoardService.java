package arc.mirim.service;

import java.util.List;

import arc.mirim.domain.BoardVO;
import arc.mirim.domain.Criteria;

public interface BoardService {

	public List<BoardVO> getSearch(Criteria cri);
	public void register(BoardVO board);
	public BoardVO get(Long bno);
	public void modify(BoardVO board);
	public void remove(Long bno);
	public List<BoardVO> getList();
}
