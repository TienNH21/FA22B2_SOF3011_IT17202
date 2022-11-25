package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import entities.SinhVien;
import models.DangKyModel;
import repository.SinhVienRepository;
import utils.JpaUtil;

@WebServlet({
	"/dang-ky/get-form",
	"/dang-ky/submit",
})
public class DangKyServlet extends HttpServlet {
	private SinhVienRepository svRepo;
       
    public DangKyServlet() {
        super();
        this.svRepo = new SinhVienRepository();
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
		
		SinhVien sv = new SinhVien();
		sv.setAvatar(null);
		sv.setPassword("123456");
		sv.setHoTen( model.getHoTen() );
		sv.setEmail( model.getEmail() );
		sv.setSdt( model.getSdt() );
		sv.setDiaChi( model.getDiaChi() );
		sv.setChuyenNganhId( model.getChuyenNganh() );
		sv.setGioiTinh( model.getGioiTinh() );
		try {
			this.svRepo.insert(sv);
		} catch (Exception e) {
			// Báo lỗi
			
			e.printStackTrace();
		}

		response.sendRedirect("/IT17202/dang-ky/get-form");
	}

}
