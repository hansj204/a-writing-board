package arc.mirim.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import arc.mirim.domain.BoardVO;
import arc.mirim.mapper.BoardMapper;
import arc.mirim.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {

	@Autowired
	private BoardMapper brdMapper;
	
	@Autowired
	private BoardService brdService;
	
	@Test
	public void serviceTest() {
		List<BoardVO> brdlist = brdService.getList();
		for(BoardVO boardVO : brdlist) {
			System.out.println(boardVO);
		}
	}
	
	@Test
	public void boardTest1() {
		System.out.println("test...");
		
		List<BoardVO> brdlist = brdMapper.getList();
		for(BoardVO boardVO:brdlist) {
			System.out.println(boardVO);
		}
	}
	
	@Test
	public void boardInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("모야?");
		board.setContent("모냐구");
		board.setWriter("이수정");
		brdMapper.insert(board);
		System.out.println("insert ok..."+board);
	}
	
	@Test
	public void boardRead() {
		BoardVO board = brdMapper.read(4L);
		System.out.println(" ok "+board);
	}
	
	@Test
	public void boardDelete() {
		brdMapper.delete(5L);
		System.out.println("del ok...");
	}
	
	@Test
	public void boardUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(4L);
		board.setTitle("수정했음");
		board.setContent("수정내용");
		board.setWriter("admin");
		brdMapper.update(board);
	}
}
