package Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class ShoppingList
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double Count;
    
    @OneToMany(mappedBy="shoppingList")
    private List<Goods> good = new ArrayList<Goods>();
    
    @OneToOne(mappedBy="shoppingList")
    private CustomerReal customerReal = new CustomerReal();

    @OneToOne(mappedBy="shoppingList")
    private CustomerCompany customerCompany = new CustomerCompany();

    @OneToOne(mappedBy="shoppingList")
    private SellerReal sellerReal = new SellerReal();

    @OneToOne(mappedBy="shoppingList")
    private SellerCompany sellerCompany = new SellerCompany();
    
    
	public List<Goods> getGood() {
		return good;
	}
	public void setGood(List<Goods> good) {
		this.good = good;
	}

	public CustomerReal getCustomerReal() {
		return customerReal;
	}
	public void setCustomerReal(CustomerReal customerReal) {
		this.customerReal = customerReal;
	}

	public CustomerCompany getCustomerCompany() {
		return customerCompany;
	}
	public void setCustomerCompany(CustomerCompany customerCompany) {
		this.customerCompany = customerCompany;
	}
		
	public SellerReal getSellerReal() {
		return sellerReal;
	}
	public void setSellerReal(SellerReal sellerReal) {
		this.sellerReal = sellerReal;
	}
	
	public SellerCompany getSellerCompany() {
		return sellerCompany;
	}
	public void setSellerCompany(SellerCompany sellerCompany) {
		this.sellerCompany = sellerCompany;
	}
	
	
	
	public Double getCount() {
		return Count;
	}
	public void setCount(Double count) {
		Count = count;
	}
	
	
	public Integer getId() {
		return id;
	}
		
}

