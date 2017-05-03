/**   
 * 类名：RestApplication
 *
 */
package cn.syy.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class RestApplication extends ResourceConfig {
    public RestApplication() {  
      

        //服务类所在的包路径  
        packages("cn.syy.web");  
        //注册JSON转换器  
        register(JacksonJsonProvider.class); 
        register(JspMvcFeature.class);
        property(JspMvcFeature.TEMPLATE_BASE_PATH, "/sortable/");

       }  
}
