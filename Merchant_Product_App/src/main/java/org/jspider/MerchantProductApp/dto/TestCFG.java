package org.jspider.MerchantProductApp.dto;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestCFG {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		System.out.println(emf);
	}
}
