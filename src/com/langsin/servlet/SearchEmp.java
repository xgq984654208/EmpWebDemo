package com.langsin.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.langsin.JavaBean.Condition;
import com.langsin.JavaBean.Emp;
import com.langsin.service.EmpService;

/**
 * Servlet implementation class SearchEmp
 */
@WebServlet("/emp/SearchEmp.action")
public class SearchEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Condition condition = new Condition();
		
		String ename  = request.getParameter("ename");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String COMM = request.getParameter("COMM");
		String LeftSal = request.getParameter("LeftSal");
		String RightSal = request.getParameter("RightSal");
		System.out.println(ename+gender+job+COMM+LeftSal+RightSal);
	
		condition.setCOMM(COMM);
		condition.setEname(ename);
		condition.setGender(gender);
		condition.setJob(job);
		condition.setLeftSal(LeftSal);
		condition.setRightSal(RightSal);
		
		
		EmpService service = new EmpService();
		ArrayList<Emp> empList = service.search(condition);
		
		request.setAttribute("empList", empList);
		request.getRequestDispatcher("/emp/SearchEmp.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
