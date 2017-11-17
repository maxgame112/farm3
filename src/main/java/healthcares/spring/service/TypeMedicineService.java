package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.TypeMedicine;



public interface TypeMedicineService {
	public void add(TypeMedicine typemedicine);
	public void edit(TypeMedicine typemedicine);
	public void delete(int Id);
	public TypeMedicine getTypeMedicine(int Id);
	public List getAllTypeMedicine();
}
