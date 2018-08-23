package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Account;
import exception.AccountException;

public class AccountDaoImpl {
	
	public  static Connection getConnection() {
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://192.168.11.169:3306/oa1_2","root","258790");
			connection.setAutoCommit(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	/**
	 * jdbc 测试
	 * @param a
	 * @param con
	 * @return
	 * @throws SQLException
	 * @throws AccountException
	 */
	public boolean update(Account a,Connection con) throws SQLException,AccountException {
		String sql="update  account set amounts=? where id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setDouble(1, a.getAmounts());
		ps.setLong(2, a.getId());
		int result=ps.executeUpdate();
		if(result==0) throw new AccountException("数据查询问题！");
		if(ps!=null)
		ps.close();
		return true;
	}
	
}
