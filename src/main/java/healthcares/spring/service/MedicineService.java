package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.Medicine;



public interface MedicineService {
	public void add(Medicine Medicine);
	public void edit(Medicine medicine);
	public void delete(int Id);
	public Medicine getMedicine(int Id);
	public Medicine getMedicine2(int[] Id);
	public List getAllMedicine();
	public List<Medicine> getNameMedBygroup(int Id);
	public List<Medicine> getSearch(Medicine medicine,int page);
	int CountAllMedicine (Medicine medicine);
/*	public List getSeachAllMedicine2(Medicine medicine);
	public List getSeachAllMedicine3(Medicine medicine);
	public List getSeachAllMedicine5(Medicine medicine);*/
}
