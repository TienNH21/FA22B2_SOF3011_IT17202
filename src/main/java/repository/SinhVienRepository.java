package repository;

import javax.persistence.EntityManager;

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
}
