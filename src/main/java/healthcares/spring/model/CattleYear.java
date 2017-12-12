// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.Date;

/**
 * CattleYear generated by hbm2java
 */
public class CattleYear  implements java.io.Serializable {


     private Integer id;
     private Cattle cattle;
     private Member member;
     private Date date;
     private String weightyear;
     private String performer;

    public CattleYear() {
    }

    public CattleYear(Cattle cattle, Member member, Date date, String weightyear, String performer) {
       this.cattle = cattle;
       this.member = member;
       this.date = date;
       this.weightyear = weightyear;
       this.performer = performer;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Cattle getCattle() {
        return this.cattle;
    }
    
    public void setCattle(Cattle cattle) {
        this.cattle = cattle;
    }
    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getWeightyear() {
        return this.weightyear;
    }
    
    public void setWeightyear(String weightyear) {
        this.weightyear = weightyear;
    }
    public String getPerformer() {
        return this.performer;
    }
    
    public void setPerformer(String performer) {
        this.performer = performer;
    }




}


