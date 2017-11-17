package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.SexDao;
import healthcares.spring.model.Sex;
@Repository
public class SexDaoImpl implements SexDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Sex sex) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(sex);
	}

	@Override
	public void edit(Sex sex) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(sex);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getSex(id));
	}

	@Override
	public Sex getSex(int id) {
		// TODO Auto-generated method stub
		return (Sex)session.getCurrentSession().get(Sex.class,id);
	}

	@Override
	public List getAllSex() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Sex").list();
	}

}
