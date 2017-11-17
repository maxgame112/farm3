package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.StatusMedicineDao;
import healthcares.spring.model.StatusMedicine;

@Repository
public class StatusMedicineDaoImpl implements StatusMedicineDao {

	@Autowired
	private SessionFactory sesssion;
	
	@Override
	public void add(StatusMedicine statusmedicine) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(statusmedicine);
	}

	@Override
	public void edit(StatusMedicine statusmedicine) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(statusmedicine);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getStatusMedicine(Id));
	}

	@Override
	public StatusMedicine getStatusMedicine(int Id) {
		// TODO Auto-generated method stub
		return (StatusMedicine) sesssion.getCurrentSession().get(StatusMedicine.class, Id);
	}

	@Override
	public List getAllStatusMedicine() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from StatusMedicine").list();
	}

}
