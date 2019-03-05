package Service;

import java.util.List;

import Entity.SellerReal;

public interface SellerRealService {

	public SellerReal Add(SellerReal T) throws Exception;
	
	public SellerReal Update(SellerReal T);
	
	public void Remove(int id);
	
	public SellerReal getSellerReal(int id);
	
	public List<SellerReal> getAll();

	public List<SellerReal> getByName (String name);
	
	public List<SellerReal> getByFamily (String family);
}
