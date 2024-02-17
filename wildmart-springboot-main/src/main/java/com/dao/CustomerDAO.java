package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dto.Customer;
import com.ts.EmailService;

@Service
public class CustomerDAO {

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@PostMapping("/registerCustomer")
	public Customer registerCustomer(@RequestBody Customer cust) {
		Customer existingCustomer = customerRepository.findByEmailId(cust.getEmailId());
		if (existingCustomer != null) {
			throw new IllegalArgumentException("EmailId already taken");
		}
		String password = cust.getPassword();
		// System.out.println(password);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		// System.out.println(hashedPassword);
		cust.setPassword(hashedPassword);
		String emailContent = "Dear " + cust.getCustName() + ",\n\n"
				+ "Thank you for registering with WildMart. Please click the link below to verify your registration:\n\n"
				+ "http://localhost:4200/\n\n" + "Have a great shopping experience!\n\n" + "WildMart.in";
		EmailService.sendEmail(emailContent, "Please verify your registration", cust.getEmailId(),
				"wildmart@gmail.com");
		return customerRepository.save(cust);

	}

	public Customer getCustomerById(int custId) {
		Customer cust = new Customer(0, "customer not found!", "", "", "", "", "", "");
		return customerRepository.findById(custId).orElse(cust);
	}

	public Customer getCustomerByName(String name) {
		Customer cust = new Customer(0, "customer not found!", "", "", "", "", "", "");
		Customer customer = customerRepository.getCustomerByName(name);

		if (customer != null) {
			return customer;
		}

		return cust;
	}

	public void deleteCustomer(int custId) {
		customerRepository.deleteById(custId);
	}

	public Customer login(String emailId, String password) {
		Customer cust = customerRepository.findByEmailId(emailId);
		if (cust == null) {
			return null; // User not found
		}
		String hashedPassword = cust.getPassword();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (passwordEncoder.matches(password, hashedPassword)) {
			return cust; // Passwords match, login successful
		} else {
			return null; // Passwords don't match, login failed
		}
	}

	public Customer register(Customer cust) {
		// TODO Auto-generated method stub
		return customerRepository.save(cust);

	}

	public int setPass(String mobileNumber, String password) {
		return customerRepository.updatePass(mobileNumber, password);
	}

	public int setNewPass(String emailId, String password) {
		return customerRepository.updateNewPass(emailId, password);

	}

}
// return customerRepository.login(emailId, password);
// }
//
// }