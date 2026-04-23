package org.jspider.MerchantProductApp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Merchant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gst_num;
	private String email;
	private long phone;
	private String password;
	
	
	@OneToMany(mappedBy = "m", cascade = CascadeType.ALL)
	private List<Product> prods;

	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the gst_num
	 */
	public String getGst_num() {
		return gst_num;
	}


	/**
	 * @param gst_num the gst_num to set
	 */
	public void setGst_num(String gst_num) {
		this.gst_num = gst_num;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the phone
	 */
	public long getPhone() {
		return phone;
	}


	/**
	 * @param phone the phone to set
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the prods
	 */
	public List<Product> getProds() {
		return prods;
	}


	/**
	 * @param prods the prods to set
	 */
	public void setProds(List<Product> prods) {
		this.prods = prods;
	}


	@Override
	public String toString() {
		return "Merchant [id=" + id + ", gst_num=" + gst_num + ", email=" + email + ", phone=" + phone + ", password="
				+ password + "]";
	}


	
	
	
	
}
