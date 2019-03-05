package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.CustomerRealDao;
import Entity.CustomerReal;

@Service
@Transactional
public class CustomerRealServiceImpl implements CustomerRealService {
	
	@Autowired
	CustomerRealDao customerRealDao;

	
	@Override
	public CustomerReal Add(CustomerReal T) throws Exception {
		
		try {
			customerRealDao.Insert(T);
			return T;
		} catch (Exception e) {
			throw new Exception("Error, Do not Inserted!!");
		}
	}

	@Override
	public CustomerReal Update(CustomerReal T) {

		customerRealDao.Update(T);
		return T;
	}

	@Override
	public void Remove(int id) {

			customerRealDao.Delete(id);
	
	}

	@Override
	public CustomerReal getCustomerReal(int id) {

		return customerRealDao.getEntity(id);
		
	}

	@Override
	public List<CustomerReal> getAll() {

		return customerRealDao.selectAll();
		
	}

	@Override
	public List<CustomerReal> getByName(String name) {

		return customerRealDao.getEntityByName(name);
	}

	
	
	
}
