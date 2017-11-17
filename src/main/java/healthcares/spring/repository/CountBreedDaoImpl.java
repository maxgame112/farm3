package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.CountBreedDao;
import healthcares.spring.model.CountBreed;
@Repository
public class CountBreedDaoImpl implements CountBreedDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(CountBreed countbreed) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(countbreed);
	}

	@Override
	public void edit(CountBreed countbreed) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(countbreed);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getCountBreed(Id));
	}

	@Override
	public CountBreed getCountBreed(int Id) {
		// TODO Auto-generated method stub
		return (CountBreed)session.getCurrentSession().get(CountBreed.class, Id);
	}

	@Override
	public List getAllCountBreed() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from CountBreed").list();
	}
	
	
	@Override
	public CountBreed getCountBreedByPriNo(int id) {
		
		return (CountBreed) session.getCurrentSession().createQuery("from CountBreed c where c.cattle.id = "+id).uniqueResult();
	}
	
	@Override
	public List getAllCountBreedById(int id) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from CountBreed where cattle ="+id).list();
	}

}
