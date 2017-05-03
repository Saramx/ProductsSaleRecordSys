 package cn.syy.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.syy.entity.Products;

public interface ProductsDao {
		
	Products queryBySoldId(int soldId);
	
	Products queryByPrice(String price);
	
	List<Products> queryByMultiProName(String proName);
	
	Products queryBySoldTime(String soldTime);

	List<Products> queryByMultiSoldTime(String soldTime);
	
	List<Products> queryAll();	
		
	int insertProductsAll(@Param("proid") int proid, @Param("proname") String proname,
			@Param("soldtime") String soldtime, @Param("soldnum") int soldnum,
			@Param("price") String twoDecimalPrice, @Param("purchaser") String purchaser,
			@Param("protime") Date protime, @Param("protype") String protype, @Param("remark") String remark
			);
}
