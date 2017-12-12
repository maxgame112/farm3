// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.HashSet;
import java.util.Set;

/**
 * Farm generated by hbm2java
 */
public class Farm  implements java.io.Serializable {


     private Integer id;
     private String nameThai;
     private String nameEng;
     private String shotName;
     private String address;
     private String phone;
     private Set cattles = new HashSet(0);
     private Set cattlePedigrees = new HashSet(0);

    public Farm() {
    }

    public Farm(String nameThai, String nameEng, String shotName, String address, String phone, Set cattles, Set cattlePedigrees) {
       this.nameThai = nameThai;
       this.nameEng = nameEng;
       this.shotName = shotName;
       this.address = address;
       this.phone = phone;
       this.cattles = cattles;
       this.cattlePedigrees = cattlePedigrees;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNameThai() {
        return this.nameThai;
    }
    
    public void setNameThai(String nameThai) {
        this.nameThai = nameThai;
    }
    public String getNameEng() {
        return this.nameEng;
    }
    
    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }
    public String getShotName() {
        return this.shotName;
    }
    
    public void setShotName(String shotName) {
        this.shotName = shotName;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Set getCattles() {
        return this.cattles;
    }
    
    public void setCattles(Set cattles) {
        this.cattles = cattles;
    }
    public Set getCattlePedigrees() {
        return this.cattlePedigrees;
    }
    
    public void setCattlePedigrees(Set cattlePedigrees) {
        this.cattlePedigrees = cattlePedigrees;
    }




}


