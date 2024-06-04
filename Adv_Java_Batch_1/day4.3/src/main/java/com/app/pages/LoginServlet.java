package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.CandidateDaoImpl;
import com.app.dao.UserDaoImpl;
import com.app.entities.User;

import static com.app.utils.DBUtils.*;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(value = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	private CandidateDaoImpl candidateDao;

//	public LoginServlet(String name) {
//		System.out.println("in paramterized ctor");
//	}
	public LoginServlet() {
		System.out.println("in def ctor");
	}

	/**
	 * @see Servlet#init()
	 */
	@Override
	public void init()  throws ServletException {
		try {
			//get servlet config			
			ServletConfig config=getServletConfig();
			String url=config.getInitParameter("db_url");
			String name=config.getInitParameter("user_name");
			String pwd=config.getInitParameter("password");
			// open cn
			openConnection(url,name,pwd);
			// create user dao instance
			userDao = new UserDaoImpl();
			candidateDao = new CandidateDaoImpl();
		} catch (Exception e) {
			System.out.println(e);
			// re throw the exc to WC to inform about init failure
			// API - ServletException(String mesg , Throwable rootCause)
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		try {
			// clean up dao
			userDao.cleanUp();
			candidateDao.cleanUp();
			// close db cn
			closeConnection();
		} catch (Exception e) {
//			throw new RuntimeException
//			("err in destory of " + getClass(), e);
			System.out.println("err in destroy !");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set resp cont type
		response.setContentType("text/html");
		// 2. get PW to send text , buffered resp
		try (PrintWriter pw = response.getWriter()) {
			// 3. read req params
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");
			// 4.invoke dao's method for user authentication
			User user = userDao.signIn(email, pwd);
			if (user == null) {
				// => invalid login
				pw.print("<h5>Invalid Login , Please <a href='login.html'>Retry</a></h5>");
			} else {
				// 5. get HttpSession from WC
				HttpSession session = request.getSession();
				System.out.println("session new " + session.isNew());// t
				System.out.println("session ID " + session.getId());
				// 6. save user details under session scope
				session.setAttribute("user_details", user);
				// 7. save user dao instance in session scoped attr map
				session.setAttribute("user_dao", userDao);
				// 7. save candidate dao instance in session scoped attr map
				session.setAttribute("candidate_dao", candidateDao);

				pw.print("successful login!!!!");// contents are discarded !
				// pw.flush();
				// valid login , continue to role based authorization
				if (user.getRole().equals("admin"))
					response.sendRedirect("admin_page");
				else {
					// voter role
					if (user.isStatus()) // alrdy voted
						response.sendRedirect("logout");
					else // not yet voted
						response.sendRedirect("candidate_list");
					/*
					 * WC --send temp redirect resp SC 302 , Header -Set-Cookie : user_info",
					 * user.toString() Location : candidate_list body : EMPTY Web browser --sends
					 * NEXT req URL - http://host:port/ctx_path/candidate_list Method - GET Header -
					 * Cookie - user_info", user.toString()
					 */
				}
			}
		} catch (Exception e) {
			// re throw the exc to the caller (WC)
			throw new ServletException("err in doPost of " + getClass(), e);
		}

	}

}
