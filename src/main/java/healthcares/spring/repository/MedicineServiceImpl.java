package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.MedicineDao;
import healthcares.spring.model.Medicine;
import healthcares.spring.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	private MedicineDao medicinedao;
	
	@Transactional
	public void add(Medicine Medicine) {
		// TODO Auto-generated method stub
		medicinedao.add(Medicine);
	}

	@Transactional
	public void edit(Medicine medicine) {
		// TODO Auto-generated method stub
		medicinedao.edit(medicine);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		medicinedao.delete(Id);
	}

	@Transactional
	public Medicine getMedicine(int Id) {
		// TODO Auto-generated method stub
		return medicinedao.getMedicine(Id);
	}
	
	@Transactional
	public Medicine getMedicine2(int[] Id) {
		// TODO Auto-generated method stub
		return medicinedao.getMedicine2(Id);
	}

	@Transactional
	public List getAllMedicine() {
		// TODO Auto-generated method stub
		return medicinedao.getAllMedicine();
	}

	@Transactional
	public List<Medicine> getNameMedBygroup(int Id) {
		// TODO Auto-generated method stub
		return medicinedao.getNameMedBygroup(Id);
	}

	@Transactional
	public List<Medicine> getSearch(Medicine medicine, int page) {
		// TODO Auto-generated method stub
		return medicinedao.getSearch(medicine, page);
	}

	@Transactional
	public int CountAllMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return medicinedao.CountAllMedicine(medicine);
	}

}
