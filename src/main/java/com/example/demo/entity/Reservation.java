package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_room", nullable = false)
	private Room room;
	
	@ManyToOne
	@JoinColumn(name = "id_guest", nullable = false)
	private Guest guest;

	@Column(name = "start_date", nullable = false)
	private Date startDate;
	
	@Column(name = "end_date", nullable = false)
	private Date endDate;
	
	@Column(name = "ckeck_in")
	private boolean checkIn;
	
	@Column(name = "ckeck_out")
	private boolean checkOut;

	@Column(name = "status")
	private boolean status;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<ChildGuest> childGuests;
}
