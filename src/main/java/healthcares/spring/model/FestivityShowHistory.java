// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final



/**
 * FestivityShowHistory generated by hbm2java
 */
public class FestivityShowHistory  implements java.io.Serializable {


     private Integer id;
     private Festivity festivity;
     private String cowId;

    public FestivityShowHistory() {
    }

    public FestivityShowHistory(Festivity festivity, String cowId) {
       this.festivity = festivity;
       this.cowId = cowId;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Festivity getFestivity() {
        return this.festivity;
    }
    
    public void setFestivity(Festivity festivity) {
        this.festivity = festivity;
    }
    public String getCowId() {
        return this.cowId;
    }
    
    public void setCowId(String cowId) {
        this.cowId = cowId;
    }




}

