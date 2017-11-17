package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healthcares.spring.dao.StatusAlertDao;
import healthcares.spring.model.StatusAlert;
@Service
public class StatusAlertDaoImpl implements StatusAlertDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(StatusAlert statusalert) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(statusalert);
	}

	@Override
	public void edit(StatusAlert statusalert) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(statusalert);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(getStatusAlert(Id));
	}

	@Override
	public StatusAlert getStatusAlert(int Id) {
		// TODO Auto-generated method stub
		return (StatusAlert) session.getCurrentSession().get(StatusAlert.class, Id);
	}

	@Override
	public List getAllStatusAlert() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from StatusAlert").list();
	}

}
