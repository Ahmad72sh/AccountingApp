package Service;

import java.util.List;

import Entity.Store;

public interface StoreService {

	public Store Add(Store T) throws Exception;

	public void NewUpdate(Store store);

	public Store Update(Store T);
	
	public void Remove(int id);
	
	public Store getSoreById(int id);
	
	public List<Store> getAll();
	
	public List<Store> getByName (String name);
	
	public List<String> getAllStoreName();
	
	public Store getByStoreName(String storeName);

}
