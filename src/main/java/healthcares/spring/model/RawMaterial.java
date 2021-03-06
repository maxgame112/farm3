// default package
// Generated Dec 11, 2017 7:32:01 PM by Hibernate Tools 5.2.6.Final


import java.util.HashSet;
import java.util.Set;

/**
 * RawMaterial generated by hbm2java
 */
public class RawMaterial  implements java.io.Serializable {


     private Integer id;
     private TypeMaterial typeMaterial;
     private UnitRawMaterial unitRawMaterial;
     private String name;
     private Integer quantity;
     private String place;
     private Integer statusalert;
     private Set rawMaterialOrders = new HashSet(0);
     private Set rawMaterialNutrients = new HashSet(0);
     private Set rawMaterialReleases = new HashSet(0);
     private Set rawMaterialImports = new HashSet(0);
     private Set rawMaterialPrices = new HashSet(0);

    public RawMaterial() {
    }

    public RawMaterial(TypeMaterial typeMaterial, UnitRawMaterial unitRawMaterial, String name, Integer quantity, String place, Integer statusalert, Set rawMaterialOrders, Set rawMaterialNutrients, Set rawMaterialReleases, Set rawMaterialImports, Set rawMaterialPrices) {
       this.typeMaterial = typeMaterial;
       this.unitRawMaterial = unitRawMaterial;
       this.name = name;
       this.quantity = quantity;
       this.place = place;
       this.statusalert = statusalert;
       this.rawMaterialOrders = rawMaterialOrders;
       this.rawMaterialNutrients = rawMaterialNutrients;
       this.rawMaterialReleases = rawMaterialReleases;
       this.rawMaterialImports = rawMaterialImports;
       this.rawMaterialPrices = rawMaterialPrices;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public TypeMaterial getTypeMaterial() {
        return this.typeMaterial;
    }
    
    public void setTypeMaterial(TypeMaterial typeMaterial) {
        this.typeMaterial = typeMaterial;
    }
    public UnitRawMaterial getUnitRawMaterial() {
        return this.unitRawMaterial;
    }
    
    public void setUnitRawMaterial(UnitRawMaterial unitRawMaterial) {
        this.unitRawMaterial = unitRawMaterial;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getPlace() {
        return this.place;
    }
    
    public void setPlace(String place) {
        this.place = place;
    }
    public Integer getStatusalert() {
        return this.statusalert;
    }
    
    public void setStatusalert(Integer statusalert) {
        this.statusalert = statusalert;
    }
    public Set getRawMaterialOrders() {
        return this.rawMaterialOrders;
    }
    
    public void setRawMaterialOrders(Set rawMaterialOrders) {
        this.rawMaterialOrders = rawMaterialOrders;
    }
    public Set getRawMaterialNutrients() {
        return this.rawMaterialNutrients;
    }
    
    public void setRawMaterialNutrients(Set rawMaterialNutrients) {
        this.rawMaterialNutrients = rawMaterialNutrients;
    }
    public Set getRawMaterialReleases() {
        return this.rawMaterialReleases;
    }
    
    public void setRawMaterialReleases(Set rawMaterialReleases) {
        this.rawMaterialReleases = rawMaterialReleases;
    }
    public Set getRawMaterialImports() {
        return this.rawMaterialImports;
    }
    
    public void setRawMaterialImports(Set rawMaterialImports) {
        this.rawMaterialImports = rawMaterialImports;
    }
    public Set getRawMaterialPrices() {
        return this.rawMaterialPrices;
    }
    
    public void setRawMaterialPrices(Set rawMaterialPrices) {
        this.rawMaterialPrices = rawMaterialPrices;
    }




}


