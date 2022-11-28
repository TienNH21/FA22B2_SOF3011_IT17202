package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.SinhVien;
import utils.JpaUtil;

public class SinhVienRepository {
	private EntityManager em;
	
	public SinhVienRepository()
	{
		this.em = JpaUtil.getEntityManager();
	}
	
	public void insert(SinhVien sv) throws Exception
	{
		try {
			em.getTransaction().begin();
			em.persist(sv);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	
	public void update(SinhVien sv) throws Exception
	{
		try {
			em.getTransaction().begin();
			em.merge(sv);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}

	public void delete(SinhVien sv) throws Exception
	{
		try {
			em.getTransaction().begin();
			em.detach(sv);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public List<SinhVien> getAll()
	{
//		String sql = "SELECT * FROM sinh_vien";
		String jpql = "SELECT sv FROM SinhVien sv";
		TypedQuery<SinhVien> query =
			this.em.createQuery(jpql, SinhVien.class);
		
		return query.getResultList();
	}
	
	public SinhVien findById(int id)
	{
		return this.em.find(SinhVien.class, id);
	}
}
