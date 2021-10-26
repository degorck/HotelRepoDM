package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "floor", nullable = false)
	private long floor;
	
	@Column(name = "max_guests", nullable = false)
	private long maxGuests;
	
	@ManyToOne
	@JoinColumn(name = "id_room_type", nullable = false)
	private RoomType roomType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hotel", nullable = false)
	private Hotel hotel;
	
	@OneToMany(mappedBy = "room")
	private List<Reservation> reservationList;
}
