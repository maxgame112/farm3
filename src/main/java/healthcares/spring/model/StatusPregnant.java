// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.HashSet;
import java.util.Set;

/**
 * StatusPregnant generated by hbm2java
 */
public class StatusPregnant  implements java.io.Serializable {


     private Integer id;
     private String value;
     private Set pregnants = new HashSet(0);

    public StatusPregnant() {
    }

    public StatusPregnant(String value, Set pregnants) {
       this.value = value;
       this.pregnants = pregnants;
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
    public Set getPregnants() {
        return this.pregnants;
    }
    
    public void setPregnants(Set pregnants) {
        this.pregnants = pregnants;
    }




}


