package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import dao.UserDao;
import entity.User;
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private HibernateTemplate hiTemp;
	@Override
	public User findById(Long id) {
		String hql="from User where id=?";
		List<Object> param=new ArrayList<Object>();
		param.add(id);
		return (User)hiTemp.find(hql, param.toArray()).get(0);
	}
	@Override
	public List findByName(String name) {
		String hql="from User where name=?";
		List<Object> param=new ArrayList<Object>();
		param.add(name);
		return hiTemp.find(hql, param.toArray());
	}
	@Override
	public boolean add(User user) {
		try {
			hiTemp.save(user);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}
