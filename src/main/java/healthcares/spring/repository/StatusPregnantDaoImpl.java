package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.StatusPregnantDao;
import healthcares.spring.model.StatusPregnant;
@Repository
public class StatusPregnantDaoImpl implements StatusPregnantDao {

	@Autowired
	private SessionFactory sesssion;
	
	@Override
	public void add(StatusPregnant statuspregnant) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(statuspregnant);
	}

	@Override
	public void edit(StatusPregnant statuspregnant) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(statuspregnant);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getStatusPregnant(Id));
	}

	@Override
	public StatusPregnant getStatusPregnant(int Id) {
		// TODO Auto-generated method stub
		return (StatusPregnant) sesssion.getCurrentSession().get(StatusPregnant.class, Id);
	}

	@Override
	public List getAllStatusPregnant() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from StatusPregnant").list();
	}

}
