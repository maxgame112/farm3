package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.StatusMedicine;


public interface StatusMedicineDao {
	public void add(StatusMedicine statusmedicine);
	public void edit(StatusMedicine statusmedicine);
	public void delete(int Id);
	public StatusMedicine getStatusMedicine(int Id);
	public List getAllStatusMedicine();
}
