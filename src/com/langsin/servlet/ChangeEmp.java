package com.langsin.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.langsin.JavaBean.Emp;

/**
 * Servlet implementation class ChangeEmp
 */
@WebServlet("/emp/ChangeEmp.action")
public class ChangeEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Emp emp = new Emp();
		emp.setCOMM(new BigDecimal(request.getParameter("COMM")));
		//System.out.println(request.getParameter("empno"));
		int empno = Integer.parseInt(request.getParameter("empno"));
		emp.setEmpno(empno);
		String name = request.getParameter("ename");
		emp.setEname(name);
		String gender = request.getParameter("gender");
		emp.setGender(gender);
		String job = request.getParameter("job");
		emp.setJob(job);
		BigDecimal sal = new BigDecimal(request.getParameter("sal"));
		emp.setSal(sal);
		System.out.println(name+gender);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("/emp/SaveChange.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
