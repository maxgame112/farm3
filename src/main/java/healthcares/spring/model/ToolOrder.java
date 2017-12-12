// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.Date;

/**
 * ToolOrder generated by hbm2java
 */
public class ToolOrder  implements java.io.Serializable {


     private Integer id;
     private Member member;
     private Tool tool;
     private Date day;
     private Integer quantity;
     private Integer billId;

    public ToolOrder() {
    }

    public ToolOrder(Member member, Tool tool, Date day, Integer quantity, Integer billId) {
       this.member = member;
       this.tool = tool;
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
    public Tool getTool() {
        return this.tool;
    }
    
    public void setTool(Tool tool) {
        this.tool = tool;
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

