package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import controller.abs.ControllerBase;
import exception.UserException;
import service.UserService;
import vo.UserVO;

@Controller
public class UserController extends ControllerBase{
	@Autowired
	private UserService userSer;
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public Object Login( @RequestParam UserVO vo) {
		try {
			if(vo.getName().equals(null)||vo.getName().isEmpty()) {
				 throw new UserException("用户名不能为空");
			}
			if(vo.getPassword().equals(null)||vo.getPassword().isEmpty()) {
				throw new UserException("密码不能为空");
			}
			userSer.login(vo);
			return "登录成功";
		}catch(UserException userE) {
			return userE.getMessage();
		}
	}
	
	public Object register(UserVO vo) {
		try {
			if(vo.getName().equals(null)||vo.getName().isEmpty()) {
				 throw new UserException("用户名不能为空");
			}
			if(vo.getPassword().equals(null)||vo.getPassword().isEmpty()) {
				throw new UserException("密码不能为空");
			}
			userSer.register(vo);
			return "注册成功";
		}catch(UserException userE) {
			return userE.getMessage();
		}
	}
}
