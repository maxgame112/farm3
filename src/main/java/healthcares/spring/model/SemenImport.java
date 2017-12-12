// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.Date;

/**
 * SemenImport generated by hbm2java
 */
public class SemenImport  implements java.io.Serializable {


     private Integer id;
     private Member member;
     private Semen semen;
     private Integer quantity;
     private Integer price;
     private String farm;
     private String import_;
     private String place;
     private String note;
     private Integer billId;
     private Date day;
     private Integer beforeQuantity;

    public SemenImport() {
    }

    public SemenImport(Member member, Semen semen, Integer quantity, Integer price, String farm, String import_, String place, String note, Integer billId, Date day, Integer beforeQuantity) {
       this.member = member;
       this.semen = semen;
       this.quantity = quantity;
       this.price = price;
       this.farm = farm;
       this.import_ = import_;
       this.place = place;
       this.note = note;
       this.billId = billId;
       this.day = day;
       this.beforeQuantity = beforeQuantity;
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
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getPrice() {
        return this.price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getFarm() {
        return this.farm;
    }
    
    public void setFarm(String farm) {
        this.farm = farm;
    }
    public String getImport_() {
        return this.import_;
    }
    
    public void setImport_(String import_) {
        this.import_ = import_;
    }
    public String getPlace() {
        return this.place;
    }
    
    public void setPlace(String place) {
        this.place = place;
    }
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    public Integer getBillId() {
        return this.billId;
    }
    
    public void setBillId(Integer billId) {
        this.billId = billId;
    }
    public Date getDay() {
        return this.day;
    }
    
    public void setDay(Date day) {
        this.day = day;
    }
    public Integer getBeforeQuantity() {
        return this.beforeQuantity;
    }
    
    public void setBeforeQuantity(Integer beforeQuantity) {
        this.beforeQuantity = beforeQuantity;
    }




}

