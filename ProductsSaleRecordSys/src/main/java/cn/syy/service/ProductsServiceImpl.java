package cn.syy.service;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.syy.dao.ProductsDao;
import cn.syy.entity.Products;


@Service("productsService")
@Scope("singleton")
public class ProductsServiceImpl implements ProductsService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//	注入service依赖
	@Autowired
	private ProductsDao productsDao;

	@Override
	public Products getBySoldId(int soldId) {
		// TODO Auto-generated method stub
		return productsDao.queryBySoldId(soldId);
	}

	@Override
	public List<Products> getAll() {
		// TODO Auto-generated method stub
		return productsDao.queryAll();
	}

	@Override
	public int insertProductsServiceAll(int proid, String proname,
			String soldtime, int soldnum, String twoDecimalPrice,
			String purchaser, java.util.Date protime, String protype,
			String remark) {
		// TODO Auto-generated method stub
		return productsDao.insertProductsAll(proid, proname, soldtime, soldnum, twoDecimalPrice, 
				purchaser, protime, protype, remark);
	}

	@Override
	public Products getByPrice(String price) {
		// TODO Auto-generated method stub
		return productsDao.queryByPrice(price);
	}

	@Override
	public Products getSoldTime(String soldTime) {
		// TODO Auto-generated method stub
		return productsDao.queryBySoldTime(soldTime);
	}
	
	@Override
	public List<Products> getByMultiSoldTime(String soldTime) {
		// TODO Auto-generated method stub
		return productsDao.queryByMultiSoldTime(soldTime);
	}

	@Override
	public List<Products> getByMultiProName(String proName) {
		// TODO Auto-generated method stub
		return productsDao.queryByMultiProName(proName);
	}
	
}
