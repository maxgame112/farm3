package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.GroupMedicine;



public interface GroupMedicineService {
	public void add(GroupMedicine groupMedicine);
	public void edit(GroupMedicine groupMedicine);
	public void delete(int Id);
	public GroupMedicine getGroupMedicine(int Id);
	public List getAllGroupMedicine();
	public List getGroupMed(String name);
}
