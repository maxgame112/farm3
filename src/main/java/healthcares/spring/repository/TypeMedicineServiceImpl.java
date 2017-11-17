package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.TypeMedicineDao;
import healthcares.spring.model.TypeMedicine;
import healthcares.spring.service.TypeMedicineService;
@Service
public class TypeMedicineServiceImpl implements TypeMedicineService {

	@Autowired
	private TypeMedicineDao typemedicinedao;
	
	@Transactional
	public void add(TypeMedicine typemedicine) {
		// TODO Auto-generated method stub
		typemedicinedao.add(typemedicine);
	}

	@Transactional
	public void edit(TypeMedicine typemedicine) {
		// TODO Auto-generated method stub
		typemedicinedao.edit(typemedicine);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		typemedicinedao.delete(Id);
	}

	@Transactional
	public TypeMedicine getTypeMedicine(int Id) {
		// TODO Auto-generated method stub
		return typemedicinedao.getTypeMedicine(Id);
	}

	@Transactional
	public List getAllTypeMedicine() {
		// TODO Auto-generated method stub
		return typemedicinedao.getAllTypeMedicine();
	}

}
