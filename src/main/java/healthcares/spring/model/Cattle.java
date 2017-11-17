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

import com.google.gson.annotations.Expose;

/**
 * Cattle generated by hbm2java
 */
@Entity
@Table(name = "cattle", catalog = "induct")
public class Cattle implements java.io.Serializable {

	private Integer id;
	private StatusBreed statusBreed;
	private Color color;
	private GroupCattle groupCattle;
	private StatusTreat statusTreat;
	private Stall stall;
	private StatusCattle statusCattle;
	private TypeCattle typeCattle;
	private StatusBorn statusBorn;
	private Sex sex;
	@Expose private String num;
	@Expose private String numDate;
	@Expose private String name;
	@Expose private Integer teeth;
	private Integer age;
	private Integer ageWean;
	private String ageHornDetering;
	@Expose private String weight;
	@Expose private String weightBirth;
	@Expose private String weightWean;
	private String calved;
	private String maId;
	private String faId;
	private String farm;
	private String image;
	@Expose	private String alert1;
	@Expose private String alert2;
	@Expose private String alert3;
	@Expose private String alert4;
	private Set<Breeding> breedingsForCattlefaId = new HashSet<Breeding>(0);
	private Set<Breeding> breedingsForCattlemaId = new HashSet<Breeding>(0);
	private Set<Misscarry> misscarries = new HashSet<Misscarry>(0);
	private Set<CattleWean> cattleWeans = new HashSet<CattleWean>(0);
	private Set<HornDetering> hornDeterings = new HashSet<HornDetering>(0);
	private Set<TreatmentHistory> treatmentHistories = new HashSet<TreatmentHistory>(0);
	private Set<CountBreed> countBreeds = new HashSet<CountBreed>(0);
	private Set<CattleStamp> cattleStamps = new HashSet<CattleStamp>(0);
	private Set<Synchronize> synchronizes = new HashSet<Synchronize>(0);
	private Set<Alert> alerts = new HashSet<Alert>(0);
	private Set<CattleYear> cattleYears = new HashSet<CattleYear>(0);

	public Cattle() {
	}

