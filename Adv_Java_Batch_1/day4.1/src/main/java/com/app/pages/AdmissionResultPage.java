package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.pojos.Student;

/**
 * Servlet implementation class AdmissionResultPage
 */
@WebServlet("/result")
public class AdmissionResultPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()) {
			pw.print("<h6>from 2nd page</h6>");
			//get student details from request scope
			Student s1=(Student)request.getAttribute("student_details");
			if(s1 != null)
			{
				pw.print("<h5> Hello , "+s1.getFirstName()+" "+s1.getLastName()+"</h5>");
				if(s1.isAdmitted())
					pw.print("<h5> Congratulations , you are admiited in Course "+s1.getCourse()+"</h5>");
				else
					pw.print("<h5> Sorry  , can't be  admiited in Course "+s1.getCourse()+"</h5>");
			
			}
			else
				pw.print("RD failed!!!!!!!!!!!!!");
			
		}
	}

}
