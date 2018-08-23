package dao;

import java.util.List;

import entity.User;
import vo.UserVO;

public interface UserDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
  public User findById(Long id) ;
  /**
   * 
   * @param name
   * @return
   */
  public List findByName(String name);
  /**
   * 
   * @param vo
   * @return
   */
  public boolean add(User user);
}
