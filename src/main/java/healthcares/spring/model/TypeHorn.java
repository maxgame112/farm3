// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.HashSet;
import java.util.Set;

/**
 * TypeHorn generated by hbm2java
 */
public class TypeHorn  implements java.io.Serializable {


     private Integer id;
     private String value;
     private Set hornDeterings = new HashSet(0);

    public TypeHorn() {
    }

    public TypeHorn(String value, Set hornDeterings) {
       this.value = value;
       this.hornDeterings = hornDeterings;
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
    public Set getHornDeterings() {
        return this.hornDeterings;
    }
    
    public void setHornDeterings(Set hornDeterings) {
        this.hornDeterings = hornDeterings;
    }




}


