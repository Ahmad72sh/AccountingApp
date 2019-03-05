package Entity;


import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Goods 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;
    private String buyPrice;
    private String salePrice;
    
    
	@ManyToOne
    private Store shop;

	public Store getShop() {
		return shop;
	}
	public void setShop(Store shop) {
		this.shop = shop;
	}
	
    
    @ManyToOne
    private ShoppingList shoppingList;
      
    public ShoppingList getShoppingList() {
		return shoppingList;
	}
	public void setShoppingList(ShoppingList shoppingList) {
		this.shoppingList = shoppingList;
	}
    

    @ManyToOne
    private Unit unit;

	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	public String getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(String buyPrice) {
		this.buyPrice = buyPrice;
	}
	
	
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salesPrice) {
		this.salePrice = salesPrice;
	}
	
	
	public Integer getId() {
		return id;
	}
    
}
