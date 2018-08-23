package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import entity.User;
import exception.UserException;
import service.UserService;
import vo.UserVO;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public boolean login(UserVO vo) throws UserException{	
		  List l=userDao.findByName(vo.getName());
			 if(l.size()==0) {
			    throw new UserException("没有注册");
			   }
			  for(int i=0;i<l.size();i++) {
			    if(((User)l.get(i)).getPassword().equals(vo.getPassword())){
			    	return true;
			    }else {
			    	throw new UserException("密码错误");
			    }
			   }
	    return true;
	}

	@Override
	public boolean register(UserVO vo) throws UserException{
		List l=userDao.findByName(vo.getName());
		if(l.size()==0) {
			User user=new User();
			user.setName(vo.getName());
			user.setPassword(vo.getPassword());
			userDao.add(user);
			return true;
		}else {
			throw new UserException("该用户名已经存在");
		}
	}

}
