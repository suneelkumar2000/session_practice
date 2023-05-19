package cys.session.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import cys.session.model.Customer;
import cys.session.util.ConnectionUtil;
import cys.session.validation.Validation;

public class CustomerImpl implements CustomerDAO {
	Validation val = new Validation();

	@Override
	public int insertCustomerDetails(Customer customer) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();

		boolean email = val.emailValidation(customer.getEmail());
		boolean phone = val.phoneValidation(customer.getPhoneNumber());
		boolean userName = val.usernameValidation(customer.getUserName());
		boolean password = val.passwordValidation(customer.getUserName());

		if (email == true && phone == true && userName == true && password == true) {
			String insert = "insert into customer(email,phone_number,user_name,password) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setString(1, customer.getEmail());
			ps.setLong(2, customer.getPhoneNumber());
			ps.setString(3, customer.getUserName());
			ps.setString(4, customer.getPassword());
			int execute = ps.executeUpdate();

			return execute;
		} else {
			return 0;
		}
	}

	@Override
	public int showCustomerId(String userName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		boolean user = val.usernameValidation(userName);
		if (user == true) {
			String customerId = "select id from customer where user_name=?";
			PreparedStatement ps1 = con.prepareStatement(customerId);
			ps1.setString(1, userName);
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				return id;
			}return 1;
		} else {
			return 0;
		}
	}
	@Override
	public boolean customerLogin(String userName,String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = ConnectionUtil.getConnection();
		String find = "select password from customer where user_name=?";
		PreparedStatement ps = con.prepareStatement(find);
		ps.setString(1, userName);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String pass = rs.getString(1);
			if (password.equals(pass)) {
				return true;
			}
		}
		return false;
	}
}
