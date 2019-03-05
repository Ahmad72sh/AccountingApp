package Service;

import java.util.List;

import Entity.SellerCompany;

public interface SellerCompanyService {

	public SellerCompany Add(SellerCompany T) throws Exception;
	
	public SellerCompany Update(SellerCompany T);
	
	public void Remove(int id);
	
	public SellerCompany getSellerCompany(int id);
	
	public List<SellerCompany> getAll();
	
	public List<SellerCompany> getByName (String name);

}
