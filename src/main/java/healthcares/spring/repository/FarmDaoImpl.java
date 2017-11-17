package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.FarmDao;
import healthcares.spring.model.Farm;
@Repository
public class FarmDaoImpl implements FarmDao {
	@Autowired
	private SessionFactory session;
	@Override
	public void add(Farm farm) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(farm);
	}

	@Override
	public void edit(Farm farm) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(farm);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getFarm(id));
	}

	@Override
	public Farm getFarm(int id) {
		// TODO Auto-generated method stub
		return (Farm) session.getCurrentSession().get(Farm.class, id);
	}

	@Override
	public List<Farm> getAllFarm() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Farm").list();
	}

}
