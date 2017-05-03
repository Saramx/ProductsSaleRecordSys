package cn.syy.test.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.syy.dao.ProductsDao;
import cn.syy.entity.Products;
import cn.syy.service.ProductsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class ProductsDaoTest {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
//	注入Dao实现类依赖（注入依赖后才能实现测试）
	@Resource
	private ProductsDao productsDao;
	
	@Test
	public void testQueryBySoldId() {
		int soldId = 1;
		Products products = productsDao.queryBySoldId(soldId);
		System.out.println("产品名： " + products.getProName());
		System.out.println("soldId=1信息： " + products);
//		log.info("products ={} ", products);
	}

	@Test
	public void testQueryByMultiProName() throws Exception{
		String proName = "小王子饼干";
		List<Products> list =  productsDao.queryByMultiProName(proName);
		for(Products p : list){
			System.out.println("产品信息： " + p);
		}
	}
	
	@Test
	public void queryByMultiSoldTime() throws Exception{
		String soldTime = "2017-01-11";
		List<Products> list = productsDao.queryByMultiSoldTime(soldTime);
		for(Products p : list){
			System.out.println("产品信息：" + p);
		}		
	}
	
	@Test
	public void testQueryAll() throws Exception{
		//java没有保存形参的记录
		List<Products> list = productsDao.queryAll();
		for(Products a : list){
			System.out.println("产品信息：" + a);
		}
	}
	
	@Test
	public void testQueryByPrice() throws Exception{
		String price = "102.21";
		Products products = productsDao.queryByPrice(price);
		log.info("products ={}" + products);
	}
}
