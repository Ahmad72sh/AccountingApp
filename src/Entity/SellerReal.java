package Entity;


import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class SellerReal
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;
    private String Family;
    private String Tell;
    private String Address;
    
    
    @OneToOne (cascade=CascadeType.ALL)
    private ShoppingList shoppingList;
      
    public ShoppingList getShoppingList() {
		return shoppingList;
	}
	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}


	@ManyToOne
    private Store shop;

	public Store getShop() {
		return shop;
	}
	public void setShop(Store shop) {
		this.shop = shop;
	}
	
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	public String getFamily() {
		return Family;
	}
	public void setFamily(String family) {
		Family = family;
	}
	
	
	public String getTell() {
		return Tell;
	}
	public void setTell(String tell) {
		Tell = tell;
	}
	
	
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	public Integer getId() {
		return id;
	}
    
}