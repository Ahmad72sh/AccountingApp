package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.StoreDao;
import Entity.Store;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDao StoreDao;

	
	@Override
	public Store Add(Store T) {
		
			StoreDao.Insert(T);
			return T;
	}

	@Override
	public Store Update(Store T) {

		StoreDao.Update(T);
		return T;
	}

	public void NewUpdate(Store store) {
		StoreDao.Update2(store);
	}

	@Override
	public void Remove(int id) {
		
			StoreDao.Delete(id);	
	}

	@Override
	public Store getSoreById(int id) {

		return  StoreDao.getEntity(id);
	}

	@Override
	public List<Store> getAll() {

		return StoreDao.selectAll();
	}
	
	@Override
	public List<Store> getByName(String name) {

		return StoreDao.getEntityByName(name);
	}


	@Override
	public List<String> getAllStoreName() {

		return StoreDao.getStoreNameList();
	}

	@Override
	public Store getByStoreName(String storeName) {
		
		return StoreDao.getByStoreName(storeName);
	}

}
