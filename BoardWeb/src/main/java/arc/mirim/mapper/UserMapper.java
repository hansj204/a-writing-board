package arc.mirim.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import arc.mirim.domain.LoginDTO;
import arc.mirim.domain.UserVO;

public interface UserMapper {
	@Select("select userid, userpw, username from tbl_user where userid = #{loginId} and userpw = #{loginPw}")
	public UserVO login(LoginDTO dto);
	
	@Insert("insert into tbl_user (userid, userpw, username, useremail) values (#{userId},#{userPw},#{userName},#{userEmail})")
	public void sign(UserVO vo);
	
	
}
