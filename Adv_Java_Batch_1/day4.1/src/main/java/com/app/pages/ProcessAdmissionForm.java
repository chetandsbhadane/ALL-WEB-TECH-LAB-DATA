package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.pojos.Course;
import com.app.pojos.Student;

/**
 * Servlet implementation class ProcessAdmissionForm
 */
@WebServlet("/process_admission")
public class ProcessAdmissionForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h6>from 1st page</h6>");
			pw.flush();
			// 1. get req params from clnt
			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			int score1 = Integer.parseInt(request.getParameter("score"));
			Course chosenCourse = Course.valueOf(request.getParameter("course"));
			// 2.create student object.
			Student student = new Student(firstName, lastName, score1, chosenCourse);
			if (score1 > chosenCourse.getMinScore())
				student.setAdmitted(true);
			// 2.5 add student details under request scope : server pull
			request.setAttribute("student_details", student);
			// 3. create RD
			RequestDispatcher rd = request.getRequestDispatcher("result");
			// 4 forward
			rd.include(request, response);// WC throws IllegalStateExc : in case of alrdy committed resp !!!!
			/*
			 * WC clears resp buffer, suspends the exec of this page
			 * invokes doPost of the next page.
			 */
			System.out.println("control came back....");
			pw.print("<h6>after include</h6>");
		}
	}

}
