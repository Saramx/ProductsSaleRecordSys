package cn.syy.test.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testIOC {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
//		System.out.println(dataSource.getConnection());
	}
}
