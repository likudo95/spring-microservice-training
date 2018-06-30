package com.brownfield.pss.baggage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "baggage")
public class Baggage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3539163061797289387L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "id", strategy = "increment")
	private long id;
	
	@Column(name = "weight")
	private double weight;
	
	@Column(name = "checkin_id")
	private long checkinId;
	
	public Baggage() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public long getCheckinId() {
		return checkinId;
	}

	public void setCheckinId(long checkinId) {
		this.checkinId = checkinId;
	}

	public Baggage(long id, double weight, long checkinId) {
		super();
		this.id = id;
		this.weight = weight;
		this.checkinId = checkinId;
	}
	
	
	
	
}
