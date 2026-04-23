package org.jspider.MerchantProductApp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jspider.MerchantProductApp.dto.Merchant;

public class MerchantDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	
	public Merchant saveMerchant(Merchant m) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(m);
		et.commit();
		return m;
	}

	public Merchant updateMerchant(Merchant m) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		Merchant mdb=em.find(Merchant.class, m.getId());
		if(mdb!=null) {
			mdb.setName(m.getName());
			mdb.setGst_num(m.getGst_num());
			mdb.setEmail(m.getEmail());
			mdb.setPhone(m.getPhone());
			mdb.setPassword(m.getPassword());
			et.commit();
			return mdb;
		}else {
			return null;
		}
	}

	public Merchant findMerchantById(int mid) {
		Merchant m=em.find(Merchant.class, mid);
		if(m!=null) {
			return m;
		}
		else {
			return null;
		}
	}

	public Merchant findMerchantByEmailAndPassword(String me, String mp) {
		Query q=em.createQuery("Select m from Merchant m where m.email=?1 and m.password=?2");
		q.setParameter(1, me);
		q.setParameter(2, mp);
		try {
			Merchant m=(Merchant) q.getSingleResult();
			return m;
		}
		catch(NoResultException e) {
		return null;
		}
	}

	public Merchant findMerchantByEmailAndPassword(long mph, String mp) {
		Query q=em.createQuery("Select m from Merchant m where m.phone=?1 and m.password=?2");
		q.setParameter(1, mph);
		q.setParameter(2, mp);
		try {
			Merchant m=(Merchant) q.getSingleResult();
			return m;
		}
		catch(NoResultException e) {
		return null;
		}

	}

}
