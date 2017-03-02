package com.yc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer bid;
	private String bname;
	private Integer isbn;
	private String author;
	private String pdfs;
	private String description;
	
	private List<MultipartFile> pdfsUrl; //对应界面<input type="file"
										//              name="pdfsUrl" />
	
	private BigDecimal price;  
	
	private Category category;
	
	//b标准的javabean方法,可利用${book.pdfsStringList}
	public List<String> getPdfsStringList(){
		System.out.println("getPdfsStringList");
		List<String> list = new ArrayList<String>();
		if(pdfs!=null && pdfs.length()>0){
			String[] strs= pdfs.split(",");
			for(String s:strs){
				list.add(s);
			}
		}
		return list;
	}
	

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPdfs() {
		return pdfs;
	}

	public void setPdfs(String pdfs) {
		this.pdfs = pdfs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MultipartFile> getPdfsUrl() {
		return pdfsUrl;
	}

	public void setPdfsUrl(List<MultipartFile> pdfsUrl) {
		this.pdfsUrl = pdfsUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", isbn=" + isbn + ", author=" + author + ", pdfs=" + pdfs
				+ ", description=" + description + ", pdfsUrl=" + pdfsUrl + ", price=" + price + ", category="
				+ category + "]";
	}

	public Book() {
		super();
	}

	
	

	
}
