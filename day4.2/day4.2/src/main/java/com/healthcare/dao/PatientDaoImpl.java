package com.healthcare.dao;

import static com.healthcare.utils.DBUtils.closeConnection;
import static com.healthcare.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.pojos.Appointments;
import com.healthcare.pojos.Doctor;
import com.healthcare.pojos.Patient;

public class PatientDaoImpl implements PatientDao {
	// state
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;

	public PatientDaoImpl() throws SQLException {
		// open cn
		cn = openConnection();
		// create pst1 - login
		pst1 = cn.prepareStatement("select * from patients where email=? and password=?");
		pst2 = cn.prepareStatement("select a.id ,d.appointment_datetime,d.name from appointments a inner join doctors d on a.id =d.id inner join patients p on p.id=a.id where p.id = ? ");
		System.out.println("patient dao created");

	}

	@Override
	public Patient signIn(String email, String password) throws SQLException {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, password);
		try (ResultSet rst = pst1.executeQuery()) {
			// int id, String name, String email, String phone, Date dob
			if (rst.next()) {
				return new Patient(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(5), rst.getDate(6));
			}
		}
		return null;
	}
	@Override
	public List<Appointments> patientAppointment(int patient_id) throws SQLException {
		List<Appointments>appoints = new ArrayList<>();
		pst2.setInt(1, patient_id);
		
		try(ResultSet rst = pst2.executeQuery()){
			
			while(rst.next()) {
	            int appointmentId = rst.getInt(1);                // a.id
	            java.sql.Timestamp appointmentDateTime = rst.getTimestamp(2); // d.appointment_datetime
	            String doctorName = rst.getString(3);             // d.name
	            
	            // Assuming your Appointments constructor supports these fields
	            Appointments appointment = new Appointments(appointmentId, appointmentDateTime, doctorName, appointmentId);
	            appointment.setId(appointmentId);
	            appointment.setAppointmentDateTime(appointmentDateTime);
	            appointment.setDoctorName(doctorName);
	            appointment.setPatient_id(patient_id);
	            
	            appoints.add(appointment);
	        }
	    }
	    
	    return appoints;
	}

	
//	List<Doctor> doctors = new ArrayList<>();
//	// set IN parameter
//	pst1.setString(1, speciality);
//	// select query -> exec query -> RST -> process it
//	try (ResultSet rst = pst1.executeQuery()) {
//		/*
//		 * int id, String docName, String speciality, String email, Date dob
//		 */
//		while (rst.next())
//			doctors.add(new Doctor(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
//					rst.getDate(6)));
//	}
//	return doctors;
//}




	@Override
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
			pst1 = null;
		}
		closeConnection();
		System.out.println("patient dao cleaned up");

	}

	

}
