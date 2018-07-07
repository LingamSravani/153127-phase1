package com.capgemini.parallel.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.parallel.beans.Customer;
import com.capgemini.parallel.beans.Wallet;
import com.capgemini.parallel.exception.InvalidInputException;
import com.capgemini.parallel.service.WalletService;
import com.capgemini.parallel.service.WalletServiceImpl;

public class TestClass {
WalletService service;

Customer cust1,cust2,cust3;	
	@Before
	public void initData(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust1=new Customer("Amit", "9900112212",new Wallet(new BigDecimal(9000)));
		 Customer cust2=new Customer("Ajay", "9963242422",new Wallet(new BigDecimal(6000)));
		 Customer cust3=new Customer("Yogini", "9922950519",new Wallet(new BigDecimal(7000)));
				
		 data.put("9900112212", cust1);
		 data.put("9963242422", cust2);	
		 data.put("9922950519", cust3);	
			service= new WalletServiceImpl(data);
			
			 
	}
	@Test(expected=NullPointerException.class)
	public void testCreateAccount() {
		
		service.createAccount(null,null,null);
		
		
	}
	@Test
	public void testCreateAccount1() {
		
		
		Customer c=new Customer();
		Customer cust=new Customer();
		cust=service.createAccount("vaishu","9952224254",new BigDecimal(7000));
		c.setMobileNo("9952224254");
		c.setName("vaishu");
		c.setWallet(new Wallet(new BigDecimal(7000)));
		Customer actual =c;
		Customer expected=cust;
		assertEquals(expected, actual);
	
		
		
	}
@Test	
public void testCreateAccount2() {
		
		
		
		Customer cust=new Customer();
		cust=service.createAccount("Bhuvija","9900112213",new BigDecimal(7000));
		assertEquals("Bhuvija", cust.getName());
	
		
		
	}
@Test
public void testCreateAccount3() {
	
	Customer cust=new Customer();
	cust=service.createAccount("Kavya","9900112213",new BigDecimal(7000));
	assertEquals("9900112213", cust.getMobileNo());

	
	
}


@Test(expected=InvalidInputException.class)
public void testShowBalance() {
	Customer cust=new Customer();
cust=service.showBalance("9579405744");

}

@Test
public void testShowBalance2() {
	
	Customer cust=new Customer();
	
cust=service.showBalance("9922950519");
assertEquals(cust, cust3);

}
@Test
public void testShowBalance3() {
	
	Customer cust=new Customer();
cust=service.showBalance("9900112212");
BigDecimal actual=cust.getWallet().getBalance();
BigDecimal expected=new BigDecimal(9000);
assertEquals(expected, actual);

}

@Test(expected=InvalidInputException.class)
public void testFundTransfer() {
	service.fundTransfer(null, null,new BigDecimal(7000));
}

@Test
public void testFundTransfer2() {
	cust1=service.fundTransfer("9900112212","9963242422",new BigDecimal(2000));
	BigDecimal actual=cust1.getWallet().getBalance();
	BigDecimal expected=new BigDecimal(8000);
	assertEquals(expected, actual);
}
@Test(expected=InvalidInputException.class)
public void testDeposit()
{
	service.depositAmount("9245636555", new BigDecimal(2000));
}
	
@Test
public void testDeposit2()
{
	cust1=service.depositAmount("9963242422", new BigDecimal(2000));
	BigDecimal actual=cust1.getWallet().getBalance();
	BigDecimal expected=new BigDecimal(2000);
	assertEquals(expected, actual);
}
@Test(expected=InvalidInputException.class)
public void testWithdraw()
{
	service.withdrawAmount("9245636555", new BigDecimal(2000));
}
	
@Test
public void testWithdraw2()
{
	cust1=service.withdrawAmount("9963242422", new BigDecimal(2000));
	BigDecimal actual=cust1.getWallet().getBalance();
	BigDecimal expected=new BigDecimal(2000);
	assertEquals(expected, actual);
}	
@Test
public void TestValidate()
{
	Customer customer=new Customer("sravani","9796543210",new Wallet(new BigDecimal(10)));
	//service.acceptDetails(customer);
}

@After
public void testAfter()
{
	service=null;
}

}
	

