package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Lop;
import entities.SinhVien;
import utils.JpaUtil;

public class LopRepository {
	private EntityManager em;
	
	public LopRepository()
	{
		this.em = JpaUtil.getEntityManager();
	}
	

	
	public List<Lop> getAll()
	{
		String jpql = "SELECT lop FROM Lop lop";
		TypedQuery<Lop> query =
			this.em.createQuery(jpql, Lop.class);
		
		return query.getResultList();
	}
}
