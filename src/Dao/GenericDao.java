package Dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <Entity, PK extends Serializable>
{
	public Entity Insert (Entity T);
	
	public Entity Update (Entity T);
	
	public void Delete (PK id);
	
	public List<Entity> selectAll ();
	
	public Entity getEntity (PK id);
	
	public List<Entity> getEntityByName (String name);
	
	public List<Entity> getEntityByFamily (String family);

}
