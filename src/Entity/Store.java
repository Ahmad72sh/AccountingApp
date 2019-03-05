package Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;


@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Component
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String storeName;
    private String Name;
    private String Family;
    private String Tell;
    private String Mail;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="shop")
    private List<Goods> good = new ArrayList<Goods>();
     

	@OneToMany(cascade=CascadeType.ALL, mappedBy="shop")
    private List<SellerReal> sellerReal = new ArrayList<SellerReal>();

	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="shop")
	private List<CustomerReal> customerReal = new ArrayList<CustomerReal>();
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="shop")
	private List<SellerCompany> customerCompany = new ArrayList<SellerCompany>();


	
    public List<Goods> getGood() {
		return good;
	}
	public void setGood(List<Goods> good) {
		this.good = good;
	}


	public List<SellerReal> getSellerReal() {
		return sellerReal;
	}
	public void setSellerReal(List<SellerReal> sellerReal) {
		this.sellerReal = sellerReal;
	}


	public List<CustomerReal> getCustomerReal() {
		return customerReal;
	}
	public void setCustomerReal(List<CustomerReal> customerReal) {
		this.customerReal = customerReal;
	}
	
	
	public List<SellerCompany> getCustomerCompany() {
		return customerCompany;
	}
	public void setCustomerCompany(List<SellerCompany> customerCompany) {
		this.customerCompany = customerCompany;
	}
	
	
	
	public Integer getId() {
        return id;
    }

	
    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    
    public String getFamily() {
        return Family;
    }
    public void setFamily(String Family) {
        this.Family = Family;
    }

    
    public String getTell() {
        return Tell;
    }
    public void setTell(String Tell) {
        this.Tell = Tell;
    }
    
    
    public String getMail() {
        return Mail;
    }
    public void setMail(String Mail) {
        this.Mail = Mail;
    }
	@Override
	public String toString() {
		return "Store [id=" + id + ", storeName=" + storeName + ", Name=" + Name + ", Family=" + Family + ", Tell="
				+ Tell + ", Mail=" + Mail + "]";
	}
    
    
}