// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.HashSet;
import java.util.Set;

/**
 * StatusTreat generated by hbm2java
 */
public class StatusTreat  implements java.io.Serializable {


     private Integer id;
     private String value;
     private Set treatmentHistories = new HashSet(0);
     private Set cattles = new HashSet(0);

    public StatusTreat() {
    }

    public StatusTreat(String value, Set treatmentHistories, Set cattles) {
       this.value = value;
       this.treatmentHistories = treatmentHistories;
       this.cattles = cattles;
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
    public Set getTreatmentHistories() {
        return this.treatmentHistories;
    }
    
    public void setTreatmentHistories(Set treatmentHistories) {
        this.treatmentHistories = treatmentHistories;
    }
    public Set getCattles() {
        return this.cattles;
    }
    
    public void setCattles(Set cattles) {
        this.cattles = cattles;
    }




}


