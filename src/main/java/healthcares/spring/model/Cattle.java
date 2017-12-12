// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cattle generated by hbm2java
 */
public class Cattle  implements java.io.Serializable {


     private Integer id;
     private CattlePedigree cattlePedigree;
     private Color color;
     private Farm farm;
     private GroupCattle groupCattle;
     private Sex sex;
     private Stall stall;
     private StatusBorn statusBorn;
     private StatusCattle statusCattle;
     private StatusTreat statusTreat;
     private TypeCattle typeCattle;
     private TypeClassBeef typeClassBeef;
     private TypeNutrient typeNutrient;
     private String num;
     private String numEar;
     private String numDate;
     private String name;
     private Integer teeth;
     private Integer age;
     private Integer ageWean;
     private String ageHornDetering;
     private String weight;
     private String weightBirth;
     private String weightWean;
     private Date calved;
     private String maId;
     private String faId;
     private String farm_1;
     private String image;
     private Integer breedId;
     private Date alert1;
     private Date alert2;
     private Date alert3;
     private Date alert4;
     private Set synchronizes = new HashSet(0);
     private Set cattlePedigrees = new HashSet(0);
     private Set hornDeterings = new HashSet(0);
     private Set misscarries = new HashSet(0);
     private Set cattleStamps = new HashSet(0);
     private Set cattleYears = new HashSet(0);
     private Set cattleDetails = new HashSet(0);
     private Set cattleWeans = new HashSet(0);
     private Set breedingsForCattlemaId = new HashSet(0);
     private Set countBreeds = new HashSet(0);
     private Set treatmentHistories = new HashSet(0);
     private Set alerts = new HashSet(0);
     private Set breedingsForCattlefaId = new HashSet(0);

    public Cattle() {
    }

