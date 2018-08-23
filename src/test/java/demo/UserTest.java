package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserTest {
	@Autowired
	private UserService use;
	@Test
	public void test() {
	//	System.out.println(use.login(new UserVO("z","123")));
	}
	public static void main(String[] a) {
		String str="   ";
		System.out.println(str.isEmpty());
	}
}
