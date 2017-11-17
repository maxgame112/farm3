package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.UnitMedicineDao;
import healthcares.spring.model.UnitMedicine;
import healthcares.spring.service.UnitMedicineService;

@Service
public class UnitMedicineServiceImpl implements UnitMedicineService {

	@Autowired
	private UnitMedicineDao unitmedicinedao;
	
	@Transactional
	public void add(UnitMedicine unitmedicine) {
		// TODO Auto-generated method stub
		unitmedicinedao.add(unitmedicine);
	}

	@Transactional
	public void edit(UnitMedicine unimedicine) {
		// TODO Auto-generated method stub
		unitmedicinedao.edit(unimedicine);
	}

	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		unitmedicinedao.delete(id);
	}

	@Transactional
	public UnitMedicine getUnitMedicine(int id) {
		// TODO Auto-generated method stub
		return unitmedicinedao.getUnitMedicine(id);
	}

	@Transactional
	public List getAllUnitMedicine() {
		// TODO Auto-generated method stub
		return unitmedicinedao.getAllUnitMedicine();
	}

}
