package com.palindrome.validator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/palindromeServlet")
public class PalindromeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inp = req.getParameter("input");
		if(inp.length()>0) {
			InputClass obj = new InputClass();
			obj.setInput(inp);
			if(palindromeChecker(inp)) {
				obj.setYes("Yes");
				obj.setNo("");
			}
			else {
				obj.setYes("");
				obj.setNo("No");
			}
			InputServices is = new InputServices();
			int result = is.save(obj);
			if(result!=0) {
				RequestDispatcher rd = req.getRequestDispatcher("index.html");
				rd.include(req, resp);
			}
			else {
				PrintWriter pw = resp.getWriter();
				pw.print("Palindrome is not checked for the input!");
			}
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
	}

	private boolean palindromeChecker(String inp) {
		inp=inp.toLowerCase();
		char[] ch=inp.toCharArray();
		int st=0,ed=ch.length-1;
		while(st<=ed) {
			if(ch[st]!=ch[ed]) 
				return false;
			st++;
			ed--;
		}
		return true;
	}
}
