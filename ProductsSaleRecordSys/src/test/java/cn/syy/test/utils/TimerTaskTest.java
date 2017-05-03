package cn.syy.test.utils;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.syy.service.ProductsService;
import cn.syy.utils.TimerTask;

public class TimerTaskTest {
	@Autowired
	private ProductsService productsService;
	@Test
	public void testRandomDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRandom() {
		fail("Not yet implemented");
	}

	//========================================================
//	----------------------- 随机获取购买者
	Random random = new Random();
	int r = random.nextInt(4);
	String []puerchaser={"张三","李四","李四","王五","赵六"};
//	System.out.println("购买者：" + puerchaser[r]);
		
//	----------------------- 随机获取产品名称
	int rp = random.nextInt(6);
	String []proname={"抹茶奥利奥","草莓奥利奥","海苔","长鼻王","麦香鸡","小王子饼干","小馒头"};
//	System.out.println("产品名称：" + proname[rp] );
	
//	----------------------- 随机产生价格（保留2位小数）
	DecimalFormat decimalFormat = new DecimalFormat("######0.00");
	double price =Math.random()*100+100;
	String twoDecimalPrice = decimalFormat.format(price);
//	System.out.println("价格：" + twoDecimalPrice);
	
//	----------------------- 随机产生时间（2017-1-1 - 2017-3-31）
	Date randomDate = randomDate("2017-1-1","2017-3-31");
	/**
	 * 生成随机时间
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static Date randomDate(String beginDate,String endDate){
		try{
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//构造开始日期 
			Date start = format.parse(beginDate); 
			//构造结束日期
			Date end = format.parse(endDate);
			//getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数
			if(start.getTime() >= end.getTime()){
				return null;
			}
			
			long date = random(start.getTime(), end.getTime());
			return new Date(date);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static long random(long begin,long end){
		
		long rtn = begin + (long)(Math.random() * (end - begin)); 
		//如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
		if(rtn == begin || rtn == end){
		return random(begin,end);
		}
		return rtn;	
	}
	
/*	@Test
	public void testCallProcedure() {
	
		TimerTask timerTask = new TimerTask();
		for(int i =1; i < 101; i++){
			productsService.insertProductsService(proname, soldtime, soldnum, twoDecimalPrice, purchaser);		
		}
	}*/

}
