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
	
	//�û���¼���˳�
	@Test
	public void testLoginAndLogOut() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro-realm.ini");
		
		//����securityManager
		SecurityManager securityManager = factory.getInstance();
		
		//��securityManager���õ�ǰ�����л�����
		SecurityUtils.setSecurityManager(securityManager);
		
		//��SecurityUtils��ߴ���һ��subject
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
