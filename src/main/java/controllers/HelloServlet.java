package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        super();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String user = request.getParameter("user");
		String data = user == null ? "" : user;

		List<String> ds = new ArrayList<>();
		ds.add("COM108");
		ds.add("COM1071");
		ds.add("SOF203");
		ds.add("SOF3011");

		request.setAttribute("data", data);
		request.setAttribute("ds", ds);
		request.setAttribute("view", "/views/hello.jsp");
		request.getRequestDispatcher("/views/layout.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		System.out.println("doPost");
		String user = request.getParameter("user");
		System.out.println(user);
		request.getRequestDispatcher("/views/hello.jsp")
		.forward(request, response);
	}


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet@service");
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("HelloServlet@destroy");
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("HelloServlet@init");
		super.init();
	}

	
}
