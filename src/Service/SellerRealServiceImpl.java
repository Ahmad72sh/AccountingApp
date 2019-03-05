package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.SellerRealDao;
import Entity.SellerReal;

@Service
@Transactional
public class SellerRealServiceImpl implements SellerRealService {

	@Autowired
	private SellerRealDao SellerRealDao;


	@Override
	public SellerReal Add(SellerReal T) {

		SellerRealDao.Insert(T);
		return T;
	}

	@Override
	public SellerReal Update(SellerReal T) {

		SellerRealDao.Update(T);
		return T;
	}

	@Override
	public void Remove(int id) {

			SellerRealDao.Delete(id);	
	}

	@Override
	public SellerReal getSellerReal(int id) {

		return SellerRealDao.getEntity(id);
	}

	@Override
	public List<SellerReal> getAll() {

		return SellerRealDao.selectAll();
	}

	@Override
	public List<SellerReal> getByName(String name) {

		return SellerRealDao.getEntityByName(name);
	}

	@Override
	public List<SellerReal> getByFamily(String family) {

		return SellerRealDao.getEntityByFamily(family);
	}
	
	
	
}
