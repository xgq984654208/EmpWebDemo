package com.langsin.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.langsin.JavaBean.Emp;
import com.langsin.service.EmpService;

/**
 * Servlet implementation class AddEmp
 */
@WebServlet("/emp/AddEmp.action")
public class AddEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Emp emp = new Emp();
		String ename = request.getParameter("ename");
		int empno = Integer.parseInt(request.getParameter("empno"));
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		BigDecimal sal = new BigDecimal(request.getParameter("sal"));
		BigDecimal COMM = new BigDecimal(request.getParameter("COMM"));
		
		emp.setEname(ename);
		emp.setCOMM(COMM);
		emp.setEmpno(empno);
		emp.setGender(gender);
		emp.setJob(job);
		emp.setSal(sal);
		System.out.println(emp.getEmpno()+emp.getEname()+emp.getGender()+emp.getJob()+emp.getCOMM()+emp.getSal());
		EmpService service = new EmpService();
		service.addEmp(emp);
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
