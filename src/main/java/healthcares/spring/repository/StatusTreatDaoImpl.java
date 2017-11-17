package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.StatusTreatDao;
import healthcares.spring.model.StatusTreat;

@Repository
public class StatusTreatDaoImpl implements StatusTreatDao {

	@Autowired
	private SessionFactory sesssion;
	
	@Override
	public void add(StatusTreat statustreat) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(statustreat);
	}

	@Override
	public void edit(StatusTreat statustreat) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(statustreat);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getStatusTreat(Id));
	}

	@Override
	public StatusTreat getStatusTreat(int Id) {
		// TODO Auto-generated method stub
		return (StatusTreat)sesssion.getCurrentSession().get(StatusTreat.class, Id);
	}

	@Override
	public List getAllStatusTreat() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from StatusTreat").list();
	}

}
