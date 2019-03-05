package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.CustomerCompanyDao;
import Entity.CustomerCompany;

@Service
@Transactional
public class CustomerCompanyServiceImpl implements CustomerCompanyService {

	@Autowired
	private CustomerCompanyDao customerCompanyDao;



	@Override
	public CustomerCompany Add(CustomerCompany T) {

		customerCompanyDao.Insert(T);
		return T;
		
	}

	@Override
	public CustomerCompany Update(CustomerCompany T)
	{

		customerCompanyDao.Update(T);
		return T;
	}

	@Override
	public void Remove(int id) {

			customerCompanyDao.Delete(id);
		
	}

	@Override
	public CustomerCompany getCustomerCompany(int id) {

		return  customerCompanyDao.getEntity(id);

	}

	@Override
	public List<CustomerCompany> getAll() {

		return customerCompanyDao.selectAll();
		
	}
	
	@Override
	public List<CustomerCompany> getByName(String name) {

		return customerCompanyDao.getEntityByName(name);
	}

}
