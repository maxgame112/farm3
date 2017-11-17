package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.StatusBornDao;
import healthcares.spring.model.StatusBorn;
@Repository
public class StatusBornDaoImpl implements StatusBornDao {

	@Autowired
	private SessionFactory sesssion;
	
	@Override
	public void add(StatusBorn statusborn) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(statusborn);
	}

	@Override
	public void edit(StatusBorn statusborn) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(statusborn);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getStatusBorn(id));
	}

	@Override
	public StatusBorn getStatusBorn(int id) {
		// TODO Auto-generated method stub
		return (StatusBorn) sesssion.getCurrentSession().get(StatusBorn.class, id);
	}

	@Override
	public List getAllStatusBorn() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from StatusBorn").list();
	}

}
