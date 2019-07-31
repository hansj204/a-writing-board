package arc.mirim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arc.mirim.domain.LoginDTO;
import arc.mirim.domain.UserVO;
import arc.mirim.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	

	@Override
	public UserVO login(LoginDTO dto) {
		return userMapper.login(dto);
	}


	@Override
	public void sign(UserVO vo) {
		userMapper.sign(vo);
		
	}
	
	

}
