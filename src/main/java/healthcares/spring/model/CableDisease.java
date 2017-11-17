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
 * CableDisease generated by hbm2java
 */
@Entity
@Table(name = "cable_disease", catalog = "induct")
public class CableDisease implements java.io.Serializable {

	private Integer id;
	private String value;
	private Set<Disease> diseases = new HashSet<Disease>(0);

	public CableDisease() {
	}

	public CableDisease(String value, Set<Disease> diseases) {
		this.value = value;
		this.diseases = diseases;
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

	@Column(name = "value", length = 100)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cableDisease")
	public Set<Disease> getDiseases() {
		return this.diseases;
	}

	public void setDiseases(Set<Disease> diseases) {
		this.diseases = diseases;
	}

}
