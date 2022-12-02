package com.stack_java.burgertracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burger")
public class Burger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 200)
	private String burgerName;
	
	@NotNull
	@Size(min = 1, max = 200)
	private String restaurantName;
	
	@NotNull
	@Min(value=1)
	@Max(value=5)
	private Integer rating;
	
	@NotNull
	@Size(min = 1, max = 200)
	private String note;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy=MM=dd")
	private Date updatedAt;
	
	
	public Burger() {
	}
	
	public Burger(String burgerName, String restaurantName, int rating, String note) {
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.rating = rating;
		this.note = note;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBurgerName() {
		return burgerName;
	}


	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
