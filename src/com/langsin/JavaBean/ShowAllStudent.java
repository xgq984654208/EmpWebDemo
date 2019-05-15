package com.langsin.JavaBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShowAllStudent")
public class ShowAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ShowAllStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		Map<String, ArrayList<User>> stuMap = new LinkedHashMap<>();
		ArrayList<User> e50 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User st = new User();
			st.setName("小明"+i);
			st.setAge(19);
			st.setGender("男");
			st.setClassNum("1000010"+i);
			e50.add(st);
		}
		stuMap.put("e50", e50);
		
		ArrayList<User> e51 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			User st = new User();
			st.setName("小Liang"+i);
			st.setAge(19);
			st.setGender("女");
			st.setClassNum("1000020"+i);
			e51.add(st);
		}
		stuMap.put("e51", e51);
	
		session.setAttribute("stuMap", stuMap);
		response.sendRedirect("/FirstWeb/ShowAllStudent.jsp");
		//request.setAttribute("stuMap", stuMap);
	//	request.getRequestDispatcher("/FirstWeb/ShowAllStudent.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
