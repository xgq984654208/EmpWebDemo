package com.langsin.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object object = session.getAttribute("username");
		if(object!=null) {
			chain.doFilter(request, response);
		}else {
			res.sendRedirect("/FirstWeb/Login.jsp");
		}
		
		
//		Enumeration<String> attributeNames = session.getAttributeNames();
//		Iterator<String> asIterator = attributeNames.asIterator();
//		while (asIterator.hasNext()) {
//			String password = (String) session.getAttribute(asIterator.next());
//			if (password.equals(session.getAttribute(password))) {
//				System.out.println(password + "+++++" + session.getAttribute(password));
//				chain.doFilter(request, response);
//				break;
//			} else {
//				res.sendRedirect("/FirstWeb/Login.jsp");
//			}
//		}
//		if (!session.) {
//			System.out.println("转达到登陆界面");
//			res.sendRedirect("/FirstWeb/Login.jsp");
//		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
