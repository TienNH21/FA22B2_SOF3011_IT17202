package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.SinhVien;
import repository.SinhVienRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private SinhVienRepository svRepo;
       
    public LoginServlet() {
        super();
        this.svRepo = new SinhVienRepository();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp")
			.forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		SinhVien sv = this.svRepo.login(email, password);
		if (sv != null) {
			System.out.println("Login thanh cong");
			HttpSession session = request.getSession();
			session.setAttribute("user", sv);
		} else {
			System.out.println("Login that bai");
		}
	}

}
