package arc.mirim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import arc.mirim.domain.ReplyVO;

public interface ReplyMapper {
	@Select("select * from tbl_reply where bno = #{bno}")
	public List<ReplyVO> getList(Long bno);
	
	@Insert("insert into tbl_reply (rno, bno, reply, replyer) values (seq_reply.nextval, #{bno}, #{reply}, #{replyer})")
	public void insert(ReplyVO vo);
	
	@Delete("delete from tbl_reply where rno = #{rno}")
	public void delete(Long rno);
	
	@Update("update tbl_reply set reply =  #{reply}, updateDate=sysdate where rno=#{rno}")
	public void update(ReplyVO vo);

	@Select("select * from tbl_reply where rno = #{rno}")
	public ReplyVO read(Long rno);
}
