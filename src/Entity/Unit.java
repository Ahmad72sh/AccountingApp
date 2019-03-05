package Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Unit
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;
    
    @OneToMany(mappedBy="unit")
    private List<Goods> good = new ArrayList<Goods>();
    

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
	public Integer getId() {
		return id;
	}
}
