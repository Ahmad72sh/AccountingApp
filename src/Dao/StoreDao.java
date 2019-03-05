package Dao;


import Entity.Store;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StoreDao extends GenericDaoImpl<Store, Integer> {
	
	@PersistenceContext
	private EntityManager em;

	public void Update2(Store store){
		Store T = getEntity(store.getId());
		T.setStoreName(store.getStoreName());
		T.setName(store.getName());
		T.setFamily(store.getFamily());
		T.setTell(store.getTell());
		T.setMail(store.getMail());
		em.flush();


	}
	
	@SuppressWarnings("unchecked")
	public List<String> getStoreNameList ()
	{
		String query = "SELECT t.storeName from Store t";
		return em.createQuery(query).getResultList();
	}


	public Store getByStoreName(String name)
	{
		String query = "SELECT t from Store t where t.storeName like ?1";
		return (Store) em.createQuery(query).setParameter(1,name).getResultList().get(0);
	}

}
