package Dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


@Repository
public abstract class GenericDaoImpl <Entity, PK extends Serializable> implements GenericDao<Entity,PK>
{

	private Class<Entity> classType;
	private String className; //// for get name of entity class for HQL and ...
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl()
	{
		 Type t = getClass().getGenericSuperclass();
	     ParameterizedType pt = (ParameterizedType) t;
	     classType = (Class<Entity>) pt.getActualTypeArguments()[0];
	     String templateName = classType.getName(); //Class name generate here include entity.classname it dos'nt useful for HQl
	     this.className= templateName.substring(templateName.lastIndexOf('.')+1,templateName.length());  
	}
	
	
	@Override
	public Entity Insert(Entity T) {
		
		em.persist(T);
		em.flush();
		return T;
	}

	@Override
	public Entity Update(Entity T) {


		em.merge(T);
		return T;
	}

	@Override
	public void Delete(PK id) {

		em.remove(em.find(classType, id));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entity> selectAll() {
		String query ="Select t from "+className+" t";
		return (List<Entity>) em.createQuery(query).getResultList();
	}

	@Override
	public Entity getEntity(PK id) {

		return em.find(classType, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Entity> getEntityByName (String name)
	{
		String query = "Select t From "+this.className+" t where LOWER(t.Name)  like LOWER(concat('%',?1,'%'))";
		return em.createQuery(query).setParameter(1,name).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Entity> getEntityByFamily (String family)
	{
		String query = "Select t From "+this.className+" t where LOWER(t.Family)  like LOWER(concat('%',?1,'%'))";
		return em.createQuery(query).setParameter(1,family).getResultList();
	}
	
}
