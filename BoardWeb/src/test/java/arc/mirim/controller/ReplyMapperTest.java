package arc.mirim.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import arc.mirim.domain.ReplyVO;
import arc.mirim.mapper.ReplyMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTest {
	
	@Autowired
	private ReplyMapper repMapper;

	
	@Test
	public void replyTest() {
		List<ReplyVO> replist = repMapper.getList(1L);
		for(ReplyVO replyVO : replist) {
			System.out.println(replyVO);
		}
	}
	
	@Test
	public void replyinsert() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(1L);
		vo.setReply("테스트 댓글 입니당");
		vo.setReplyer("테스트 댓글 작성자 입니당");
		System.out.println("insert");
		repMapper.insert(vo);
	}
	
	
}
