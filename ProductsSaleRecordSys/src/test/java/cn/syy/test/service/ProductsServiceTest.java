package cn.syy.test.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.syy.entity.Products;
import cn.syy.service.ProductsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"
})
public class ProductsServiceTest {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductsService productsService;

	@Test
	public void testGetBySoldId() {
		int soldId = 1;
		Products products = productsService.getBySoldId(soldId);
//		log.info("soldId=1信息：  ", products);
		System.out.println("soldId=1信息： " + products);
	}

	@Test
	public void testGetAll() {
		List<Products> list = productsService.getAll();
		for(Products a : list){
			System.out.println(a);
		}
	}
	
	@Test
	public void testGetByMultiSoldTime(){
		String soldTime = "2017-01-11";
		List<Products> list = productsService.getByMultiSoldTime(soldTime);
		for(Products p : list){
			System.out.println(p);
		}
	}
}
