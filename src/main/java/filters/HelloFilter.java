package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter({ "/hello" })
public class HelloFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("HelloFilter@init");
	}

	@Override
	public void doFilter(
		ServletRequest request,
		ServletResponse response,
		FilterChain chain
	) throws IOException, ServletException {
		System.out.println("HelloFilter@doFilter: before");
		// Code before Servlet
		
		chain.doFilter(request, response);
		
		// Code after Servlet
		System.out.println("HelloFilter@doFilter: after");
	}

	@Override
	public void destroy() {
		System.out.println("HelloFilter@destroy");
	}

}
