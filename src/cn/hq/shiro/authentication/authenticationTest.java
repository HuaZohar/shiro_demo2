package cn.hq.shiro.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class authenticationTest {
	
	//用户登录和退出
	@Test
	public void testLoginAndLogOut() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro-realm.ini");
		
		//创建securityManager
		SecurityManager securityManager = factory.getInstance();
		
		//将securityManager设置当前的运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		
		//从SecurityUtils里边创建一个subject
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "1111");
		
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean isAuthenticated = subject.isAuthenticated();
		
		System.out.println(isAuthenticated);
		
//		subject.logout();
//		isAuthenticated = subject.isAuthenticated();
//		System.out.println(isAuthenticated);
		
		
		
		
		
	}
}
