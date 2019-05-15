package com.langsin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.langsin.JavaBean.Emp;
import com.langsin.JavaBean.PageBean;
import com.langsin.service.EmpService;

/**
 * Servlet implementation class PageEmp
 */
@WebServlet("/emp/PageEmp.action")
public class PageEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageEmp() {
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
		
		int pagecode = Integer.parseInt(request.getParameter("pagecode"));
		
		PageBean<Emp> pBean = new PageBean<>();
		pBean.setPagecode(pagecode);
		pBean.setPagesize(10);
		
		EmpService service = new EmpService();
		pBean = service.PageEmp(pBean);
		
		request.setAttribute("pBean", pBean);
		request.getRequestDispatcher("/emp/PageEmp.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
