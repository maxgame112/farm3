// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final



/**
 * Report generated by hbm2java
 */
public class Report  implements java.io.Serializable {


     private Integer id;
     private Worktogether worktogether;
     private String namefestivity;
     private String numpeople;
     private String numcattle;
     private String finalprice;
     private Integer festivityNo;

    public Report() {
    }

    public Report(Worktogether worktogether, String namefestivity, String numpeople, String numcattle, String finalprice, Integer festivityNo) {
       this.worktogether = worktogether;
       this.namefestivity = namefestivity;
       this.numpeople = numpeople;
       this.numcattle = numcattle;
       this.finalprice = finalprice;
       this.festivityNo = festivityNo;
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
    public String getNamefestivity() {
        return this.namefestivity;
    }
    
    public void setNamefestivity(String namefestivity) {
        this.namefestivity = namefestivity;
    }
    public String getNumpeople() {
        return this.numpeople;
    }
    
    public void setNumpeople(String numpeople) {
        this.numpeople = numpeople;
    }
    public String getNumcattle() {
        return this.numcattle;
    }
    
    public void setNumcattle(String numcattle) {
        this.numcattle = numcattle;
    }
    public String getFinalprice() {
        return this.finalprice;
    }
    
    public void setFinalprice(String finalprice) {
        this.finalprice = finalprice;
    }
    public Integer getFestivityNo() {
        return this.festivityNo;
    }
    
    public void setFestivityNo(Integer festivityNo) {
        this.festivityNo = festivityNo;
    }




}

