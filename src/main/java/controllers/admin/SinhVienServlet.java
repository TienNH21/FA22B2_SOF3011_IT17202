package controllers.admin;

import java.io.IOException;
import java.util.List;

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
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		} else {
			this.index(request, response);
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
		String idStr = request.getParameter("id");
		int id = -1;
		// id BẮT BUỘC phải truyền
		// id phải là số
		try {
			id = Integer.parseInt(idStr);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/IT17202/admin/sinh-vien/index");
		}

		SinhVien sv = this.svRepo.findById(id);
		if (sv == null) {
			response.sendRedirect("/IT17202/admin/sinh-vien/index");
		}

		request.setAttribute("sv", sv);
		request.getRequestDispatcher("/views/admin/sinh_vien/edit.jsp")
			.forward(request, response);
	}
	
	public void delete(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = -1;
		// id BẮT BUỘC phải truyền
		// id phải là số
		try {
			id = Integer.parseInt(idStr);
			 SinhVien sv = this.svRepo.findById(id);
			this.svRepo.delete(sv);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/IT17202/admin/sinh-vien/index");
		}
		
		response.sendRedirect("/IT17202/admin/sinh-vien/index");
	}
	
	public void index(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		List<SinhVien> ds = this.svRepo.getAll();
		request.setAttribute("ds", ds);
		String view = "/views/admin/sinh_vien/index.jsp";
		request.getRequestDispatcher(view)
			.forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		} else {
			response.sendRedirect("/IT17202/admin/sinh-vien/index");
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
	
	private void update(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		DangKyModel model = new DangKyModel();
		try {
			BeanUtils.populate(model, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		SinhVien sv = new SinhVien();
		sv.setAvatar(null);
		sv.setId( id );
		sv.setPassword("123456");
		sv.setHoTen( model.getHoTen() );
		sv.setEmail( model.getEmail() );
		sv.setSdt( model.getSdt() );
		sv.setDiaChi( model.getDiaChi() );
		sv.setChuyenNganhId( model.getChuyenNganh() );
		sv.setGioiTinh( model.getGioiTinh() );
		try {
			this.svRepo.update(sv);
		} catch (Exception e) {
			// Báo lỗi
			e.printStackTrace();
		}
		
		response.sendRedirect("/IT17202/admin/sinh-vien/index");
	}

}
