package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.PatientDao;
import com.app.dao.PatientDaoImpl;
import com.app.pojos.Patient;

/**
 * Servlet implementation class PatientRegisterServlet
 */
@WebServlet("/patient_register")
public class PatientRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PatientDaoImpl patientDao;


	public void init() throws ServletException {
		try {
			// create user dao instance
			patientDao = new PatientDaoImpl();
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
			patientDao.cleanUp();
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
	
		response.setContentType("text/html");
	
		try (PrintWriter pw = response.getWriter()) {
		
			String fname = request.getParameter("fn");
			String lname = request.getParameter("ln");
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");
			String role = request.getParameter("role");
			System.out.println(role);
			
			Patient newPatient = new Patient(fname, lname, email, pwd);	
			
			if(role.equals("admin")) {
				newPatient.setRole(role);
				pw.print("<h5>"+"Admin............  You can <a href='login.html'>Login</a> now..</h5>");
			}
			else {
				newPatient.setRole(role);
				String msg = patientDao.voterRegistration(newPatient);
				pw.print("<h5>"+msg+"Patient...........  You can <a href='login.html'>Login</a> now..</h5>");
			}

			
		} catch (Exception e) {

			throw new ServletException("err in doPost of " + getClass(), e);
	}
	}

}
