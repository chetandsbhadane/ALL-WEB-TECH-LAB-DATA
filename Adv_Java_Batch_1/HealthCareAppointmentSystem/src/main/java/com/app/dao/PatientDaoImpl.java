package com.app.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.app.utils.DBUtils.*;

import com.app.pojos.Patient;

public class PatientDaoImpl implements PatientDao {
	// state
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4, pst5;

	// def ctor of the DAO layer
	public PatientDaoImpl() throws SQLException {
		// get cn from db utils
		cn = openConnection();
		// pst1 : sign in
		pst1 = cn.prepareStatement("select * from patient where email=? and password=?"); //chetan@gmail.com , 11234
		// pst2 : get user details
		pst2 = cn.prepareStatement("select * from patient where role='patient' and dob between ? and ?");
		// pst3 : voter reg
		/*
		 * id | first_name | last_name | email | password | dob | status | role
		 */
		pst3 = cn.prepareStatement("insert into patient values(default,?,?,?,?,?,?)");
		// pst4 --change pwd
		pst4 = cn.prepareStatement("update patient set password=? where email=? and password=? and role='voter'");

		System.out.println("user dao created...");
	}

	@Override
	public Patient signIn(String email, String password) throws SQLException {
		// 1. set IN params
		pst1.setString(1, email);
		pst1.setString(2, password);
		// 2. exec query
		try (ResultSet rst = pst1.executeQuery()) {
			// rst cursor : before the 1st row

			if (rst.next()) // => successful login
				return new Patient(rst.getInt(1), rst.getString(2), 
						rst.getString(3), email, password,
						rst.getBoolean(6), rst.getString(7));
		}
		return null;
	}

	@Override
	public List<Patient> getUserDetails(Date begin, Date end) throws SQLException {
		// 0. create empty list
		List<Patient> users = new ArrayList<>();
		// 1. set IN params
		pst2.setDate(1, begin);
		pst2.setDate(2, end);
		// 2 . exec -- exec query
		try (ResultSet rst = pst2.executeQuery()) {
			while (rst.next())
				users.add(new Patient(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getBoolean(6), rst.getString(7)));
		}
		return users;// dao rets populated list of users to the caller
	}

	@Override
	public String voterRegistration(Patient newVoter) throws SQLException {
		// 1. set IN params
		/*
		 * int userId, String firstName, String lastName, String email, String password,
		 * Date dob, boolean status, String role
		 */
		pst3.setString(1, newVoter.getFirstName());
		pst3.setString(2, newVoter.getLastName());
		pst3.setString(3, newVoter.getEmail());
		pst3.setString(4, newVoter.getPassword());
		pst3.setBoolean(5, newVoter.isStatus());
		pst3.setString(6, newVoter.getRole());
		// exec : executeUpdate
		int rows = pst3.executeUpdate();
		if (rows == 1)
			return "Voter registered....";
		return "Voter registration failed !";
	}

	@Override
	public String changePassword(String email, String oldPwd, String newPwd) throws SQLException {
		// 1. set IN params
		pst4.setString(1, newPwd);
		pst4.setString(2, email);
		pst4.setString(3, oldPwd);
		// 2. exec update : DML
		int rows = pst4.executeUpdate();
		if (rows == 1)
			return "Password Changed !";
		return "Changing password  failed(invalid credentials or role )!!!!";
	}
	

	@Override
	public String deleteVoterDetails(int voterId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	// add clean up method to close DB resources
	public void cleanUp() throws SQLException {
		System.out.println("user dao cleaned up");
		if (pst1 != null) 
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		closeConnection();
	}
	
	

}
