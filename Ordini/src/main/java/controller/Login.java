package controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businesscomponent.security.Algoritmo;
import businesscomponent.utilities.LoginControl;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 4399877634030437783L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = Algoritmo.converti(request.getParameter("password"));

		String userpass;
		String adminpass;

		if (username != null && password != null) {

			LoginControl lc;
			try {
				lc = new LoginControl();

				userpass = lc.getUserPass(username);
				adminpass = lc.getAdminPass(username);

				if (userpass != null) {
					if (userpass.equals(password)) {
						session.setAttribute("mod", false);
						session.setAttribute("username", username);
						response.sendRedirect("acquisti.jsp");
					} else {
						response.sendRedirect("accessonegato.jsp");
					}
				} else if (adminpass != null) {
					if (adminpass.equals(password)) {
						session.setAttribute("admin", username);
						response.sendRedirect("admin/admin.jsp");
					} else {
						response.sendRedirect("accessonegato.jsp");
					}
				} else {
					response.sendRedirect("accessonegato.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
