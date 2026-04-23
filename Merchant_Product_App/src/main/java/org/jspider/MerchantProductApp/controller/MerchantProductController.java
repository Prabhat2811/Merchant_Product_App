package org.jspider.MerchantProductApp.controller;

import java.util.List;
import java.util.Scanner;

import org.jspider.MerchantProductApp.dao.MerchantDao;
import org.jspider.MerchantProductApp.dao.ProductDao;
import org.jspider.MerchantProductApp.dto.Merchant;
import org.jspider.MerchantProductApp.dto.Product;

public class MerchantProductController {
	static Scanner sc=new Scanner(System.in);
	static MerchantDao mdao=new MerchantDao();
	static ProductDao pdao=new ProductDao();
	static {
		System.out.println();
		System.out.println(" WELCOME TO MERCHANT - PRODUCT APPLICATION");
	}
	
	public static void main(String[] args) {
		String s="--------------------------------------";
		
		System.out.println();
		System.out.println(s);
		System.out.println();
		System.out.println("1. Save Merchant Info");
		System.out.println("2. Update Merchant");
		System.out.println("3. Find Merchant by Id");
		System.out.println("4. Find Merchant by Email and Password");
		System.out.println("5. Verify Merchant by Phone and Password");
		
		System.out.println("6. Add Product");
		System.out.println("7. Update Product");
		System.out.println("8. Find Product by Id");
		System.out.println("9. Find Product by Brand and Category");
		System.out.println("10. Find Product by Merchant Id");
		System.out.println();
		System.out.println(s);
		System.out.println();
		
		System.out.print("Enter the Choice : ");
		int choice=sc.nextInt();
		switch(choice) {
		case 1: saveMerchant(); main(args);
		break;
		
		case 2: updateMerchant(); main(args);
		break;
		
		case 3: findMerchantById(); main(args);
		break;
		
		case 4: findMerchantByEmailAndPassword(); main(args);
		break;
		
		case 5: verifyMerchantByPhoneAndPassword(); main(args);
		break;
		
		case 6: addProduct(); main(args);
		break;
		
		case 7: updateProduct(); main(args);
		break;
		
		case 8: findProductById(); main(args);
		break;
		
		case 9: findProductByBrandAndCategory(); main(args);
		break;
		
		case 10: findProductByMerchantId(); main(args);
		break;
		
		default : System.err.println("Invalid Choice !");  main(args);
		}
		
		
		
	}

	private static void updateProduct() {
		Product p=new Product();
		System.out.print("Enter Product Id : ");
		p.setId(sc.nextInt());
		System.out.print("Enter Product Name : ");
		p.setName(sc.next());
		System.out.print("Enter Product Brand : ");
		p.setBrand(sc.next());
		System.out.print("Enter Product Category : ");
		p.setCategory(sc.next());
		System.out.print("Enter Product Price : ");
		p.setCost(sc.nextDouble());
		Product pdb=pdao.updateProduct(p);
		if(pdb!=null) {
			System.out.println(pdb);
		}else {
			System.err.println("Invalid Product ID !");
		}
		
	}

	private static void addProduct() {
		System.out.print("Enter Merchant Id : ");
		int mid=sc.nextInt();
		
		Product p=new Product();
		System.out.print("Enter the Product Name : ");
		p.setName(sc.next());
		System.out.print("Enter Product Brand : ");
		p.setBrand(sc.next());
		System.out.print("Enter Product Category : ");
		p.setCategory(sc.next());
		System.out.print("Enter Product Price : ");
		p.setCost(sc.nextDouble());
		Product pdb=pdao.addProduct(p, mid);
		if(pdb!=null) {
			System.out.println(pdb);
		}
		else {
			System.err.println("Merchant Not Found");
		}
		
	}

	private static void findProductByMerchantId() {
		System.out.print("Enter Merchant Id : ");
		int mid=sc.nextInt();
		List<Product> p=pdao.findProductByMerchantId(mid);
		if(p!=null) {
			p.forEach(q->System.out.println(q));
		}
		else {
			System.err.println("No Record Found !");
		}
		
	}

	private static void findProductByBrandAndCategory() {
		System.out.print("Enter Product Brand : ");
		String pb=sc.next();
		System.out.print("Enter Product Category : ");
		String pc=sc.next();
		
		List<Product> p=pdao.findProductByBrandAndCategory(pb,pc);
		if(p!=null) {
			System.out.println(p);
		}
		else {
			System.err.println("No Record Found !");
		}
		
	}

	private static void findProductById() {
		System.out.print("Enter Product Id : ");
		int pid=sc.nextInt();
		Product p=pdao.findProductById(pid);
		if(p!=null) {
			System.out.println(p);
		}
		else {
			System.err.println("No Record Found !");
		}
	}

	private static void verifyMerchantByPhoneAndPassword() {
		System.out.print("Enter Merchant Phone Number : ");
		long mph=sc.nextLong();
		System.out.print("Enter Merchant Password : ");
		String mp=sc.next();
		
		Merchant m=mdao.findMerchantByEmailAndPassword(mph,mp);
		if(m!=null) {
			System.out.println(m);
		}
		else {
			System.err.println("No Record Found");
		}
	}

	private static void findMerchantByEmailAndPassword() {
		System.out.print("Enter Merchant Email : ");
		String me=sc.next();
		System.out.print("Enter Merchant Password : ");
		String mp=sc.next();
		
		Merchant m=mdao.findMerchantByEmailAndPassword(me,mp);
		if(m!=null) {
			System.out.println(m);
		}
		else {
			System.err.println("No Record Found");
		}
	}

	private static void findMerchantById() {
		System.out.print("Enter Merchant Id : ");
		int mid=sc.nextInt();
		
		Merchant m=mdao.findMerchantById(mid);
		if(m!=null) {
			System.out.println(m);
		}
		else {
			System.err.println("No Record Found");
		}
		
}

	private static void updateMerchant() {
		Merchant m=new Merchant();
		
		System.out.print("Enter Merchant Id :");
		m.setId(sc.nextInt());
		System.out.print("Enter Merchant Name :");
		m.setName(sc.next());
		System.out.print("Enter Merchant GST Number :");
		m.setGst_num(sc.next());
		System.out.print("Enter Merchant Phone Number :");
		m.setPhone(sc.nextLong());
		System.out.print("Enter Merchant Email :");
		m.setEmail(sc.next());
		System.out.print("Enter Merchant Password :");
		m.setPassword(sc.next());
		Merchant mdb=mdao.updateMerchant(m);
		if(mdb!=null) {
			System.out.println("Record Updated With Id -> "+mdb.getId());
		}
		else {
			System.out.println("No Record Found !");
		}
		
	}

	private static void saveMerchant() {
		Merchant m=new Merchant();
		System.out.print("Enter Merchant Name : ");
		m.setName(sc.next());
		System.out.print("Enter Merchant GST Number : ");
		m.setGst_num(sc.next());
		System.out.print("Enter Merchant Phone Number : ");
		m.setPhone(sc.nextLong());
		System.out.print("Enter Merchant Email : ");
		m.setEmail(sc.next());
		System.out.print("Enter Merchant Password : ");
		m.setPassword(sc.next());
		
		Merchant mdb=mdao.saveMerchant(m);
		System.out.println("Merchant Record Inserted with Merchant Id -> "+m.getId());
	}
}
