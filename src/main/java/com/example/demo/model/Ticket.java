package com.example.demo.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ticket")
public class Ticket implements Serializable{
	private static final long serialVersionUID = -4805692603922843203L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="title")
	private String title;
	
	@Column(name="datas")
	private String datas;
	
	@Column(name="times")
	private String times;
	
	@Column(name="price")
	private double price;
	
	
	
	public Ticket() {
		
	}
	
	
	@Override
	public String toString() {
		return "Ticket title = '" + title + "'";
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDatas() {
		return datas;
	}

	public String getTimes() {
		return times;
	}

	public double getPrice() {
		return price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDatas(String datas) {
		this.datas = datas;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
