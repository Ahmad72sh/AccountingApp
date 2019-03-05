package Service;

import java.util.List;

import Entity.CustomerCompany;

import javax.swing.text.html.parser.Entity;

public interface CustomerCompanyService {
	
	public CustomerCompany Add(CustomerCompany T) throws Exception;
	
	public CustomerCompany Update(CustomerCompany T);
	
	public void Remove(int id);
	
	public CustomerCompany getCustomerCompany(int id);
	
	public List<CustomerCompany> getAll();
	
	public List<CustomerCompany> getByName (String name);
	
}
