package cn.syy.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cn.syy.entity.Products;


public interface ProductsService {

	public Products getBySoldId(int soldId);
	
	List<Products> getByMultiProName(String proName);
		
	public List<Products> getAll();
	
	public Products getByPrice(String price);
	
	public Products getSoldTime(String soldTime);
	
	List<Products> getByMultiSoldTime(String soldTime);
	
	int insertProductsServiceAll(
			@Param("proid") int proid, @Param("proname") String proname,
			@Param("soldtime") String soldtime, @Param("soldnum") int soldnum,
			@Param("price") String twoDecimalPrice, @Param("purchaser") String purchaser,
			@Param("protime") Date protime, @Param("protype") String protype, @Param("remark") String remark			
			);
}
