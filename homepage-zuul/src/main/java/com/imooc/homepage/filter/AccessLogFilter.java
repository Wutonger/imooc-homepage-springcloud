package com.imooc.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义过滤器打印客户端请求时间
 */
@Component
public class AccessLogFilter extends ZuulFilter {

     private final Logger log = LoggerFactory.getLogger(AccessLogFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        Long startTime = (Long)ctx.get("startTime");
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        long duration = System.currentTimeMillis()-startTime;
        log.info("uri: {}, duration: {}ms",uri,duration/100);
        return null;
    }
}
