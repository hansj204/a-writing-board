package arc.mirim.service;

import arc.mirim.domain.LoginDTO;
import arc.mirim.domain.UserVO;

public interface UserService {

		public UserVO login(LoginDTO dto);
		public void sign(UserVO vo);
		
}