	public Cattle(StatusBreed statusBreed, Color color, GroupCattle groupCattle, StatusTreat statusTreat, Stall stall,
			StatusCattle statusCattle, TypeCattle typeCattle, StatusBorn statusBorn, Sex sex, String num,
			String numDate, String name, Integer teeth, Integer age, Integer ageWean, String ageHornDetering,
			String weight, String weightBirth, String weightWean, String calved, String maId, String faId, String farm,
			String image, String alert1, String alert2, String alert3, String alert4, Set<Breeding> breedingsForCattlefaId,
			Set<Breeding> breedingsForCattlemaId, Set<Misscarry> misscarries, Set<CattleWean> cattleWeans,
			Set<HornDetering> hornDeterings, Set<TreatmentHistory> treatmentHistories, Set<CountBreed> countBreeds,
			Set<CattleStamp> cattleStamps, Set<Synchronize> synchronizes, Set<Alert> alerts,
			Set<CattleYear> cattleYears) {
		this.statusBreed = statusBreed;
		this.color = color;
		this.groupCattle = groupCattle;
		this.statusTreat = statusTreat;
		this.stall = stall;
		this.statusCattle = statusCattle;
		this.typeCattle = typeCattle;
		this.statusBorn = statusBorn;
		this.sex = sex;
		this.num = num;
		this.numDate = numDate;
		this.name = name;
		this.teeth = teeth;
		this.age = age;
		this.ageWean = ageWean;
		this.ageHornDetering = ageHornDetering;
		this.weight = weight;
		this.weightBirth = weightBirth;
		this.weightWean = weightWean;
		this.calved = calved;
		this.maId = maId;
		this.faId = faId;
		this.farm = farm;
		this.image = image;
		this.alert1 = alert1;
		this.alert2 = alert2;
		this.alert3 = alert3;
		this.alert4 = alert4;
		this.breedingsForCattlefaId = breedingsForCattlefaId;
		this.breedingsForCattlemaId = breedingsForCattlemaId;
		this.misscarries = misscarries;
		this.cattleWeans = cattleWeans;
		this.hornDeterings = hornDeterings;
		this.treatmentHistories = treatmentHistories;
		this.countBreeds = countBreeds;
		this.cattleStamps = cattleStamps;
		this.synchronizes = synchronizes;
		this.alerts = alerts;
		this.cattleYears = cattleYears;
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
	@JoinColumn(name = "status_breed_id")
	public StatusBreed getStatusBreed() {
		return this.statusBreed;
	}

	public void setStatusBreed(StatusBreed statusBreed) {
		this.statusBreed = statusBreed;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "color_id")
	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_cattle__id")
	public GroupCattle getGroupCattle() {
		return this.groupCattle;
	}

	public void setGroupCattle(GroupCattle groupCattle) {
		this.groupCattle = groupCattle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_treat_id")
	public StatusTreat getStatusTreat() {
		return this.statusTreat;
	}

	public void setStatusTreat(StatusTreat statusTreat) {
		this.statusTreat = statusTreat;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "stall_id")
	public Stall getStall() {
		return this.stall;
	}

	public void setStall(Stall stall) {
		this.stall = stall;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_cattle_id")
	public StatusCattle getStatusCattle() {
		return this.statusCattle;
	}

	public void setStatusCattle(StatusCattle statusCattle) {
		this.statusCattle = statusCattle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_cattle_id")
	public TypeCattle getTypeCattle() {
		return this.typeCattle;
	}

	public void setTypeCattle(TypeCattle typeCattle) {
		this.typeCattle = typeCattle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_born_id")
	public StatusBorn getStatusBorn() {
		return this.statusBorn;
	}

	public void setStatusBorn(StatusBorn statusBorn) {
		this.statusBorn = statusBorn;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sex_id")
	public Sex getSex() {
		return this.sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Column(name = "num", length = 45)
	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@Column(name = "num_date", length = 45)
	public String getNumDate() {
		return this.numDate;
	}

	public void setNumDate(String numDate) {
		this.numDate = numDate;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "teeth")
	public Integer getTeeth() {
		return this.teeth;
	}

	public void setTeeth(Integer teeth) {
		this.teeth = teeth;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "age_wean")
	public Integer getAgeWean() {
		return this.ageWean;
	}

	public void setAgeWean(Integer ageWean) {
		this.ageWean = ageWean;
	}

	@Column(name = "age_horn_detering", length = 45)
	public String getAgeHornDetering() {
		return this.ageHornDetering;
	}

	public void setAgeHornDetering(String ageHornDetering) {
		this.ageHornDetering = ageHornDetering;
	}

	@Column(name = "weight", length = 45)
	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Column(name = "weight_birth", length = 45)
	public String getWeightBirth() {
		return this.weightBirth;
	}

	public void setWeightBirth(String weightBirth) {
		this.weightBirth = weightBirth;
	}

	@Column(name = "weight_wean", length = 45)
	public String getWeightWean() {
		return this.weightWean;
	}

	public void setWeightWean(String weightWean) {
		this.weightWean = weightWean;
	}

	@Column(name = "calved", length = 10)
	public String getCalved() {
		return this.calved;
	}

	public void setCalved(String calved) {
		this.calved = calved;
	}

	@Column(name = "ma_id", length = 45)
	public String getMaId() {
		return this.maId;
	}

	public void setMaId(String maId) {
		this.maId = maId;
	}

	@Column(name = "fa_id", length = 45)
	public String getFaId() {
		return this.faId;
	}

	public void setFaId(String faId) {
		this.faId = faId;
	}

	@Column(name = "farm", length = 45)
	public String getFarm() {
		return this.farm;
	}

	public void setFarm(String farm) {
		this.farm = farm;
	}

	@Column(name = "image", length = 100)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "alert1", length = 10)
	public String getAlert1() {
		return this.alert1;
	}

	public void setAlert1(String alert1) {
		this.alert1 = alert1;
	}


	@Column(name = "alert2", length = 10)
	public String getAlert2() {
		return this.alert2;
	}

	public void setAlert2(String alert2) {
		this.alert2 = alert2;
	}

	@Column(name = "alert3", length = 10)
	public String getAlert3() {
		return this.alert3;
	}

	public void setAlert3(String alert3) {
		this.alert3 = alert3;
	}

	@Column(name = "alert4", length = 10)
	public String getAlert4() {
		return this.alert4;
	}

	public void setAlert4(String alert4) {
		this.alert4 = alert4;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cattleByCattlefaId")
	public Set<Breeding> getBreedingsForCattlefaId() {
		return this.breedingsForCattlefaId;
	}

	public void setBreedingsForCattlefaId(Set<Breeding> breedingsForCattlefaId) {
		this.breedingsForCattlefaId = breedingsForCattlefaId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cattleByCattlemaId")
	public Set<Breeding> getBreedingsForCattlemaId() {
		return this.breedingsForCattlemaId;
	}

	public void setBreedingsForCattlemaId(Set<Breeding> breedingsForCattlemaId) {
		this.breedingsForCattlemaId = breedingsForCattlemaId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cattle")
	public Set<Misscarry> getMisscarries() {
		return this.misscarries;
	}

	public void setMisscarries(Set<Misscarry> misscarries) {
		this.misscarries = misscarries;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cattle")
	public Set<CattleWean> getCattleWeans() {
		return this.cattleWeans;
	}

	public void setCattleWeans(Set<CattleWean> cattleWeans) {
		this.cattleWeans = cattleWeans;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cattle")
	public Set<HornDetering> getHornDeterings() {
		return this.hornDeterings;
	}

	public void setHornDeterings(Set<HornDetering> hornDeterings) {
		this.hornDeterings = hornDeterings;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cattle")
	public Set<TreatmentHistory> getTreatmentHistories() {
		return this.treatmentHistories;
	}

	public void setTreatmentHistories(Set<TreatmentHistory> treatmentHistories) {
		this.treatmentHistories = treatmentHistories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cattle")
	public Set<CountBreed> getCountBreeds() {
		return this.countBreeds;
	}

	public void setCountBreeds(Set<CountBreed> countBreeds) {
		this.countBreeds = countBreeds;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cattle")
	public Set<CattleStamp> getCattleStamps() {
		return this.cattleStamps;
	}

	public void setCattleStamps(Set<CattleStamp> cattleStamps) {
		this.cattleStamps = cattleStamps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cattle")
	public Set<Synchronize> getSynchronizes() {
		return this.synchronizes;
	}

	public void setSynchronizes(Set<Synchronize> synchronizes) {
		this.synchronizes = synchronizes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cattle")
	public Set<Alert> getAlerts() {
		return this.alerts;
	}

	public void setAlerts(Set<Alert> alerts) {
		this.alerts = alerts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cattle")
	public Set<CattleYear> getCattleYears() {
		return this.cattleYears;
	}

	public void setCattleYears(Set<CattleYear> cattleYears) {
		this.cattleYears = cattleYears;
	}

}
