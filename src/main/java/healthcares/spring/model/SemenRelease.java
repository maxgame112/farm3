// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.Date;

/**
 * SemenRelease generated by hbm2java
 */
public class SemenRelease  implements java.io.Serializable {


     private Integer id;
     private Member member;
     private Semen semen;
     private Date day;
     private Integer quantity;
     private Integer billId;

    public SemenRelease() {
    }

	
    public SemenRelease(Member member, Semen semen, Date day) {
        this.member = member;
        this.semen = semen;
        this.day = day;
    }
    public SemenRelease(Member member, Semen semen, Date day, Integer quantity, Integer billId) {
       this.member = member;
       this.semen = semen;
       this.day = day;
       this.quantity = quantity;
       this.billId = billId;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
    public Semen getSemen() {
        return this.semen;
    }
    
    public void setSemen(Semen semen) {
        this.semen = semen;
    }
    public Date getDay() {
        return this.day;
    }
    
    public void setDay(Date day) {
        this.day = day;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getBillId() {
        return this.billId;
    }
    
    public void setBillId(Integer billId) {
        this.billId = billId;
    }




}


