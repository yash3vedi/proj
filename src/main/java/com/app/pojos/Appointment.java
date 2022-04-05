package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class Appointment extends BaseEntity {
	public Appointment() {}
	
	
	public Appointment(int customerId, LocalDate appointmentDate, AppointmentStatus appointmentStatus) {
		super();
		this.customerId = customerId;
		this.appointmentDate = appointmentDate;
		this.appointmentStatus = appointmentStatus;
	}


	@Column(name = "cust_id",length=20)
	private int customerId;
	@Column(name = "appoint_date",length=20)
	private LocalDate appointmentDate;
	@Column(name = "appoint_status",length=20)
	@Enumerated(EnumType.STRING)
	private AppointmentStatus appointmentStatus;
	@Column(name = "message",length=150)
	private String message;
	
	
	public AppointmentStatus getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	
	
}
