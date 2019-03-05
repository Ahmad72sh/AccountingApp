package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.UnitDao;
import Entity.Unit;

@Service
@Transactional
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitDao UnitDao;

	
	@Override
	public Unit Add(Unit T) {
		UnitDao.Insert(T);
		return T;	
	}

	@Override
	public Unit Update(Unit T)
	{

		UnitDao.Update(T);
		return T;
	}

	@Override
	public void Remove(int id) {

		UnitDao.Delete(id);
	}

	@Override
	public Unit getUnit(int id) {

		return  UnitDao.getEntity(id);

	}

	@Override
	public List<Unit> getAll() {

		return UnitDao.selectAll();
	}
	
	@Override
	public List<Unit> getByName(String name) {
		return UnitDao.getEntityByName(name);
	}

}
