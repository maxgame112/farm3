// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.Date;

/**
 * MedicineImport generated by hbm2java
 */
public class MedicineImport  implements java.io.Serializable {


     private Integer id;
     private Medicine medicine;
     private Member member;
     private Integer lot;
     private Integer quantity;
     private Long price;
     private String import_;
     private String place;
     private Date dayMfd;
     private Date dayExp;
     private Integer billId;
     private int beforeQuantity;
     private Date day;
     private int status;

    public MedicineImport() {
    }

	
    public MedicineImport(Medicine medicine, Member member, int beforeQuantity, Date day, int status) {
        this.medicine = medicine;
        this.member = member;
        this.beforeQuantity = beforeQuantity;
        this.day = day;
        this.status = status;
    }
    public MedicineImport(Medicine medicine, Member member, Integer lot, Integer quantity, Long price, String import_, String place, Date dayMfd, Date dayExp, Integer billId, int beforeQuantity, Date day, int status) {
       this.medicine = medicine;
       this.member = member;
       this.lot = lot;
       this.quantity = quantity;
       this.price = price;
       this.import_ = import_;
       this.place = place;
       this.dayMfd = dayMfd;
       this.dayExp = dayExp;
       this.billId = billId;
       this.beforeQuantity = beforeQuantity;
       this.day = day;
       this.status = status;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Medicine getMedicine() {
        return this.medicine;
    }
    
    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
    public Integer getLot() {
        return this.lot;
    }
    
    public void setLot(Integer lot) {
        this.lot = lot;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Long getPrice() {
        return this.price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
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
    public Date getDayMfd() {
        return this.dayMfd;
    }
    
    public void setDayMfd(Date dayMfd) {
        this.dayMfd = dayMfd;
    }
    public Date getDayExp() {
        return this.dayExp;
    }
    
    public void setDayExp(Date dayExp) {
        this.dayExp = dayExp;
    }
    public Integer getBillId() {
        return this.billId;
    }
    
    public void setBillId(Integer billId) {
        this.billId = billId;
    }
    public int getBeforeQuantity() {
        return this.beforeQuantity;
    }
    
    public void setBeforeQuantity(int beforeQuantity) {
        this.beforeQuantity = beforeQuantity;
    }
    public Date getDay() {
        return this.day;
    }
    
    public void setDay(Date day) {
        this.day = day;
    }
    public int getStatus() {
        return this.status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }




}


