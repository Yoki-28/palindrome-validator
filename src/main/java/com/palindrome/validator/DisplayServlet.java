package com.palindrome.validator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.print("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <style>\r\n"
				+ "        body\r\n"
				+ "        {\r\n"
				+ "            font-family: Arial, sans-serif;\r\n"
				+ "            background-color: #f4f4f4;\r\n"
				+ "            display: flex;\r\n"
				+ "            justify-content: center;\r\n"
				+ "            align-items: center;\r\n"
				+ "            height: 100vh;\r\n"
				+ "            margin: 0px;\r\n"
				+ "        }\r\n"
				+ "        .container\r\n"
				+ "        {\r\n"
				+ "            background-color: #fff;\r\n"
				+ "            padding: 20px;\r\n"
				+ "            border-radius: 10px;\r\n"
				+ "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
				+ "        }\r\n"
				+ "        table\r\n"
				+ "        {\r\n"
				+ "            width: 100%;\r\n"
				+ "            border-collapse: collapse;\r\n"
				+ "            /* margin-top: 20px; */\r\n"
				+ "        }\r\n"
				+ "        table,tr,td\r\n"
				+ "        {\r\n"
				+ "            border: 1px solid #ddd;\r\n"
				+ "        }\r\n"
				+ "        th,td\r\n"
				+ "        {\r\n"
				+ "            padding: 10px;\r\n"
				+ "            text-align: left;\r\n"
				+ "        }\r\n"
				+ "        th\r\n"
				+ "        {\r\n"
				+ "            background-color: #f2f2f2 ;\r\n"
				+ "        }\r\n"
		        + "        a\r\n"
				+ "		   {\r\n"
		        + "            margin: 5px;\r\n"
		        + "            padding: 5px 10px;\r\n"
		        + "            font-size: 14px;\r\n"
		        + "            cursor: pointer;\r\n"
		        + "            text-decoration: none;\r\n"
		        + "            border-radius: 5px;\r\n"
		        + "            color: white;\r\n"
		        + "            transition: background-color 0.3s;\r\n"
		        + "        }\r\n"
				+ "		   button\r\n"
				+ "		   {\r\n"
				+ "			   width: 100%;\r\n"
				+ "			   padding: 10px;\r\n"
				+ "			   background-color: #dc3545;\r\n"
				+ "			   color: white;\r\n"
				+ "			   border: none;\r\n"
				+ "			   border-radius: 5px;\r\n"
				+ "			   font-size: 16px;\r\n"
				+ "			   cursor: pointer;\r\n"
				+ "	           transition:background-color 0.3s;\r\n"
				+ "			   margin-top: 15px;\r\n"
				+ " 	   }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"container\">\r\n"
				+ "        <h1>Palindrome Input Table</h1>\r\n"
				+ "        <table>\r\n"
				+ "            <thead>\r\n"
				+ "                <tr>\r\n"
				+ "                    <th>Input</th>\r\n"
				+ "                    <th>If Yes</th>\r\n"
				+ "                    <th>If No</th>\r\n"
				+ "                </tr>\r\n"
				+ "            </thead>\r\n"
				+ "            <tbody>");
		InputServices is = new InputServices();
		List<InputClass> li = is.displayAll();
		
		for(InputClass ic : li) {
			pw.print("<tr>\r\n"
					+ "		<td>"+ic.getInput()+"</td>\r\n"
					+ "     <td>"+ic.getYes()+"</td>\r\n"
					+ "     <td>"+ic.getNo()+"</td>\r\n"
					+ "</tr>");
		}
		pw.print("</tbody>\r\n"
				+ "        </table>\r\n"
				+ " 	   <button><a href="+"deleteForm.html"+">Delete an Input</a></button>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
}
