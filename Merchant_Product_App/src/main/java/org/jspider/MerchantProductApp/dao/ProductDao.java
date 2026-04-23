package org.jspider.MerchantProductApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspider.MerchantProductApp.dto.Merchant;
import org.jspider.MerchantProductApp.dto.Product;

public class ProductDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	public Product findProductById(int pid) {
		Product p=em.find(Product.class, pid);
		if(p!=null) {
			return p;
		}
		else {
		return null;
		}
	}
	public List<Product> findProductByBrandAndCategory(String pb, String pc) {
		Query q=em.createQuery("Select p from Product p where p.brand=?1 and p.category=?2");
		q.setParameter(1, pb);
		q.setParameter(2, pc);
		List<Product> l= q.getResultList();
		if(l.size()>0) {
			return l;
		}
		else {
			return null;
		}
	}
	public List<Product> findProductByMerchantId(int mid) {
		Query q=em.createQuery("Select p from Product p where p.m.id=?1");
		q.setParameter(1, mid);
		List<Product> l= q.getResultList();
		if(l.size()>0) {
			return l;
		}
		else {
			return null;
		}
	}
	public Product addProduct(Product p, int mid) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		Merchant m=em.find(Merchant.class, mid);
		if(m!=null) {
			p.setM(m);
			m.getProds().add(p);
			et.commit();
			return p;
		}
		else {
			return null;
		}
	}
	public Product updateProduct(Product p) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		Product pdb=em.find(Product.class, p.getId());
		if(pdb!=null) {
			pdb.setName(p.getName());
			pdb.setBrand(p.getBrand());
			pdb.setCategory(p.getCategory());
			pdb.setCost(p.getCost());
			et.commit();
			return pdb;
		}
		else {
			return null;
		}
	}

}
