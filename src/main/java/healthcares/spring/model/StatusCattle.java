// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.HashSet;
import java.util.Set;

/**
 * StatusCattle generated by hbm2java
 */
public class StatusCattle  implements java.io.Serializable {


     private Integer id;
     private String value;
     private Set cattles = new HashSet(0);

    public StatusCattle() {
    }

    public StatusCattle(String value, Set cattles) {
       this.value = value;
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
    public Set getCattles() {
        return this.cattles;
    }
    
    public void setCattles(Set cattles) {
        this.cattles = cattles;
    }




}


