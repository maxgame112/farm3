package healthcares.spring.model;
// Generated Aug 3, 2016 3:30:03 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Member generated by hbm2java
 */
@Entity
@Table(name = "member", catalog = "induct")
public class Member implements java.io.Serializable {

	private Integer id;
	private Privilege privilege;
	private String username;
	private String password;
	private String first;
	private String last;
	private String birthday;
	private String age;
	private String sex;
	private String idCard;
	private String nationality;
	private String tel;
	private String mobile;
	private String fax;
	private String address;
	private Integer zipcode;
	private String email;
	private String altemail;
	private String image;
	private Set<HornDetering> hornDeterings = new HashSet<HornDetering>(0);
	private Set<Alert> alerts = new HashSet<Alert>(0);
	private Set<Breeding> breedings = new HashSet<Breeding>(0);
	private Set<CattleWean> cattleWeans = new HashSet<CattleWean>(0);
	private Set<CattleYear> cattleYears = new HashSet<CattleYear>(0);
	private Set<TreatmentHistory> treatmentHistories = new HashSet<TreatmentHistory>(0);
	private Set<Disease> diseases = new HashSet<Disease>(0);
	private Set<Synchronize> synchronizes = new HashSet<Synchronize>(0);
	private Set<CattleStamp> cattleStamps = new HashSet<CattleStamp>(0);
	private Set<Misscarry> misscarries = new HashSet<Misscarry>(0);
	private Set<Pregnant> pregnants = new HashSet<Pregnant>(0);

	public Member() {
	}

	public Member(Privilege privilege, String username, String password, String first, String last, String birthday,
			String age, String sex, String idCard, String nationality, String tel, String mobile, String fax,
			String address, Integer zipcode, String email, String altemail, String image,
			Set<HornDetering> hornDeterings, Set<Alert> alerts, Set<Breeding> breedings, Set<CattleWean> cattleWeans,
			Set<CattleYear> cattleYears, Set<TreatmentHistory> treatmentHistories, Set<Disease> diseases,
			Set<Synchronize> synchronizes, Set<CattleStamp> cattleStamps, Set<Misscarry> misscarries,
			Set<Pregnant> pregnants) {
		this.privilege = privilege;
		this.username = username;
		this.password = password;
		this.first = first;
		this.last = last;
		this.birthday = birthday;
		this.age = age;
		this.sex = sex;
		this.idCard = idCard;
		this.nationality = nationality;
		this.tel = tel;
		this.mobile = mobile;
		this.fax = fax;
		this.address = address;
		this.zipcode = zipcode;
		this.email = email;
		this.altemail = altemail;
		this.image = image;
		this.hornDeterings = hornDeterings;
		this.alerts = alerts;
		this.breedings = breedings;
		this.cattleWeans = cattleWeans;
		this.cattleYears = cattleYears;
		this.treatmentHistories = treatmentHistories;
		this.diseases = diseases;
		this.synchronizes = synchronizes;
		this.cattleStamps = cattleStamps;
		this.misscarries = misscarries;
		this.pregnants = pregnants;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "privilege_id")
	public Privilege getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	@Column(name = "username", length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "first", length = 45)
	public String getFirst() {
		return this.first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	@Column(name = "last", length = 45)
	public String getLast() {
		return this.last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Column(name = "birthday", length = 10)
	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name = "age", length = 5)
	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Column(name = "sex", length = 5)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "id_card", length = 15)
	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	@Column(name = "nationality", length = 10)
	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Column(name = "tel", length = 15)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "mobile", length = 15)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "fax", length = 15)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "zipcode")
	public Integer getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "altemail", length = 45)
	public String getAltemail() {
		return this.altemail;
	}

	public void setAltemail(String altemail) {
		this.altemail = altemail;
	}

	@Column(name = "image", length = 45)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<HornDetering> getHornDeterings() {
		return this.hornDeterings;
	}

	public void setHornDeterings(Set<HornDetering> hornDeterings) {
		this.hornDeterings = hornDeterings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<Alert> getAlerts() {
		return this.alerts;
	}

	public void setAlerts(Set<Alert> alerts) {
		this.alerts = alerts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<Breeding> getBreedings() {
		return this.breedings;
	}

	public void setBreedings(Set<Breeding> breedings) {
		this.breedings = breedings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<CattleWean> getCattleWeans() {
		return this.cattleWeans;
	}

	public void setCattleWeans(Set<CattleWean> cattleWeans) {
		this.cattleWeans = cattleWeans;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<CattleYear> getCattleYears() {
		return this.cattleYears;
	}

	public void setCattleYears(Set<CattleYear> cattleYears) {
		this.cattleYears = cattleYears;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<TreatmentHistory> getTreatmentHistories() {
		return this.treatmentHistories;
	}

	public void setTreatmentHistories(Set<TreatmentHistory> treatmentHistories) {
		this.treatmentHistories = treatmentHistories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<Disease> getDiseases() {
		return this.diseases;
	}

	public void setDiseases(Set<Disease> diseases) {
		this.diseases = diseases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<Synchronize> getSynchronizes() {
		return this.synchronizes;
	}

	public void setSynchronizes(Set<Synchronize> synchronizes) {
		this.synchronizes = synchronizes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<CattleStamp> getCattleStamps() {
		return this.cattleStamps;
	}

	public void setCattleStamps(Set<CattleStamp> cattleStamps) {
		this.cattleStamps = cattleStamps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<Misscarry> getMisscarries() {
		return this.misscarries;
	}

	public void setMisscarries(Set<Misscarry> misscarries) {
		this.misscarries = misscarries;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<Pregnant> getPregnants() {
		return this.pregnants;
	}

	public void setPregnants(Set<Pregnant> pregnants) {
		this.pregnants = pregnants;
	}

}