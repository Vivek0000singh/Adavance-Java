package com.cdac.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {

			int number1 = Integer.parseInt(request.getParameter("num1"));
			int number2 = Integer.parseInt(request.getParameter("num2"));
			String operation = request.getParameter("action");
			double result = 0;
			switch (operation) {
			case "add":
				result = number1 + number2;
				break;
			case "subtract":
				result = number1 - number2;
				break;
			case "multiply":
				result = number1 * number2;
				break;
			case "divide":
				result = number1 / number2;
				break;

			default:
				break;
			}

			if (result >= 0) {

				Cookie c1 = new Cookie("positive_result_detail", String.valueOf(result));

				response.addCookie(c1);
				response.sendRedirect("positive_result");

			} else {

				Cookie c2 = new Cookie("negative_result_detail", String.valueOf(result));

				response.addCookie(c2);
				response.sendRedirect("negative_result");

			}

		}
	}

}
