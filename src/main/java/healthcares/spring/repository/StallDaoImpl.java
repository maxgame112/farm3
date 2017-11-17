package healthcares.spring.repository;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.StallDao;
import healthcares.spring.model.Stall;
@Repository
public class StallDaoImpl implements StallDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Stall stall) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(stall);
	}

	@Override
	public void edit(Stall stall) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(stall);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getStall(id));
	}

	@Override
	public Stall getStall(int id) {
		// TODO Auto-generated method stub
		return (Stall)session.getCurrentSession().get(Stall.class,id);
	}

	@Override
	public List getAllStall() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Stall").list();
	}

}
