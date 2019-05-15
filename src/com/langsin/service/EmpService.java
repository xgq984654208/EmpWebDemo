package com.langsin.service;

import java.util.ArrayList;

import com.langsin.JavaBean.Condition;
import com.langsin.JavaBean.Emp;
import com.langsin.JavaBean.PageBean;
import com.langsin.dao.EmpDao;

public class EmpService {

	public void addEmp(Emp emp) {
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDao();
		dao.addEmp(emp);
	}

	public ArrayList<Emp> initEmp() { 
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDao();
		
		return dao.initEmp();
	}

	public void delEmp(String[] checks) {
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDao();
		dao.delEmp(checks);
	}

	public void changeEmp(Emp emp) {
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDao();
		dao.changeEmp(emp);
	}


	public ArrayList<Emp> search(Condition condition) {
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDao();
		return dao.search(condition);
	}

	public PageBean<Emp> PageEmp(PageBean<Emp> pBean) {
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDao();
		pBean = dao.PageEmp(pBean);
		return pBean;
	}

	public boolean Login(String name, String pass) {
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDao();
		
		return dao.Login(name,pass);
	}

	public void Register(String name, String pass) {
		// TODO Auto-generated method stub
		EmpDao dao = new EmpDao();
		dao.Register(name,pass);
		
	}

}
