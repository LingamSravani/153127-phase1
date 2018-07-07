package com.capgemini.parallel.repo;

import java.util.Map;

import com.capgemini.parallel.beans.Customer;

public class WalletRepoImpl implements WalletRepo{
	private Map<String, Customer> data; 
	public WalletRepoImpl(Map<String, Customer> data) {
		super();
		this.data = data;
	}

	public boolean save(Customer customer) {
		//Customer c=new Customer();
	
		data.put(customer.getMobileNo(),customer);
		return true;
	}

	public Customer findOne(String mobileNo) {
		if(data.containsKey(mobileNo))
		{
		return data.get(mobileNo);
		}return null;
	}

}
