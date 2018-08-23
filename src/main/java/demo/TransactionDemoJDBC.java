package demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


import entity.Account;
import exception.AccountException;
import unit.MathUnit;

/**
 * jdbc对事务的处理练习
 * @author tianhongguo
 *
 */
public class TransactionDemoJDBC {
	
	public boolean transfer(Account out,Account in,double money,Connection con)  {
		try {			
			AccountDaoImpl dao=new AccountDaoImpl();
			in.setAmounts(MathUnit.add(in.getAmounts(), money));			
			out.setAmounts(MathUnit.sub(out.getAmounts(), money));	
			if(out.getAmounts()<0) {
				throw new Exception();
			}
			dao.update(in,con);
			dao.update(out,con);				
			con.commit();
			return true;
		}catch(Exception e) {			
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now=new Date();
		String date=simpleDateFormat.format(now);
		System.out.println(now.getTime());
		Account a1=new Account(14l,"现金账户一",2,"341",99,1l,1528684441295l,3l,1530584852171l,'1');
		Account a2=new Account(15l,"现金账户一",3,"324",1111,1l,1528684925011l,1l,333l,'1');
		TransactionDemoJDBC td=new TransactionDemoJDBC();
		Connection con =AccountDaoImpl.getConnection();		
		td.transfer(a1,a2,100,con);
		System.out.println(date);
	}
}
