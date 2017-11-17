package healthcares.spring.model;
// Generated Aug 3, 2016 3:30:03 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TypeMedicine generated by hbm2java
 */
@Entity
@Table(name = "type_medicine", catalog = "induct")
public class TypeMedicine implements java.io.Serializable {

	private Integer id;
	private String value;
	private Set<Medicine> medicines = new HashSet<Medicine>(0);

	public TypeMedicine() {
	}

	public TypeMedicine(String value, Set<Medicine> medicines) {
		this.value = value;
		this.medicines = medicines;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "value", length = 45)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeMedicine")
	public Set<Medicine> getMedicines() {
		return this.medicines;
	}

	public void setMedicines(Set<Medicine> medicines) {
		this.medicines = medicines;
	}

}