package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.GroupMedicineDao;
import healthcares.spring.model.GroupMedicine;
import healthcares.spring.service.GroupMedicineService;
@Service
public class GroupMedicineServiceImpl implements GroupMedicineService {

	@Autowired
	private GroupMedicineDao groupmedicinedao;
	
	@Transactional
	public void add(GroupMedicine groupMedicine) {
		// TODO Auto-generated method stub
		groupmedicinedao.add(groupMedicine);
	}

	@Transactional
	public void edit(GroupMedicine groupMedicine) {
		// TODO Auto-generated method stub
		groupmedicinedao.edit(groupMedicine);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		groupmedicinedao.delete(Id);
	}

	@Transactional
	public GroupMedicine getGroupMedicine(int Id) {
		// TODO Auto-generated method stub
		return groupmedicinedao.getGroupMedicine(Id);
	}

	@Transactional
	public List getAllGroupMedicine() {
		// TODO Auto-generated method stub
		return groupmedicinedao.getAllGroupMedicine();
	}
	
	@Transactional
	public List getGroupMed(String name){
		return groupmedicinedao.getGroupMed(name);		
	}

}
