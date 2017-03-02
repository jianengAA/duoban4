package com.yc.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer tid;
	private String name;
	
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Category() {
		super();
	}
	
	@Override
	public String toString() {
		return "Category [tid=" + tid + ", name=" + name + "]";
	}
	
}
