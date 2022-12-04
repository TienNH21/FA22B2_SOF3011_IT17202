package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemoLifeCycleServlet")
public class DemoLifeCycleServlet extends HttpServlet {
	private ArrayList<Integer> list;
       
    public DemoLifeCycleServlet() {
        super();
        
        this.list = new ArrayList<Integer>();
    }

    // Mã hóa password: https://github1s.com/TienNH21/SU21B1_SOF3011_SOF3011.1
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		list.add(1);
		list.add(2);
		list.add(3);
		response.getWriter().append("Size: " + list.size());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
