package Service;

import java.util.List;

import Entity.Goods;

public interface GoodsService {
	
	public Goods Add(Goods T) throws Exception;
	
	public Goods Update(Goods T);
	
	public void Remove(int id);
	
	public Goods getGood(int id);
	
	public List<Goods> getAll();
	
	public List<Goods> getByName (String name);

}
