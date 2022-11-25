package controllers.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import entities.SinhVien;
import models.DangKyModel;
import repository.SinhVienRepository;
@WebServlet({
	"/admin/sinh-vien/create",	// GET
	"/admin/sinh-vien/store",	// POST
	"/admin/sinh-vien/edit",	// GET
	"/admin/sinh-vien/update",	// POST
	"/admin/sinh-vien/delete",	// GET
	"/admin/sinh-vien/index",	// GET
})
public class SinhVienServlet extends HttpServlet {
	private SinhVienRepository svRepo;
    public SinhVienServlet() {
        super();
        this.svRepo = new SinhVienRepository();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("create")) {
			this.create(request, response);
		}
	}
	
	public void create(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("/views/admin/sinh_vien/create.jsp")
			.forward(request, response);
	}
	
	public void edit(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		//
	}
	
	public void delete(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		//
	}
	
	public void index(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		//
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		}
	}
	
	public void store(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
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
