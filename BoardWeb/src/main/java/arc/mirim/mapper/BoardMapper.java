package arc.mirim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import arc.mirim.domain.BoardVO;
import arc.mirim.domain.Criteria;

public interface BoardMapper {
	@Update("update tbl_board set replycnt = replycnt + #{amount} where bno = #{bno}")
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
	@Select("select * from tbl_board where ${type} like '%'||#{keword}||'%'")
	public List<BoardVO> getSearch(Criteria ci);
	
	@Select("select * from tbl_board")
	public List<BoardVO> getList();
	
	@Insert("insert into tbl_board(bno, title, content, writer) values(seq_board.nextval, #{title}, #{content}, #{writer})")
	public void insert(BoardVO board);
	
	@Select("select * from tbl_board where bno = #{bno}")
	public BoardVO read(Long bno);
	
	@Delete("delete tbl_board where bno = #{bno}")
	public void delete(Long bno);
	
	@Update("update tbl_board set title=#{title}, content=#{content}, writer=#{writer}, updatedate=sysdate where bno=#{bno}")
	public void update(BoardVO board);
}
