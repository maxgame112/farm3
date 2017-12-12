// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final



/**
 * AlertStorehouse generated by hbm2java
 */
public class AlertStorehouse  implements java.io.Serializable {


     private Integer id;
     private Integer stockMedicine;
     private Integer stockRaw;
     private Integer stockTool;
     private Integer stockSemen;
     private Integer expMedicine;
     private Integer expRaw;
     private Integer expBucket;

    public AlertStorehouse() {
    }

    public AlertStorehouse(Integer stockMedicine, Integer stockRaw, Integer stockTool, Integer stockSemen, Integer expMedicine, Integer expRaw, Integer expBucket) {
       this.stockMedicine = stockMedicine;
       this.stockRaw = stockRaw;
       this.stockTool = stockTool;
       this.stockSemen = stockSemen;
       this.expMedicine = expMedicine;
       this.expRaw = expRaw;
       this.expBucket = expBucket;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getStockMedicine() {
        return this.stockMedicine;
    }
    
    public void setStockMedicine(Integer stockMedicine) {
        this.stockMedicine = stockMedicine;
    }
    public Integer getStockRaw() {
        return this.stockRaw;
    }
    
    public void setStockRaw(Integer stockRaw) {
        this.stockRaw = stockRaw;
    }
    public Integer getStockTool() {
        return this.stockTool;
    }
    
    public void setStockTool(Integer stockTool) {
        this.stockTool = stockTool;
    }
    public Integer getStockSemen() {
        return this.stockSemen;
    }
    
    public void setStockSemen(Integer stockSemen) {
        this.stockSemen = stockSemen;
    }
    public Integer getExpMedicine() {
        return this.expMedicine;
    }
    
    public void setExpMedicine(Integer expMedicine) {
        this.expMedicine = expMedicine;
    }
    public Integer getExpRaw() {
        return this.expRaw;
    }
    
    public void setExpRaw(Integer expRaw) {
        this.expRaw = expRaw;
    }
    public Integer getExpBucket() {
        return this.expBucket;
    }
    
    public void setExpBucket(Integer expBucket) {
        this.expBucket = expBucket;
    }




}

