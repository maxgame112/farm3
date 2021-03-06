// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.HashSet;
import java.util.Set;

/**
 * StatusBill generated by hbm2java
 */
public class StatusBill  implements java.io.Serializable {


     private Integer id;
     private String value;
     private Set bills = new HashSet(0);

    public StatusBill() {
    }

    public StatusBill(String value, Set bills) {
       this.value = value;
       this.bills = bills;
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
    public Set getBills() {
        return this.bills;
    }
    
    public void setBills(Set bills) {
        this.bills = bills;
    }




}


