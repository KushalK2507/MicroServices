package com.kushal.microservices.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.protocol.RequestContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class LoggingFilter extends ZuulFilter {

	private static Logger LOG = LoggerFactory.getLogger(LoggingFilter.class);

	// Should this filter be executed.
	@Override
	public boolean shouldFilter() {
		return true;
	}

	// All the interception would done
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		LOG.info("request -> {} request uri -> {}, ", request, request.getRequestURI());

		return null;
	}

	// Belowq when we need to execute the filter.
	// "pre", "post", "error"
	@Override
	public String filterType() {
		return "pre";
	}

	// This we give the priority for the filters if we have multiple filter
	@Override
	public int filterOrder() {
		return 1;
	}

}
