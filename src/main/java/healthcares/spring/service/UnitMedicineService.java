package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.UnitMedicine;



public interface UnitMedicineService {
	public void add(UnitMedicine unitmedicine);
	public void edit(UnitMedicine unimedicine);
	public void delete(int id);
	public UnitMedicine getUnitMedicine(int id);
	public List getAllUnitMedicine();
}
