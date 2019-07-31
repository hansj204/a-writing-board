package arc.mirim.service;

import java.util.List;

import arc.mirim.domain.ReplyVO;

public interface ReplyService {

		public List<ReplyVO> getList(Long bno);
		public void insert(ReplyVO vo);
		public void delete(Long  rno);
		public void update(ReplyVO vo);


}
