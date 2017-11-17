package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.TypeMedicine;
import healthcares.spring.service.TypeMedicineService;



public interface TypeMedicineDao {
	public void add(TypeMedicine typemedicine);
	public void edit(TypeMedicine typemedicine);
	public void delete(int Id);
	public TypeMedicine getTypeMedicine(int Id);
	public List getAllTypeMedicine();
}
