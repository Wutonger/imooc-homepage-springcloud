package com.imooc.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 在过滤器中存储客户端存储请求的时间戳
 */
@Component
public class PreRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //执行的优先级，越小执行优先级越高
    @Override
    public int filterOrder() {
        return 0;
    }

    //是否启用当前过滤器
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //
    @Override
    public Object run() throws ZuulException {
        //用于在过滤器之间传递消息
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime",System.currentTimeMillis());
        return null;
    }
}
