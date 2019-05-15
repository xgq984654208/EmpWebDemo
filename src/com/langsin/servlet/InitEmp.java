 package com.langsin.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.langsin.JavaBean.Emp;
import com.langsin.service.EmpService;

/**
 * Servlet implementation class InitEmp
 */
@WebServlet("/emp/InitEmp.action")
public class InitEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String operate = request.getParameter("operate");
		
		EmpService service = new EmpService();
		ArrayList<Emp> emplist = service.initEmp();
		
		request.setAttribute("empList", emplist);
		
		if("del".equals(operate)) {
			request.getRequestDispatcher("/emp/DelEmp.jsp").forward(request, response);
		}else if("change".equals(operate)) {
			request.getRequestDispatcher("/emp/ChangeEmp.jsp").forward(request, response);

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
