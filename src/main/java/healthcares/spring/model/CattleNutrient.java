// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.Date;

/**
 * CattleNutrient generated by hbm2java
 */
public class CattleNutrient  implements java.io.Serializable {


     private Integer id;
     private FormulaRecord formulaRecord;
     private TypeNutrient typeNutrient;
     private UnitNutrient unitNutrient;
     private Date date;
     private Float dm;
     private Float nem;
     private Float neg;
     private Float ca;
     private Float p;
     private Float mp;
     private Float me;
     private Float protein;
     private Float tdn;
     private Float nel;
     private Float ndf;
     private Float adf;
     private Float uip;
     private Float dip;
     private Float vitA;
     private Float vitE;
     private Float nfc;
     private Float nfcperDip;
     private Float ndfRoughage;
     private Float urea;
     private Float cp;
     private Float costsWeight;
     private Float costsFood;

    public CattleNutrient() {
    }

    public CattleNutrient(FormulaRecord formulaRecord, TypeNutrient typeNutrient, UnitNutrient unitNutrient, Date date, Float dm, Float nem, Float neg, Float ca, Float p, Float mp, Float me, Float protein, Float tdn, Float nel, Float ndf, Float adf, Float uip, Float dip, Float vitA, Float vitE, Float nfc, Float nfcperDip, Float ndfRoughage, Float urea, Float cp, Float costsWeight, Float costsFood) {
       this.formulaRecord = formulaRecord;
       this.typeNutrient = typeNutrient;
       this.unitNutrient = unitNutrient;
       this.date = date;
       this.dm = dm;
       this.nem = nem;
       this.neg = neg;
       this.ca = ca;
       this.p = p;
       this.mp = mp;
       this.me = me;
       this.protein = protein;
       this.tdn = tdn;
       this.nel = nel;
       this.ndf = ndf;
       this.adf = adf;
       this.uip = uip;
       this.dip = dip;
       this.vitA = vitA;
       this.vitE = vitE;
       this.nfc = nfc;
       this.nfcperDip = nfcperDip;
       this.ndfRoughage = ndfRoughage;
       this.urea = urea;
       this.cp = cp;
       this.costsWeight = costsWeight;
       this.costsFood = costsFood;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public FormulaRecord getFormulaRecord() {
        return this.formulaRecord;
    }
    
    public void setFormulaRecord(FormulaRecord formulaRecord) {
        this.formulaRecord = formulaRecord;
    }
    public TypeNutrient getTypeNutrient() {
        return this.typeNutrient;
    }
    
    public void setTypeNutrient(TypeNutrient typeNutrient) {
        this.typeNutrient = typeNutrient;
    }
    public UnitNutrient getUnitNutrient() {
        return this.unitNutrient;
    }
    
    public void setUnitNutrient(UnitNutrient unitNutrient) {
        this.unitNutrient = unitNutrient;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public Float getDm() {
        return this.dm;
    }
    
    public void setDm(Float dm) {
        this.dm = dm;
    }
    public Float getNem() {
        return this.nem;
    }
    
    public void setNem(Float nem) {
        this.nem = nem;
    }
    public Float getNeg() {
        return this.neg;
    }
    
    public void setNeg(Float neg) {
        this.neg = neg;
    }
    public Float getCa() {
        return this.ca;
    }
    
    public void setCa(Float ca) {
        this.ca = ca;
    }
    public Float getP() {
        return this.p;
    }
    
    public void setP(Float p) {
        this.p = p;
    }
    public Float getMp() {
        return this.mp;
    }
    
    public void setMp(Float mp) {
        this.mp = mp;
    }
    public Float getMe() {
        return this.me;
    }
    
    public void setMe(Float me) {
        this.me = me;
    }
    public Float getProtein() {
        return this.protein;
    }
    
    public void setProtein(Float protein) {
        this.protein = protein;
    }
    public Float getTdn() {
        return this.tdn;
    }
    
    public void setTdn(Float tdn) {
        this.tdn = tdn;
    }
    public Float getNel() {
        return this.nel;
    }
    
    public void setNel(Float nel) {
        this.nel = nel;
    }
    public Float getNdf() {
        return this.ndf;
    }
    
    public void setNdf(Float ndf) {
        this.ndf = ndf;
    }
    public Float getAdf() {
        return this.adf;
    }
    
    public void setAdf(Float adf) {
        this.adf = adf;
    }
    public Float getUip() {
        return this.uip;
    }
    
    public void setUip(Float uip) {
        this.uip = uip;
    }
    public Float getDip() {
        return this.dip;
    }
    
    public void setDip(Float dip) {
        this.dip = dip;
    }
    public Float getVitA() {
        return this.vitA;
    }
    
    public void setVitA(Float vitA) {
        this.vitA = vitA;
    }
    public Float getVitE() {
        return this.vitE;
    }
    
    public void setVitE(Float vitE) {
        this.vitE = vitE;
    }
    public Float getNfc() {
        return this.nfc;
    }
    
    public void setNfc(Float nfc) {
        this.nfc = nfc;
    }
    public Float getNfcperDip() {
        return this.nfcperDip;
    }
    
    public void setNfcperDip(Float nfcperDip) {
        this.nfcperDip = nfcperDip;
    }
    public Float getNdfRoughage() {
        return this.ndfRoughage;
    }
    
    public void setNdfRoughage(Float ndfRoughage) {
        this.ndfRoughage = ndfRoughage;
    }
    public Float getUrea() {
        return this.urea;
    }
    
    public void setUrea(Float urea) {
        this.urea = urea;
    }
    public Float getCp() {
        return this.cp;
    }
    
    public void setCp(Float cp) {
        this.cp = cp;
    }
    public Float getCostsWeight() {
        return this.costsWeight;
    }
    
    public void setCostsWeight(Float costsWeight) {
        this.costsWeight = costsWeight;
    }
    public Float getCostsFood() {
        return this.costsFood;
    }
    
    public void setCostsFood(Float costsFood) {
        this.costsFood = costsFood;
    }




}


