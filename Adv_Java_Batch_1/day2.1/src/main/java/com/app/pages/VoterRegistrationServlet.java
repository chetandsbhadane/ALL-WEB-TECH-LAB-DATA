package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.UserDaoImpl;
import com.app.entities.User;

/**
 * Servlet implementation class VoterRegistrationServlet
 */
@WebServlet("/voter_register")
public class VoterRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;


	public void init() throws ServletException {
		try {
			// create user dao instance
			userDao = new UserDaoImpl();
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
	public void destroy() {
		try {
			// clean up dao
			userDao.cleanUp();
		} catch (Exception e) {
//			throw new RuntimeException
//			("err in destory of " + getClass(), e);
			System.out.println("err in destroy !");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. set resp cont type
				response.setContentType("text/html");
				// 2. get PW to send text , buffered resp
				try (PrintWriter pw = response.getWriter()) {
					// 3. read req params
					String fname = request.getParameter("fn");
					String lname = request.getParameter("ln");
					String email = request.getParameter("em");
					String pwd = request.getParameter("pass");
					String dob = request.getParameter("dob");
					LocalDate dt1 = LocalDate.parse(dob);
					Date dt = Date.valueOf(dt1);
					
					User newVoter = new User(fname, lname, email, pwd, dt);	
					
					LocalDate reqdt = LocalDate.now().minusYears(21);
					
					if(reqdt.isBefore(dt1)) {
						pw.print("<h5>Invalid Age , Please <a href='voter_register.html'>Retry</a></h5>");
					} else {
						String msg = userDao.voterRegistration(newVoter);
						pw.print("<h5>"+msg+"  You can <a href='login.html'>Login</a> now..</h5>");
					}
				} catch (Exception e) {
					// re throw the exc to the caller (WC)
					throw new ServletException("err in doPost of " + getClass(), e);
			}

		}
}
