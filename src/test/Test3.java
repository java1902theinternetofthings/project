package test;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.ResolverUtil.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import entity.User;
public class Test3 {
	public static void main(String[] args                                  ) {
		/*
		 * //1.加载核心配置文件 String xml = "/config.xml"; InputStream in =
		 * Test.class.getResourceAsStream(xml); //2.创建sessionfactory工厂 SqlSessionFactory
		 * factory = new SqlSessionFactoryBuilder().build(in); //3.opensession
		 * SqlSession session = factory.openSession(); //4.打开相应的执行器 List<User> users =
		 * new ArrayList<User>(); User u1 = new User(); User u2 = new User(); User u3 =
		 * new User(); u1.setUsername("谢旺"); u1.setPassword("123"); u1.setSex("男");
		 * u1.setAge(21); u2.setUsername("谢旺2"); u2.setPassword("123"); u2.setSex("男");
		 * u2.setAge(21); u3.setUsername("谢旺3"); u3.setPassword("123"); u3.setSex("男");
		 * u3.setAge(21); users.add(u1); users.add(u2); users.add(u3);
		 * session.insert("user.insertMessages", users); session.commit();
		 * session.close();
		 */
		
		 String xml = "/config.xml";
		 InputStream in = Test.class.getResourceAsStream(xml);
		 SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		 SqlSession session = factory.openSession();
		 List<Integer> ids = new ArrayList();
		 ids.add(4);
		 ids.add(5);
		 ids.add(6);
		 ids.add(7);
		 ids.add(8);
		 ids.add(9);
		 
		 
		 PageHelper.startPage(0, 2);
		 List<User> lists = session.selectList("user.allmessages",ids);
		 PageInfo<User> info = new PageInfo<>(lists);
		 
		 System.out.println("总记录数：" + info.getTotal());
	     System.out.println("当前页数：" + info.getPageNum());
	     System.out.println("每页数：" + info.getPageSize());
	     System.out.println("总页数：" + info.getPages());
	     System.out.println("结果集：" + info.getList());
		 
		 //session.close();
	    
		 

	}
	
}
