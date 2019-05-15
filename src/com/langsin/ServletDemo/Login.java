package com.langsin.ServletDemo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.langsin.service.EmpService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("username", name);
//		System.out.println(session.getAttribute(name));
//		System.out.println(session.getAttribute(name).equals("password"));
		EmpService service = new EmpService();
		boolean flag = service.Login(name,pass);
		if(flag) {
			response.sendRedirect("/FirstWeb/emp/index.jsp");
//			response.getWriter().println("<h1>������ȷ</h1>");
			
		}else {
			response.sendRedirect("/FirstWeb/Register.jsp");
			//			response.getWriter().println("<h1>����bu��ȷ</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
