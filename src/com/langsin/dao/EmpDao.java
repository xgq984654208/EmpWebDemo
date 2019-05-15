package com.langsin.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.langsin.JavaBean.Condition;
import com.langsin.JavaBean.Emp;
import com.langsin.JavaBean.PageBean;
import com.langsin.utils.JdbcUtilis;

public class EmpDao {
	public void f1() {
		Connection conn = JdbcUtilis.getConnection();
		PreparedStatement pre = null;
		try {
			conn.setAutoCommit(false);
			String sql = "select empno,ename,gender,job,sal,COMM from emp";
			pre = conn.prepareStatement(sql);
			pre.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JdbcUtilis.release(pre, null, conn);
		}

	}

	public void addEmp(Emp emp) {
		// TODO Auto-generated method stub
		Connection conn = JdbcUtilis.getConnection();
		PreparedStatement pre = null;
		try {

			conn.setAutoCommit(false);
			String sql = "insert into emp values(NULL,?,?,?,?,?,?)";
			pre = conn.prepareStatement(sql);

			pre.setInt(1, emp.getEmpno());
			pre.setString(2, emp.getEname());
			pre.setString(3, emp.getGender());
			pre.setString(4, emp.getJob());
			pre.setBigDecimal(5, emp.getSal());
			pre.setBigDecimal(6, emp.getCOMM());
			pre.executeUpdate();

			conn.commit();

		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			JdbcUtilis.release(pre, null, conn);
		}
	}

	public ArrayList<Emp> initEmp() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Connection conn = JdbcUtilis.getConnection();
		PreparedStatement pre = null;
		ArrayList<Emp> list = new ArrayList<>();
		ResultSet set = null;
		try {

			conn.setAutoCommit(false);

			String sql = "select empno,ename,gender,job,sal,COMM from emp";
			pre = conn.prepareStatement(sql);
			set = pre.executeQuery();
			while (set.next()) {
				int empno = set.getInt(1);
				String ename = set.getString(2);
				String gender = set.getString(3);
				String job = set.getString(4);
				BigDecimal sal = set.getBigDecimal(5);
				BigDecimal COMM = set.getBigDecimal(6);

				Emp emp = new Emp();
				emp.setCOMM(COMM);
				emp.setEmpno(empno);
				emp.setEname(ename);
				emp.setGender(gender);
				emp.setJob(job);
				emp.setSal(sal);

				list.add(emp);

			}

			conn.commit();
			return list;

		} catch (Exception e) {
			// TODO: handle exception
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			JdbcUtilis.release(pre, set, conn);
		}

