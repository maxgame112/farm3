// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.HashSet;
import java.util.Set;

/**
 * UnitNutrient generated by hbm2java
 */
public class UnitNutrient  implements java.io.Serializable {


     private Integer id;
     private String value;
     private Set cattleNutrients = new HashSet(0);
     private Set rawMaterialNutrients = new HashSet(0);

    public UnitNutrient() {
    }

    public UnitNutrient(String value, Set cattleNutrients, Set rawMaterialNutrients) {
       this.value = value;
       this.cattleNutrients = cattleNutrients;
       this.rawMaterialNutrients = rawMaterialNutrients;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
    public Set getRawMaterialNutrients() {
        return this.rawMaterialNutrients;
    }
    
    public void setRawMaterialNutrients(Set rawMaterialNutrients) {
        this.rawMaterialNutrients = rawMaterialNutrients;
    }




}

