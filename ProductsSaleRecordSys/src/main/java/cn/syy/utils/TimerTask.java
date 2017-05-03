package cn.syy.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import cn.syy.dao.ProductsDao;
import cn.syy.entity.Products;
import cn.syy.service.ProductsService;

public class TimerTask {
	
	@Autowired
	private ProductsService productsService;
	static Random random = new Random();
	
//	产品类型
	String protype = "饼干";
	
//	 单一销售数量
	int soldnum = 1;
	
//	随机购买者
	public String RandomPurchaser(){
		int r = random.nextInt(4);
		String []purchaser={"张三","李四","孔子","王五","赵六"};
		return purchaser[r];
	}
		
//	随机产品名称
	public String RandomProName(){
		int rp = random.nextInt(6);
		String []proname={"抹茶奥利奥","草莓奥利奥","海苔","长鼻王","麦香鸡","小王子饼干","小馒头"};
		return proname[rp];
	}
	
//	随机备注内容
	public String RandomRemark(){
		int rk = random.nextInt(5);
		String []remark={"一月购买","二月购买","三月购买","数量不足","退货中","未收货"};
		return remark[rk];
	}
	
//	随机产生1-100的产品编号
	public int RandomProId(){
		int proid = random.nextInt(101);
		return proid;
	}
	
//	 随机产生价格（保留2位小数）
	public String RandomPrice(){
		DecimalFormat decimalFormat = new DecimalFormat("######0.00");
		double price =Math.random()*100+100;
		String twoDecimalPrice = decimalFormat.format(price);
		return twoDecimalPrice;
	}
	
//	 随机产生时间（2017-1-1 - 2017-3-31）
	public Date randomDate = randomDate("2017-1-1","2017-3-31");
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
	
//	销售时间阶段处理
	public static long random(long begin,long end){
		
		long rtn = begin + (long)(Math.random() * (end - begin)); 
		//如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
		if(rtn == begin || rtn == end){
		return random(begin,end);
		}
		return rtn;	
	}
	
//	定时任务
	public void job(){
		TimerTask timerTask = new TimerTask();	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	存储数据
		productsService.insertProductsServiceAll(timerTask.RandomProId(), timerTask.RandomProName(), 
				sdf.format(timerTask.randomDate).toString(), soldnum, timerTask.RandomPrice(), 
				timerTask.RandomPurchaser(), timerTask.randomDate, protype, timerTask.RandomRemark());	
	}		
}
