package cn.syy.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import cn.syy.entity.Products;
import cn.syy.service.ProductsService;
/**
 * Test Url: 
 * http://localhost:8080/jsp/view/productslist
 * http://localhost:8080/jsp/view/solddetail/{param}
 */
@Controller
@Path("/view")
public class ViewJsp {
	@Autowired
	private ProductsService productsService;
	
//	已售产品页面
	@GET
	@Path("/productslist")
	public void getProductsList(@Context HttpServletRequest request,@Context HttpServletResponse response) 
			throws ServletException, IOException{
		List<Products> list = productsService.getAll();
		request.setAttribute("list", list);
		// 路径格式注意（webapp下子文件夹问题）：/sortable/products.jsp
		request.getRequestDispatcher("/WEB-INF/sortable/products.jsp").forward(request, response);
	}
    
//	详情页面
	@GET
    @Path("/solddetail/{soldId}")
	public void getSoldDetail(@PathParam("soldId")int soldId,@Context HttpServletRequest request,@Context HttpServletResponse response) 
			throws ServletException, IOException{
		Products products = productsService.getBySoldId(soldId);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/WEB-INF/sortable/solddetail.jsp").forward(request, response);	
		System.out.println(products);
	}
	
//	查询：销售编号--soldId
	@GET
    @Path("/queryid/{soldId}")
	public void QuerySoldId(@PathParam("soldId")int soldId,@Context HttpServletRequest request,@Context HttpServletResponse response) 
			throws ServletException, IOException{	
		Products products = productsService.getBySoldId(soldId);
		request.setAttribute("products", products);
		request.getRequestDispatcher("/WEB-INF/sortable/querysoldid.jsp").forward(request, response);	
		System.out.println(products);
	}
	
	
//	查询：产品名称--proName
	@GET
	@Path("/queryname/{proName}")
	public void QueryProNameList(@PathParam("proName")String proName,@Context HttpServletRequest request,@Context HttpServletResponse response)
			throws ServletException, IOException{
		List proNameList = productsService.getByMultiProName(proName);
		request.setAttribute("proNameList", proNameList);
		request.getRequestDispatcher("/WEB-INF/sortable/queryproname.jsp").forward(request, response);
		System.out.println("产品信息："+proNameList);
	}
	
//	查询：产品价格--price
	@GET
	@Path("/queryprice/{price}")
	public void QueryPrice(@PathParam("price") String price,@Context HttpServletRequest request,@Context HttpServletResponse response)
			throws ServletException, IOException{
		Products products = productsService.getByPrice(price);
		request.setAttribute("products",products);
		request.getRequestDispatcher("/WEB-INF/sortable/queryprice.jsp").forward(request, response);	
		System.out.println(products);
		
	}
	
//	查询：销售时间--soldtime
	@GET
	@Path("/querytime/{soldTime}")
	public void QuerySoldTime(@PathParam("soldTime") String soldTime,@Context HttpServletRequest request,@Context HttpServletResponse response)
			throws ServletException, IOException{
		List soldTimeList = productsService.getByMultiSoldTime(soldTime);
		request.setAttribute("soldTimeList", soldTimeList);
		request.getRequestDispatcher("/WEB-INF/sortable/querytime.jsp").forward(request, response);
		System.out.println(soldTimeList);
	}
}