		return null;
	}

	public void delEmp(String[] checks) {

		Connection conn = JdbcUtilis.getConnection();
		PreparedStatement pre = null;
		try {
			conn.setAutoCommit(false);
			String sql = "delete from emp where empno = ?";
			for (int i = 0; i < checks.length; i++) {
				pre = conn.prepareStatement(sql);
				pre.setInt(1, Integer.parseInt(checks[i]));
				pre.executeUpdate();

			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JdbcUtilis.release(pre, null, conn);
		}

	}

	public void changeEmp(Emp emp) {
		// TODO Auto-generated method stub

		Connection conn = JdbcUtilis.getConnection();
		PreparedStatement pre = null;
		try {
			conn.setAutoCommit(false);
			String sql = "update emp set job=?,sal=?,COMM=? where empno=?";
			pre = conn.prepareStatement(sql);

			pre.setString(1, emp.getJob());
			pre.setBigDecimal(2, emp.getSal());
			pre.setBigDecimal(3, emp.getCOMM());
			pre.setInt(4, emp.getEmpno());
			pre.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JdbcUtilis.release(pre, null, conn);
		}

	}

	public ArrayList<Emp> search(Condition condition) {

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		Connection conn = JdbcUtilis.getConnection();
		PreparedStatement pre = null;
		ArrayList<Emp> empList = new ArrayList<>();
		ResultSet set = null;
		try {
			conn.setAutoCommit(false);
			String sql = "select empno,ename,gender,job,sal,COMM from emp where 1=1 ";

			if (!condition.getEname().equals("")) {
				sql = sql + "and ename='" + condition.getEname() + "'";
			}
			if (!condition.getJob().equals("null")) {
				sql = sql + "and job ='" + condition.getJob() + "'";
			}
//			if (!condition.getGender().equals("")) {
//				sql = sql + "and gender = '" + condition.getGender() + "'";
//			}
			if (condition.getCOMM()!=null) {
				sql = sql + "and COMM = " + condition.getCOMM();
			}
			if (!condition.getLeftSal().equals("") && !condition.getRightSal().equals("")) {
				sql = sql + "and sal between  " + Integer.parseInt(condition.getLeftSal()) + " and "
						+ Integer.parseInt(condition.getRightSal());
			} else if (condition.getLeftSal().equals("") && !condition.getRightSal().equals("")) {
				sql = sql + "and sal between 0 and " + Integer.parseInt(condition.getRightSal());
			} else if (!condition.getLeftSal().equals("") && condition.getRightSal().equals("")) {
				sql = sql + "and sal between " + Integer.parseInt(condition.getLeftSal()) + " and 99999999";
			}
			System.out.println(sql);
			pre = conn.prepareStatement(sql);
			set = pre.executeQuery();
			while (set.next()) {
				int empno = set.getInt(1);
				String ename = set.getString(2);
				String gender = set.getString(3);
				String job = set.getString(4);
				BigDecimal sal = set.getBigDecimal(5);
				BigDecimal COMM = set.getBigDecimal(6);

				Emp emp = new Emp();
				emp.setCOMM(COMM);
				emp.setEmpno(empno);
				emp.setEname(ename);
				emp.setGender(gender);
				emp.setJob(job);
				emp.setSal(sal);

				empList.add(emp);

			}
			
		//	pre.executeUpdate();
			conn.commit();
			return empList;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtilis.release(pre, set, conn);
		}

		return null;

	}

	public PageBean<Emp> PageEmp(PageBean<Emp> pBean) {
		// TODO Auto-generated method stub
		pBean.setTotalrecord(getTotalRecord());
		pBean.setTotalpage();
		
		Connection conn = JdbcUtilis.getConnection();
		PreparedStatement pre = null;
		ResultSet set = null;
		ArrayList<Emp> list = new ArrayList<>();
		try {
			conn.setAutoCommit(false);
			String sql = "select empno,ename,gender,job,sal,COMM from emp limit ?,?";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, (pBean.getPagecode()-1)*pBean.getPagesize()+1);
			pre.setInt(2, pBean.getPagesize());
			set = pre.executeQuery();
			
			while(set.next()) {
				int empno = set.getInt(1);
				String ename = set.getString(2);
				String gender = set.getString(3);
				String job = set.getString(4);
				BigDecimal sal = set.getBigDecimal(5);
				BigDecimal COMM = set.getBigDecimal(6);

				Emp emp = new Emp();
				emp.setCOMM(COMM);
				emp.setEmpno(empno);
				emp.setEname(ename);
				emp.setGender(gender);
				emp.setJob(job);
				emp.setSal(sal);

				list.add(emp);
			}
			pBean.setBeanList(list);
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtilis.release(pre, null, conn);
		}

	
		return pBean;
	}
	public static int getTotalRecord() {

		Connection conn = JdbcUtilis.getConnection();
		PreparedStatement pre = null;
		ResultSet set = null;
		try {
			conn.setAutoCommit(false);
			String sql = "select count(*) from emp";
			pre = conn.prepareStatement(sql);
			set = pre.executeQuery();
			set.next();
			int pr = set.getInt(1);
			conn.commit();
			return pr;
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JdbcUtilis.release(pre, null, conn);
		}
		return 0;

	
	}

	public boolean Login(String name, String pass) {
		// TODO Auto-generated method stub

		Connection conn = JdbcUtilis.getConnection();
		PreparedStatement pre = null;
		ResultSet set = null;
		try {
			conn.setAutoCommit(false);
			String sql = "select password from user where name = ?";
			pre = conn.prepareStatement(sql);
			pre.setString(1, name);
			set = pre.executeQuery();
			if(set==null) {
				return false;
			}else {
				set.next();
				String password = set.getString(1);
				if(password.equals(pass)) {
					conn.commit();
					return true;
				}else return false;
			}
			
			
			
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JdbcUtilis.release(pre, null, conn);
		}

	
		return false;
	}

	public void Register(String name, String pass) {
		// TODO Auto-generated method stub

		Connection conn = JdbcUtilis.getConnection();
		PreparedStatement pre = null;
		try {
			conn.setAutoCommit(false);
			String sql = "insert into user value(?,?)";
			pre = conn.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, pass);
			pre.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JdbcUtilis.release(pre, null, conn);
		}

	
		
	}

}
