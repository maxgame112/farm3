// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final



/**
 * TypeMedicine generated by hbm2java
 */
public class TypeMedicine  implements java.io.Serializable {


     private Integer id;
     private String value;

    public TypeMedicine() {
    }

    public TypeMedicine(String value) {
       this.value = value;
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




}


