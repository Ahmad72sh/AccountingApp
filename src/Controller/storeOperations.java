package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceUnit;
import javax.swing.DefaultListModel;

import Service.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Entity.Store;
import Service.StoreService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@Transactional
public class storeOperations implements IstoreOperations
{
//	@Autowired
//	private StoreService storeService;
//
//	@Autowired
//	private Store store;

	ApplicationContext ctx = new AnnotationConfigApplicationContext(Dao.JPAconfig.class);
	StoreService storeService = ctx.getBean(StoreService.class);
	Store store = ctx.getBean(Store.class);
	
    public Store Add(String shopName, String Name, String Family, String Tell, String Email)
    	{
		store.setStoreName(shopName);
		store.setName(Name);
		store.setFamily(Family);
		store.setTell(Tell);
		store.setMail(Email);
        
		try {
			storeService.Add(store);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return store;
    	}
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public DefaultListModel showStoreName()
    {
    		List<String> storeName = storeService.getAllStoreName();
			DefaultListModel DLM = new DefaultListModel();
    		for (String s : storeName) {
    			DLM.addElement(s);
    		}
    		return DLM;
    }
    
    public Store editStore(String storeName)
    {
    	return storeService.getByStoreName(storeName);
    	
    }
    
    public void Update(Store store)
    {
//		storeService.NewUpdate(id,shopName,Name,Family,Tell,Mail);
		storeService.NewUpdate(store);

    }
    
    public void Delete(String name)
    {
    	store = storeService.getByStoreName(name);
    	storeService.Remove(store.getId());
    }
}


