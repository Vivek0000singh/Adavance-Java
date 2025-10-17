package com.healthcare.pages;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class patientLoginServlet
 */
@WebServlet(value="/authenticate",loadOnStartup = 1)
public class patientLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		// create patient dao instance
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// patient cleanup
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set content type ,get pw 
		// get req params-email,password 
		// invoke dao's sign in method ->not null =>success ->login success message
		//send patient details -> clnt
		//null -> retry link->login.html
	}

}
