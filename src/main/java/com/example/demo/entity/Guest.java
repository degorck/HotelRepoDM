package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "guest")
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "status", nullable = false)
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "id_guest_type", nullable = false)
	private GuestType type;

	@OneToMany(mappedBy = "guest")
	private List<Reservation> reservationList;

	@OneToMany(mappedBy = "guest")
	private List<ChildGuest> childGuestList;

	@OneToMany(mappedBy = "guest")
	private List<ReservationLog> reservationLogList;
}
