package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import models.DangKyModel;

@WebServlet({
	"/dang-ky/get-form",
	"/dang-ky/submit",
})
public class DangKyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DangKyServlet() {
        super();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("/views/dangky.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DangKyModel model = new DangKyModel();
		try {
			BeanUtils.populate(model, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(model.getHoTen());
		System.out.println(model.getEmail());
		System.out.println(model.getSdt());
		System.out.println(model.getDiaChi());
		System.out.println(model.getGioiTinh());
		System.out.println(model.getChuyenNganh());

		response.sendRedirect("/IT17202/dang-ky/get-form");
	}

}
