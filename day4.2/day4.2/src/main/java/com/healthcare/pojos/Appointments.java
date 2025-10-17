package com.healthcare.pojos;

import java.sql.Date;
import java.sql.Timestamp;

public class Appointments {
private int id;
private int doctor_id;
private int patient_id;
private Date  appointment_datetime ;
private String status;


private java.sql.Timestamp appointmentDateTime;
private String doctorName;
private int patientId;





public Appointments(int id, int doctor_id, int patient_id, Date appointment_datetime, String status,
		Timestamp appointmentDateTime, String doctorName, int patientId) {
	super();
	this.id = id;
	this.doctor_id = doctor_id;
	this.patient_id = patient_id;
	this.appointment_datetime = appointment_datetime;
	this.status = status;
	this.appointmentDateTime = appointmentDateTime;
	this.doctorName = doctorName;
	this.patientId = patientId;
}





public int getId() {
	return id;
}





public void setId(int id) {
	this.id = id;
}





public int getDoctor_id() {
	return doctor_id;
}





public void setDoctor_id(int doctor_id) {
	this.doctor_id = doctor_id;
}





public int getPatient_id() {
	return patient_id;
}





public void setPatient_id(int patient_id) {
	this.patient_id = patient_id;
}





public Date getAppointment_datetime() {
	return appointment_datetime;
}





public void setAppointment_datetime(Date appointment_datetime) {
	this.appointment_datetime = appointment_datetime;
}





public String getStatus() {
	return status;
}





public void setStatus(String status) {
	this.status = status;
}





public java.sql.Timestamp getAppointmentDateTime() {
	return appointmentDateTime;
}





public void setAppointmentDateTime(java.sql.Timestamp appointmentDateTime) {
	this.appointmentDateTime = appointmentDateTime;
}





public String getDoctorName() {
	return doctorName;
}





public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}





public int getPatientId() {
	return patientId;
}





public void setPatientId(int patientId) {
	this.patientId = patientId;
}





public Appointments(int id, java.sql.Timestamp appointmentDateTime, String doctorName, int patientId) {
    this.id = id;
    this.appointmentDateTime = appointmentDateTime;
    this.doctorName = doctorName;
    this.patientId = patientId;
}






}
