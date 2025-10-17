package com.healthcare.dao;

import java.sql.SQLException;
import java.util.List;

import com.healthcare.pojos.Appointments;
import com.healthcare.pojos.Patient;

public interface PatientDao {
	Patient signIn(String email, String password) throws SQLException;
  List<Appointments> patientAppointment(int patient_id)throws SQLException;
	void cleanUp() throws SQLException;

}
