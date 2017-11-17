package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.UnitMedicineDao;
import healthcares.spring.model.TypeMedicine;
import healthcares.spring.model.UnitMedicine;

@Repository
public class UnitMedicineDaoImpl implements UnitMedicineDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(UnitMedicine unitmedicine) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(unitmedicine);
	}

	@Override
	public void edit(UnitMedicine unimedicine) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(unimedicine);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getUnitMedicine(id));
	}

	@Override
	public UnitMedicine getUnitMedicine(int id) {
		// TODO Auto-generated method stub
		return (UnitMedicine) session.getCurrentSession().get(TypeMedicine.class, id);
	}

	@Override
	public List getAllUnitMedicine() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from UnitMedicine").list();
	}

}
