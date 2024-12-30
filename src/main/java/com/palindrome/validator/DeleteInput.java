package com.palindrome.validator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteInput")
public class DeleteInput extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inp = req.getParameter("input");
		
		InputServices is = new InputServices();
		int result = is.delete(inp);
		if(result!=0) {
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
		else {
			PrintWriter pw = resp.getWriter();
			pw.print("Palindrome is not checked for the input!");
		}
	}
}
