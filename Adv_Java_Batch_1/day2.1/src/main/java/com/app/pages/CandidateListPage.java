package com.app.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CandidateListPage
 */
@WebServlet("/candidate_list")
public class CandidateListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 . set resp cont type
		response.setContentType("text/html");
		// 2. PW
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5> In candidate list page <h5>");
			// 3. read cookie from the request header
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies)
					if (c.getName().equals("user_info")) {
						pw.print("<h5> Use details " + c.getValue() + "</h5>");
						break;
					}
			} else
				pw.print("<h5> Can't remember the clnt , No Cookies!!!!!!</h5>");

		} // pw.close --> pw.flush --> resp sent to the clnt
	}

}
