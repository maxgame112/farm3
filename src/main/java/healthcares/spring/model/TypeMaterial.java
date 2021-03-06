// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.HashSet;
import java.util.Set;

/**
 * TypeMaterial generated by hbm2java
 */
public class TypeMaterial  implements java.io.Serializable {


     private Integer id;
     private String value;
     private Set rawMaterials = new HashSet(0);

    public TypeMaterial() {
    }

    public TypeMaterial(String value, Set rawMaterials) {
       this.value = value;
       this.rawMaterials = rawMaterials;
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
    public Set getRawMaterials() {
        return this.rawMaterials;
    }
    
    public void setRawMaterials(Set rawMaterials) {
        this.rawMaterials = rawMaterials;
    }




}


