package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.ShoppingListDao;
import Entity.ShoppingList;

@Service
@Transactional
public class ShoppingListServiceImpl implements ShoppingListService {

	@Autowired
	private ShoppingListDao ShoppingListDao;


	
	@Override
	public ShoppingList Add(ShoppingList T) {

		ShoppingListDao.Insert(T);
		return T;	
	}

	@Override
	public ShoppingList Update(ShoppingList T)
	{

		ShoppingListDao.Update(T);
		return T;
	}

	@Override
	public void Remove(int id) {

		ShoppingListDao.Delete(id);	
	}

	@Override
	public ShoppingList getShoppingList(int id) {

		return  ShoppingListDao.getEntity(id);
	}

	@Override
	public List<ShoppingList> getAll() {

		return ShoppingListDao.selectAll();
	}
	
	@Override
	public List<ShoppingList> getByName(String name) {

		return ShoppingListDao.getEntityByName(name);
	}

}
