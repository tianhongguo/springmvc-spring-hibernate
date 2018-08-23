package service;

import exception.UserException;
import vo.UserVO;

public interface UserService {
	public boolean login(UserVO vo) throws UserException;
	public boolean register(UserVO vo) throws UserException;
}
