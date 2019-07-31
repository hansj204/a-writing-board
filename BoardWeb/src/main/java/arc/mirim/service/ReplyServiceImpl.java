package arc.mirim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arc.mirim.domain.BoardVO;
import arc.mirim.domain.Criteria;
import arc.mirim.domain.ReplyVO;
import arc.mirim.mapper.BoardMapper;
import arc.mirim.mapper.ReplyMapper;
@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	ReplyMapper repMapper;
	@Autowired
	BoardMapper brdMapper;

	@Override
	public List<ReplyVO> getList(Long bno) {
		return repMapper.getList(bno);
	}

	@Override
	public void insert(ReplyVO vo) {
		brdMapper.updateReplyCnt(vo.getBno(), 1);
		repMapper.insert(vo);
		
	}


	@Override
	public void update(ReplyVO vo) {
		repMapper.update(vo);
		
	}

	@Override
	public void delete(Long rno) {
		repMapper.delete(rno);
		ReplyVO vo = repMapper.read(rno);
		brdMapper.updateReplyCnt(vo.getBno(), -1);
		repMapper.delete(rno);
		
	}

	

}
