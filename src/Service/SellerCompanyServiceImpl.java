package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.SellerCompanyDao;
import Entity.SellerCompany;

@Service
@Transactional
public class SellerCompanyServiceImpl implements SellerCompanyService {

	@Autowired
	private SellerCompanyDao SellerCompanyDao;

	@Override
	public SellerCompany Add(SellerCompany T) {
		SellerCompanyDao.Insert(T);
		return T;	
	}

	@Override
	public SellerCompany Update(SellerCompany T)
	{

		SellerCompanyDao.Update(T);
		return T;
	}

	@Override
	public void Remove(int id) {

		SellerCompanyDao.Delete(id);
	}

	@Override
	public SellerCompany getSellerCompany(int id) {

		return  SellerCompanyDao.getEntity(id);

	}

	@Override
	public List<SellerCompany> getAll() {

		return SellerCompanyDao.selectAll();
	}
	
	@Override
	public List<SellerCompany> getByName(String name) {
		return SellerCompanyDao.getEntityByName(name);
	}

}
