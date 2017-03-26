package com.xiaobu.resolver;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;


/**
 * @author loswing
 * spring mvc 多view 兼容的 通过后缀来过滤
 * FIXME 也可以通过 集成  ViewResolver 不过 AbstractCachingViewResolver是所有resolver的根更靠谱点
 */
public class SpringMvcExtendViewResolver extends AbstractCachingViewResolver  implements Ordered{ 
   
    private int order = Integer.MIN_VALUE;  
    
    public int getOrder() {  
        return order;  
    }  
  
    public void setOrder(int order) {  
        this.order = order;  
    }  
      
    private Map<String, ViewResolver> resolvers;  
      
    public void setResolvers(Map<String, ViewResolver> resolvers) {  
        this.resolvers = resolvers;  
    }  
    private String getViewResolverKey(String fileExtension){  
        Iterator<String> keyIt = resolvers.keySet().iterator();  
        while (keyIt.hasNext()) {  
            String viewResolverKey = (String) keyIt.next();  
            String[] arr = viewResolverKey.split(",");  
            for (String subKey : arr) {  
                if(subKey.equals(fileExtension)) return viewResolverKey;  
            }  
        }  
        return null;  
    }  
      
    @Override  
    protected View loadView(String viewName, Locale locale) throws Exception {  
        String fileExtension = StringUtils.getFilenameExtension(viewName);  
        if (fileExtension == null) {  
            return null;  
        }  
        String viewResolverKey = getViewResolverKey(fileExtension);  
        ViewResolver resolver = resolvers.get(viewResolverKey);  
          
        return resolver == null ? null : resolver.resolveViewName(viewName,locale);  
  
    }   
}
