package Service;

import java.util.List;

import Entity.Unit;

public interface UnitService {

	public Unit Add(Unit T) throws Exception;
	
	public Unit Update(Unit T);
	
	public void Remove(int id);
	
	public Unit getUnit(int id);
	
	public List<Unit> getAll();
	
	public List<Unit> getByName (String name);

}