    public Cattle(CattlePedigree cattlePedigree, Color color, Farm farm, GroupCattle groupCattle, Sex sex, Stall stall, StatusBorn statusBorn, StatusCattle statusCattle, StatusTreat statusTreat, TypeCattle typeCattle, TypeClassBeef typeClassBeef, TypeNutrient typeNutrient, String num, String numEar, String numDate, String name, Integer teeth, Integer age, Integer ageWean, String ageHornDetering, String weight, String weightBirth, String weightWean, Date calved, String maId, String faId, String farm_1, String image, Integer breedId, Date alert1, Date alert2, Date alert3, Date alert4, Set synchronizes, Set cattlePedigrees, Set hornDeterings, Set misscarries, Set cattleStamps, Set cattleYears, Set cattleDetails, Set cattleWeans, Set breedingsForCattlemaId, Set countBreeds, Set treatmentHistories, Set alerts, Set breedingsForCattlefaId) {
       this.cattlePedigree = cattlePedigree;
       this.color = color;
       this.farm = farm;
       this.groupCattle = groupCattle;
       this.sex = sex;
       this.stall = stall;
       this.statusBorn = statusBorn;
       this.statusCattle = statusCattle;
       this.statusTreat = statusTreat;
       this.typeCattle = typeCattle;
       this.typeClassBeef = typeClassBeef;
       this.typeNutrient = typeNutrient;
       this.num = num;
       this.numEar = numEar;
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
       this.farm_1 = farm_1;
       this.image = image;
       this.breedId = breedId;
       this.alert1 = alert1;
       this.alert2 = alert2;
       this.alert3 = alert3;
       this.alert4 = alert4;
       this.synchronizes = synchronizes;
       this.cattlePedigrees = cattlePedigrees;
       this.hornDeterings = hornDeterings;
       this.misscarries = misscarries;
       this.cattleStamps = cattleStamps;
       this.cattleYears = cattleYears;
       this.cattleDetails = cattleDetails;
       this.cattleWeans = cattleWeans;
       this.breedingsForCattlemaId = breedingsForCattlemaId;
       this.countBreeds = countBreeds;
       this.treatmentHistories = treatmentHistories;
       this.alerts = alerts;
       this.breedingsForCattlefaId = breedingsForCattlefaId;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public CattlePedigree getCattlePedigree() {
        return this.cattlePedigree;
    }
    
    public void setCattlePedigree(CattlePedigree cattlePedigree) {
        this.cattlePedigree = cattlePedigree;
    }
    public Color getColor() {
        return this.color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    public Farm getFarm() {
        return this.farm;
    }
    
    public void setFarm(Farm farm) {
        this.farm = farm;
    }
    public GroupCattle getGroupCattle() {
        return this.groupCattle;
    }
    
    public void setGroupCattle(GroupCattle groupCattle) {
        this.groupCattle = groupCattle;
    }
    public Sex getSex() {
        return this.sex;
    }
    
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public Stall getStall() {
        return this.stall;
    }
    
    public void setStall(Stall stall) {
        this.stall = stall;
    }
    public StatusBorn getStatusBorn() {
        return this.statusBorn;
    }
    
    public void setStatusBorn(StatusBorn statusBorn) {
        this.statusBorn = statusBorn;
    }
    public StatusCattle getStatusCattle() {
        return this.statusCattle;
    }
    
    public void setStatusCattle(StatusCattle statusCattle) {
        this.statusCattle = statusCattle;
    }
    public StatusTreat getStatusTreat() {
        return this.statusTreat;
    }
    
    public void setStatusTreat(StatusTreat statusTreat) {
        this.statusTreat = statusTreat;
    }
    public TypeCattle getTypeCattle() {
        return this.typeCattle;
    }
    
    public void setTypeCattle(TypeCattle typeCattle) {
        this.typeCattle = typeCattle;
    }
    public TypeClassBeef getTypeClassBeef() {
        return this.typeClassBeef;
    }
    
    public void setTypeClassBeef(TypeClassBeef typeClassBeef) {
        this.typeClassBeef = typeClassBeef;
    }
    public TypeNutrient getTypeNutrient() {
        return this.typeNutrient;
    }
    
    public void setTypeNutrient(TypeNutrient typeNutrient) {
        this.typeNutrient = typeNutrient;
    }
    public String getNum() {
        return this.num;
    }
    
    public void setNum(String num) {
        this.num = num;
    }
    public String getNumEar() {
        return this.numEar;
    }
    
    public void setNumEar(String numEar) {
        this.numEar = numEar;
    }
    public String getNumDate() {
        return this.numDate;
    }
    
    public void setNumDate(String numDate) {
        this.numDate = numDate;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Integer getTeeth() {
        return this.teeth;
    }
    
    public void setTeeth(Integer teeth) {
        this.teeth = teeth;
    }
    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAgeWean() {
        return this.ageWean;
    }
    
    public void setAgeWean(Integer ageWean) {
        this.ageWean = ageWean;
    }
    public String getAgeHornDetering() {
        return this.ageHornDetering;
    }
    
    public void setAgeHornDetering(String ageHornDetering) {
        this.ageHornDetering = ageHornDetering;
    }
    public String getWeight() {
        return this.weight;
    }
    
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getWeightBirth() {
        return this.weightBirth;
    }
    
    public void setWeightBirth(String weightBirth) {
        this.weightBirth = weightBirth;
    }
    public String getWeightWean() {
        return this.weightWean;
    }
    
    public void setWeightWean(String weightWean) {
        this.weightWean = weightWean;
    }
    public Date getCalved() {
        return this.calved;
    }
    
    public void setCalved(Date calved) {
        this.calved = calved;
    }
    public String getMaId() {
        return this.maId;
    }
    
    public void setMaId(String maId) {
        this.maId = maId;
    }
    public String getFaId() {
        return this.faId;
    }
    
    public void setFaId(String faId) {
        this.faId = faId;
    }
    public String getFarm_1() {
        return this.farm_1;
    }
    
    public void setFarm_1(String farm_1) {
        this.farm_1 = farm_1;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public Integer getBreedId() {
        return this.breedId;
    }
    
    public void setBreedId(Integer breedId) {
        this.breedId = breedId;
    }
    public Date getAlert1() {
        return this.alert1;
    }
    
    public void setAlert1(Date alert1) {
        this.alert1 = alert1;
    }
    public Date getAlert2() {
        return this.alert2;
    }
    
    public void setAlert2(Date alert2) {
        this.alert2 = alert2;
    }
    public Date getAlert3() {
        return this.alert3;
    }
    
    public void setAlert3(Date alert3) {
        this.alert3 = alert3;
    }
    public Date getAlert4() {
        return this.alert4;
    }
    
    public void setAlert4(Date alert4) {
        this.alert4 = alert4;
    }
    public Set getSynchronizes() {
        return this.synchronizes;
    }
    
    public void setSynchronizes(Set synchronizes) {
        this.synchronizes = synchronizes;
    }
    public Set getCattlePedigrees() {
        return this.cattlePedigrees;
    }
    
    public void setCattlePedigrees(Set cattlePedigrees) {
        this.cattlePedigrees = cattlePedigrees;
    }
    public Set getHornDeterings() {
        return this.hornDeterings;
    }
    
    public void setHornDeterings(Set hornDeterings) {
        this.hornDeterings = hornDeterings;
    }
    public Set getMisscarries() {
        return this.misscarries;
    }
    
    public void setMisscarries(Set misscarries) {
        this.misscarries = misscarries;
    }
    public Set getCattleStamps() {
        return this.cattleStamps;
    }
    
    public void setCattleStamps(Set cattleStamps) {
        this.cattleStamps = cattleStamps;
    }
    public Set getCattleYears() {
        return this.cattleYears;
    }
    
    public void setCattleYears(Set cattleYears) {
        this.cattleYears = cattleYears;
    }
    public Set getCattleDetails() {
        return this.cattleDetails;
    }
    
    public void setCattleDetails(Set cattleDetails) {
        this.cattleDetails = cattleDetails;
    }
    public Set getCattleWeans() {
        return this.cattleWeans;
    }
    
    public void setCattleWeans(Set cattleWeans) {
        this.cattleWeans = cattleWeans;
    }
    public Set getBreedingsForCattlemaId() {
        return this.breedingsForCattlemaId;
    }
    
    public void setBreedingsForCattlemaId(Set breedingsForCattlemaId) {
        this.breedingsForCattlemaId = breedingsForCattlemaId;
    }
    public Set getCountBreeds() {
        return this.countBreeds;
    }
    
    public void setCountBreeds(Set countBreeds) {
        this.countBreeds = countBreeds;
    }
    public Set getTreatmentHistories() {
        return this.treatmentHistories;
    }
    
    public void setTreatmentHistories(Set treatmentHistories) {
        this.treatmentHistories = treatmentHistories;
    }
    public Set getAlerts() {
        return this.alerts;
    }
    
    public void setAlerts(Set alerts) {
        this.alerts = alerts;
    }
    public Set getBreedingsForCattlefaId() {
        return this.breedingsForCattlefaId;
    }
    
    public void setBreedingsForCattlefaId(Set breedingsForCattlefaId) {
        this.breedingsForCattlefaId = breedingsForCattlefaId;
    }




}


