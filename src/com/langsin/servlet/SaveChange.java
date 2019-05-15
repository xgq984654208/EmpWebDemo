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
 * Servlet implementation class SaveChange
 */
@WebServlet("/emp/SaveChange.action")
public class SaveChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		Emp emp = new Emp();
		
		emp.setCOMM(new BigDecimal(request.getParameter("COMM")));
		emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
		emp.setJob(request.getParameter("job"));
		emp.setSal(new BigDecimal(request.getParameter("sal")));
		
		EmpService service = new EmpService();
		service.changeEmp(emp);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
