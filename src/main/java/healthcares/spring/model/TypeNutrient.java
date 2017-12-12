// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.HashSet;
import java.util.Set;

/**
 * TypeNutrient generated by hbm2java
 */
public class TypeNutrient  implements java.io.Serializable {


     private Integer id;
     private FormulaRecord formulaRecord;
     private String value;
     private Set cattleNutrients = new HashSet(0);
     private Set cattles = new HashSet(0);

    public TypeNutrient() {
    }

    public TypeNutrient(FormulaRecord formulaRecord, String value, Set cattleNutrients, Set cattles) {
       this.formulaRecord = formulaRecord;
       this.value = value;
       this.cattleNutrients = cattleNutrients;
       this.cattles = cattles;
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
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    public Set getCattleNutrients() {
        return this.cattleNutrients;
    }
    
    public void setCattleNutrients(Set cattleNutrients) {
        this.cattleNutrients = cattleNutrients;
    }
    public Set getCattles() {
        return this.cattles;
    }
    
    public void setCattles(Set cattles) {
        this.cattles = cattles;
    }




}


