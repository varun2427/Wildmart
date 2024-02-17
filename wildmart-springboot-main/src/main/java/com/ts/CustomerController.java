package com.ts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CustomerDAO;
import com.dao.SmsService;
import com.dto.Customer;

@RestController
public class CustomerController {

// Dependency Injection
@Autowired
CustomerDAO custDAO;

@Autowired
SmsService smsService;

@GetMapping("/getAllCustomer")
public List<Customer> getAllCustomer() {
return custDAO.getAllCustomer();
}

@GetMapping("/getCustomerById/{id}")
public Customer getCustomerById(@PathVariable("id") int custId) {
return custDAO.getCustomerById(custId);
}

@GetMapping("/getCustomerByName/{name}")
public Customer getCustomerByName(@PathVariable("name") String Name) {
return custDAO.getCustomerByName(Name);
}

@PostMapping("/registerCustomer")
public Customer registerCustomer(@RequestBody Customer customer) {

return custDAO.registerCustomer(customer);

}

@PutMapping("/updateCustomer")
public Customer updateCustomer(@RequestBody Customer customer) {
return custDAO.register(customer);
}

@DeleteMapping("/deleteCustomer/{id}")
public String deleteCustomer(@PathVariable("id") int custId) {
custDAO.deleteCustomer(custId);
return "Customer Record Deleted!!!";
}

@PostMapping("/registerCustomerHC")
public String registerCustomerHC() {
Customer cust1 = new Customer(101, "Ritika", "Female", "HYD", "IND", "9000900012", "ritika@gmail.com", "1234");
Customer cust2 = new Customer(102, "Vinay", "Male", "HYD", "IND", "9000900011", "vinay@gmail.com", "1234");
Customer cust3 = new Customer(103, "Sai", "Male", "HYD", "IND", "90009000913", "sai@gmail.com", "1234");
Customer cust4 = new Customer(104, "Pooja", "Female", "HYD", "IND", "9000900014", "pooja@gmail.com", "1234");

custDAO.registerCustomer(cust1);
custDAO.registerCustomer(cust2);
custDAO.registerCustomer(cust3);
custDAO.registerCustomer(cust4);
return "Customer Registered Successfully";

}

@GetMapping("/login/{emailId}/{password}")
public Customer login(@PathVariable("emailId") String emailId, @PathVariable("password") String password) {
return custDAO.login(emailId, password);
}

@GetMapping("/sendsms/{mobileNumber}")
public int sendSMS(@PathVariable("mobileNumber") String mobileNumber) {
int min = 100000;
int max = 999999;
int otp = (int) (Math.random() * (max - min + 1) + min);
String msg = "Your OTP is " + otp + ". Please verify this in your application.";
System.out.println(otp);

String s = smsService.sendSMS(mobileNumber, msg);
if (s != null) {
return otp;
} else {
return 0;
}
}

@PutMapping("/updatePass")
public int updatPass(@RequestBody Customer customer) {
System.out.println("inside update new pass");
String phoneNo = customer.getMobileNumber();
String password = customer.getPassword();
BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
String hashedPassword = passwordEncoder.encode(password);
System.out.println(phoneNo);
System.out.println(password);
System.out.println(hashedPassword);
String newPhone = phoneNo.substring(3);
System.out.println(newPhone);
return custDAO.setPass(newPhone, hashedPassword);

}

@GetMapping("/sendOTPByEmail/{emailId}")
public int sendOTPByEmail(@PathVariable("emailId") String emailId) {
int min = 100000;
int max = 999999;
int otp = (int) (Math.random() * (max - min + 1) + min);
String msg = "your OTp is  " + otp + "  please verify this in your application";
System.out.println(otp);
String subj = "otp service";
boolean flag = EmailService.sendEmail(msg, subj, emailId, "wildmart07@gmail.com");
if (flag) {
return otp;
} else {
return 0;
}

}

@PutMapping("/updateNewPass")
public int newPass(@RequestBody Customer customer) {
System.out.println("inside update new pass");
String emailId = customer.getEmailId();
String password = customer.getPassword();

return custDAO.setNewPass(emailId, password);

}

}