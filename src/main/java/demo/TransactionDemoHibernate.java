package demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Account;
import unit.MathUnit;

public class TransactionDemoHibernate {
	public void testSuccess() {
		Configuration cfg=new Configuration().configure();
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		Session session =sessionFactory.getCurrentSession();
		Transaction t=session.beginTransaction();
		Query q=session.createQuery("from Account");
		List<Account> la=q.list();
		System.out.println(la.get(0).getId());
		t.commit();
	}
	public void Move(Account in,Account out,double money)  {
		Transaction t=null;
		Session session=null;
		try{
			in.setAmounts(MathUnit.add(in.getAmounts(), money));
			out.setAmounts(MathUnit.sub(out.getAmounts(), money));
			if(out.getAmounts()<0) {
				throw new Exception();
			}
			Configuration c=new Configuration().configure();
			SessionFactory seesf=c.buildSessionFactory();
			 session=seesf.getCurrentSession();
			 t=session.beginTransaction();
			session.update(in);
			session.update(out);		
			t.commit();
		}catch(Exception e){
			t.rollback();
		}finally {
			session.close();
		}
	}
	
	public static void main(String[] a) {
		TransactionDemoHibernate t=new TransactionDemoHibernate();
		//	t.testSuccess();	
		Account a1=new Account(14l,"现金账户一",2,"341",99,1l,1528684441295l,3l,1530584852171l,'1');
		Account a2=new Account(15l,"现金账户一",3,"324",1111,1l,1528684925011l,1l,333l,'1');
		try {
			t.Move(a1, a2, 100000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
