package com.yc.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Bookrank implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer rid;
	private String ip;
	private Integer bid;
	private Integer scores;
	
	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getScores() {
		return scores;
	}
	public void setScores(Integer scores) {
		this.scores = scores;
	}
	public Bookrank() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bookrank [rid=" + rid + ", ip=" + ip + ", bid=" + bid + ", scores=" + scores + "]";
	}
	
	
}
