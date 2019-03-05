package Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.GoodsDao;
import Entity.Goods;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsDao goodDao;
	

	@Override
	public Goods Add(Goods T) {

		goodDao.Insert(T);
		return T;
	}

	@Override
	public Goods Update(Goods T) {

		goodDao.Update(T);
		return T;
	}

	@Override
	public void Remove(int id) {

		goodDao.Delete(id);
	}

	@Override
	public Goods getGood(int id) {

		return goodDao.getEntity(id);
	}

	@Override
	public List<Goods> getAll() {

		return goodDao.selectAll();
	}

	@Override
	public List<Goods> getByName(String name) {

		return goodDao.getEntityByName(name);
	}

}
