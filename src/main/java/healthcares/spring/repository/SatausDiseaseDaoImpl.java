package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.StatusDiseaseDao;
import healthcares.spring.model.StatusDisease;
@Repository
public class SatausDiseaseDaoImpl implements StatusDiseaseDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(StatusDisease statusdisease) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(statusdisease);
	}

	@Override
	public void edit(StatusDisease statusdisease) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(statusdisease);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getStatusDisease(Id));
	}

	@Override
	public StatusDisease getStatusDisease(int Id) {
		// TODO Auto-generated method stub
		return (StatusDisease) session.getCurrentSession().get(StatusDisease.class, Id);
	}

	@Override
	public List getAllStatusDisease() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from StatusDisease").list();
	}

}
