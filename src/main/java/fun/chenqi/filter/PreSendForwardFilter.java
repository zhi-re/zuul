package fun.chenqi.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenqi
 * @date 2019/7/9 14:44
 */
@Component
public class PreSendForwardFilter extends ZuulFilter {
    // 对应Zuul生命周期的四个阶段：pre、post、route和error；
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤器的优先级，数字越小，优先级越高；
    @Override
    public int filterOrder() {
        return 1;
    }

    // 方法返回boolean类型，true时表示是否执行该过滤器的run方法，false则表示不执行；
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 过滤器的过滤逻辑。
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        System.out.println("请求URI:" + uri);
        System.out.println("HTTP Method:" + method);
        System.out.println("请求IP:" + host);
        if (null == requestContext.getRequest().getHeader("userName")) {
            // 如果没传header 不往下走
            // requestContext.setSendZuulResponse(false);
            // requestContext.setResponseStatusCode(401); // 响应 401 状态码

            // 如果没传header 手动添加一个
            requestContext.getZuulRequestHeaders().put("userName", "cq");
            return null;
        }

        return null;
    }
}
