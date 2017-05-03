package cn.syy.test.web;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.syy.entity.Products;
import cn.syy.service.ProductsService;

public class ProductsJerseyTest {
	
private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductsService productsService;

	@Test
	public void testGetProductsList() {
		List<Products> productsList = productsService.getAll();
//		System.out.println("售出产品信息：" + productsList);
		log.info("售出产品信息：" + productsList);
//		return productsList;
	}

}
