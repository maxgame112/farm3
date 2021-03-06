// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.Date;

/**
 * TreatmentHistory generated by hbm2java
 */
public class TreatmentHistory  implements java.io.Serializable {


     private Integer id;
     private Cattle cattle;
     private Disease disease;
     private Medicine medicine;
     private Member member;
     private StatusDisease statusDisease;
     private StatusMedicine statusMedicine;
     private StatusTreat statusTreat;
     private String symptom;
     private String causeOfIllness;
     private String beAllergic;
     private Date dateTreat;
     private Date dateEndTreat;
     private String doseUsesage;
     private Date dateTreatHorn;
     private Date dateTreatNum;
     private Date dateTreatBirth;
     private Date dateEndTreatHorn;
     private Date dateEndTreatNum;
     private Date dateEndTreatBirth;
     private Date dateStartMed;
     private Date dateStopMed;
     private String note;

    public TreatmentHistory() {
    }

    public TreatmentHistory(Cattle cattle, Disease disease, Medicine medicine, Member member, StatusDisease statusDisease, StatusMedicine statusMedicine, StatusTreat statusTreat, String symptom, String causeOfIllness, String beAllergic, Date dateTreat, Date dateEndTreat, String doseUsesage, Date dateTreatHorn, Date dateTreatNum, Date dateTreatBirth, Date dateEndTreatHorn, Date dateEndTreatNum, Date dateEndTreatBirth, Date dateStartMed, Date dateStopMed, String note) {
       this.cattle = cattle;
       this.disease = disease;
       this.medicine = medicine;
       this.member = member;
       this.statusDisease = statusDisease;
       this.statusMedicine = statusMedicine;
       this.statusTreat = statusTreat;
       this.symptom = symptom;
       this.causeOfIllness = causeOfIllness;
       this.beAllergic = beAllergic;
       this.dateTreat = dateTreat;
       this.dateEndTreat = dateEndTreat;
       this.doseUsesage = doseUsesage;
       this.dateTreatHorn = dateTreatHorn;
       this.dateTreatNum = dateTreatNum;
       this.dateTreatBirth = dateTreatBirth;
       this.dateEndTreatHorn = dateEndTreatHorn;
       this.dateEndTreatNum = dateEndTreatNum;
       this.dateEndTreatBirth = dateEndTreatBirth;
       this.dateStartMed = dateStartMed;
       this.dateStopMed = dateStopMed;
       this.note = note;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Cattle getCattle() {
        return this.cattle;
    }
    
    public void setCattle(Cattle cattle) {
        this.cattle = cattle;
    }
    public Disease getDisease() {
        return this.disease;
    }
    
    public void setDisease(Disease disease) {
        this.disease = disease;
    }
    public Medicine getMedicine() {
        return this.medicine;
    }
    
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
    public StatusDisease getStatusDisease() {
        return this.statusDisease;
    }
    
    public void setStatusDisease(StatusDisease statusDisease) {
        this.statusDisease = statusDisease;
    }
    public StatusMedicine getStatusMedicine() {
        return this.statusMedicine;
    }
    
    public void setStatusMedicine(StatusMedicine statusMedicine) {
        this.statusMedicine = statusMedicine;
    }
    public StatusTreat getStatusTreat() {
        return this.statusTreat;
    }
    
    public void setStatusTreat(StatusTreat statusTreat) {
        this.statusTreat = statusTreat;
    }
    public String getSymptom() {
        return this.symptom;
    }
    
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
    public String getCauseOfIllness() {
        return this.causeOfIllness;
    }
    
    public void setCauseOfIllness(String causeOfIllness) {
        this.causeOfIllness = causeOfIllness;
    }
    public String getBeAllergic() {
        return this.beAllergic;
    }
    
    public void setBeAllergic(String beAllergic) {
        this.beAllergic = beAllergic;
    }
    public Date getDateTreat() {
        return this.dateTreat;
    }
    
    public void setDateTreat(Date dateTreat) {
        this.dateTreat = dateTreat;
    }
    public Date getDateEndTreat() {
        return this.dateEndTreat;
    }
    
    public void setDateEndTreat(Date dateEndTreat) {
        this.dateEndTreat = dateEndTreat;
    }
    public String getDoseUsesage() {
        return this.doseUsesage;
    }
    
    public void setDoseUsesage(String doseUsesage) {
        this.doseUsesage = doseUsesage;
    }
    public Date getDateTreatHorn() {
        return this.dateTreatHorn;
    }
    
    public void setDateTreatHorn(Date dateTreatHorn) {
        this.dateTreatHorn = dateTreatHorn;
    }
    public Date getDateTreatNum() {
        return this.dateTreatNum;
    }
    
    public void setDateTreatNum(Date dateTreatNum) {
        this.dateTreatNum = dateTreatNum;
    }
    public Date getDateTreatBirth() {
        return this.dateTreatBirth;
    }
    
    public void setDateTreatBirth(Date dateTreatBirth) {
        this.dateTreatBirth = dateTreatBirth;
    }
    public Date getDateEndTreatHorn() {
        return this.dateEndTreatHorn;
    }
    
    public void setDateEndTreatHorn(Date dateEndTreatHorn) {
        this.dateEndTreatHorn = dateEndTreatHorn;
    }
    public Date getDateEndTreatNum() {
        return this.dateEndTreatNum;
    }
    
    public void setDateEndTreatNum(Date dateEndTreatNum) {
        this.dateEndTreatNum = dateEndTreatNum;
    }
    public Date getDateEndTreatBirth() {
        return this.dateEndTreatBirth;
    }
    
    public void setDateEndTreatBirth(Date dateEndTreatBirth) {
        this.dateEndTreatBirth = dateEndTreatBirth;
    }
    public Date getDateStartMed() {
        return this.dateStartMed;
    }
    
    public void setDateStartMed(Date dateStartMed) {
        this.dateStartMed = dateStartMed;
    }
    public Date getDateStopMed() {
        return this.dateStopMed;
    }
    
    public void setDateStopMed(Date dateStopMed) {
        this.dateStopMed = dateStopMed;
    }
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }




}


