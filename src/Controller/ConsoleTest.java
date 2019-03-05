package Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Entity.Store;
import Service.CustomerRealService;
import Service.StoreService;

import java.util.List;

public class ConsoleTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Dao.JPAconfig.class);
		CustomerRealService cr = ctx.getBean(CustomerRealService.class);
		System.out.println(cr.getByName("ha"));
		
		StoreService StoreService = ctx.getBean(StoreService.class);
		Store store = ctx.getBean(Store.class);

//		List<Store> s1 = ss.getAll();
//		for (Store s:s1) {
//			System.out.println(s.toString());
//		}
//		System.out.println(ss.getAll().toString());
//		storeOperations so = new storeOperations();
//		so.Delete("testName1");
		
		
		
		
//		Store s = new Store();
//		s.setShopName("MojElectric");
//		s.setName("Ahmad");
//		s.setFamily("Shafiei");
//		s.setTell("09131335254");
//		s.setMail("MojElectric@gmail.com");
		
//		StoreServiceImpl ss = new StoreServiceImpl();
//		s = ss.getShops(1);
//		ss.Remove(1);
		
//		CustomerRealServiceImpl a = new CustomerRealServiceImpl();
//		try {
//			a.Remove(1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		Unit u = new Unit();
//		u.setName("Ton");
//		UnitServiceImpl b = new UnitServiceImpl();
//		try {
//			b.Add(u);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		

		
		
//		Unit unit = new Unit();
//		unit.setName("Number");
		
//		Goods g = new Goods();
//		g.setName("Cement");
//		g.setBuyPrice("1200");
//		g.setSalePrice("2000");
//		g.setUnit(unit);
		
//		CustomerReal r = new CustomerReal();
//		r.setName("Hamed");
//		r.setFamily("Sadeghi");
//		r.setTell("09130000000");
//		r.setAddress("Esfahan");
//		r.setShop(s);
//		CustomerRealServiceImpl crs = new CustomerRealServiceImpl();
//		r=crs.getCustomerReal(2);
//		s.getCustomerReal().add(r);
//		r.setShop(s);
//		crs.Update(r);
//		ss.Update(s);
		
		
        
//        SessionFactory sf = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
//        Session session = sf.openSession();
//        Transaction tx = session.beginTransaction();

//        session.save(r);
//        session.save(g);
//        s = session.get(Goods.class, 1);
//        r = session.get(SellerReal.class, 1);
//        r.setShop(g);
//        session.save(s);
//        
//        tx.commit();
//        session.close();
		


		
//		String name = "ha";
//		CustomerRealServiceImpl crs = new CustomerRealServiceImpl();
//		List<String> t = crs.getByName(name);
//		
//		for (String m : t) {
//			System.out.println(m);
//		}


	}

	
}
