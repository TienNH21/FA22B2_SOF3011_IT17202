package controllers.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Lop;
import repository.LopRepository;

@WebServlet({
	"/admin/lop/index"
})
public class LopServlet extends HttpServlet {
	private LopRepository lopRepo;
       
    public LopServlet() {
        super();
        
        this.lopRepo = new LopRepository();
    }

	protected void doGet(
		HttpServletRequest request, 
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("index"))
		{
			this.index(request, response);
		}
	}
	
	public void index(
		HttpServletRequest request, 
		HttpServletResponse response
	) throws ServletException, IOException {
		List<Lop> ds = this.lopRepo.getAll();
		Lop lop = ds.get(0);
		String cn = lop.getChuyenNganh().getTen();
		System.out.println(cn);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
