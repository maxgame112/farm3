// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.HashSet;
import java.util.Set;

/**
 * TypeSync generated by hbm2java
 */
public class TypeSync  implements java.io.Serializable {


     private Integer id;
     private String value;
     private Set synchronizes = new HashSet(0);
     private Set syncs = new HashSet(0);

    public TypeSync() {
    }

    public TypeSync(String value, Set synchronizes, Set syncs) {
       this.value = value;
       this.synchronizes = synchronizes;
       this.syncs = syncs;
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
    public Set getSynchronizes() {
        return this.synchronizes;
    }
    
    public void setSynchronizes(Set synchronizes) {
        this.synchronizes = synchronizes;
    }
    public Set getSyncs() {
        return this.syncs;
    }
    
    public void setSyncs(Set syncs) {
        this.syncs = syncs;
    }




}


