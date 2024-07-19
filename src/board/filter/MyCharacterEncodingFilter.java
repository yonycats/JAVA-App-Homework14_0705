package board.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyCharacterEncodingFilter implements Filter {

	private String encoding;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		chain.doFilter(req, resp);
		System.out.println("2. doFilter");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		if (filterConfig.getInitParameter("encoding") == null) {
			this.encoding = "UTF-8";
		} else {
			this.encoding = filterConfig.getInitParameter("encoding");
		}
		System.out.println("1. 현재 필터에서 설정된 인코딩 정보 init : " + this.encoding);
	}
	
	
	
	
	
	
	
	
	
}
