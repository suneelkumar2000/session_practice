package cys.session.dao;

import java.sql.SQLException;
import java.util.List;

import cys.session.model.Customer;

public interface CustomerDAO {
	public int insertCustomerDetails(Customer customer)throws ClassNotFoundException, SQLException;
	public int showCustomerId(String userName)throws ClassNotFoundException, SQLException;
	public boolean customerLogin(String userName,String password) throws ClassNotFoundException, SQLException;
}
