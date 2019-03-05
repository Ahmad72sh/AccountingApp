package Service;

import java.util.List;

import Entity.ShoppingList;

public interface ShoppingListService {

	public ShoppingList Add(ShoppingList T) throws Exception;
	
	public ShoppingList Update(ShoppingList T);
	
	public void Remove(int id);
	
	public ShoppingList getShoppingList(int id);
	
	public List<ShoppingList> getAll();
	
	public List<ShoppingList> getByName (String name);

}
