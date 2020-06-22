package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.AuthUtil;

public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		   HttpServletRequest req = (HttpServletRequest) request;
		   HttpServletResponse res = (HttpServletResponse) response;
		   if(!AuthUtil.checkLogin(req, res)) {
			   res.sendRedirect(req.getContextPath()+"/login");
			   return;
		   }
	        // Cho phép request được đi tiếp. (Vượt qua Filter này).
	        chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
