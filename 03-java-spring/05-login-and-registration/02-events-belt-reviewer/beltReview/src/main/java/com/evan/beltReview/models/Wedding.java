package com.evan.beltReview.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="weddings")
public class Wedding {

	public Wedding() {

	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	@NotBlank
	private String guestOne;
	@NotBlank
	private String guestTwo;
	@Future
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@NotBlank
	private String address;
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM-DD-yyyy HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="MM-DD-yyyy HH:mm:ss")
	private Date updatedAt;
		
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="guestlist",
			joinColumns = @JoinColumn(name="wedding_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private List<User> guests;

	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGuestOne() {
		return guestOne;
	}
	public void setGuestOne(String guestOne) {
		this.guestOne = guestOne;
	}
	public String getGuestTwo() {
		return guestTwo;
	}
	public void setGuestTwo(String guestTwo) {
		this.guestTwo = guestTwo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getGuests() {
		return guests;
	}
	public void setGuests(List<User> guests) {
		this.guests = guests;
	}
	
}
