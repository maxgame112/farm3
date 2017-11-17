package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.StatusBreedDao;
import healthcares.spring.model.StatusBreed;
@Repository
public class StatusBreedDaoImpl implements StatusBreedDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(StatusBreed statusbreed) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(statusbreed);
	}

	@Override
	public void edit(StatusBreed statusbreed) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(statusbreed);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getStatusBreed(id));
	}

	@Override
	public StatusBreed getStatusBreed(int id) {
		// TODO Auto-generated method stub
		return (StatusBreed)session.getCurrentSession().get(StatusBreed.class, id);
	}

	@Override
	public List getAllStatusBreed() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from StatusBreed").list();
	}
	
	@Override
	public List getStatBreed(String name){
		return session.getCurrentSession().createQuery("from StatusBreed where value = '"+name+"'").list();
	}

}
