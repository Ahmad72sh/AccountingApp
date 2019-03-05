package Service;

import java.util.List;

import Entity.CustomerReal;

public interface CustomerRealService {

	public CustomerReal Add(CustomerReal T) throws Exception;
	
	public CustomerReal Update(CustomerReal T);
	
	public void Remove(int id);
	
	public CustomerReal getCustomerReal(int id);
	
	public List<CustomerReal> getAll();
	
	public List<CustomerReal> getByName (String name);
	
//	public List<String> getByFamily (String family);
	
}
