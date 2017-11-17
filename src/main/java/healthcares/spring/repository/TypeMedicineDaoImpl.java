package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.TypeMedicineDao;
import healthcares.spring.model.TypeMedicine;

@Repository
public class TypeMedicineDaoImpl implements TypeMedicineDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(TypeMedicine typemedicine) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(typemedicine);
	}

	@Override
	public void edit(TypeMedicine typemedicine) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(typemedicine);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getTypeMedicine(Id));
	}

	@Override
	public TypeMedicine getTypeMedicine(int Id) {
		// TODO Auto-generated method stub
		return (TypeMedicine) session.getCurrentSession().get(TypeMedicine.class, Id);
	}

	@Override
	public List getAllTypeMedicine() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from TypeMedicine").list();
	}

}
