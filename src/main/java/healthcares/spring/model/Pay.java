// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final



/**
 * Pay generated by hbm2java
 */
public class Pay  implements java.io.Serializable {


     private Integer id;
     private Worktogether worktogether;
     private Float processingfee;
     private String signsauction;

    public Pay() {
    }

    public Pay(Worktogether worktogether, Float processingfee, String signsauction) {
       this.worktogether = worktogether;
       this.processingfee = processingfee;
       this.signsauction = signsauction;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Worktogether getWorktogether() {
        return this.worktogether;
    }
    
    public void setWorktogether(Worktogether worktogether) {
        this.worktogether = worktogether;
    }
    public Float getProcessingfee() {
        return this.processingfee;
    }
    
    public void setProcessingfee(Float processingfee) {
        this.processingfee = processingfee;
    }
    public String getSignsauction() {
        return this.signsauction;
    }
    
    public void setSignsauction(String signsauction) {
        this.signsauction = signsauction;
    }




}

