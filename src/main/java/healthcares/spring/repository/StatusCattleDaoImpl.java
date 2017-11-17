package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.StatusCattleDao;
import healthcares.spring.model.StatusCattle;
@Repository
public class StatusCattleDaoImpl implements StatusCattleDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(StatusCattle statuscattle) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(statuscattle);
	}

	@Override
	public void edit(StatusCattle statuscattle) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(statuscattle);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getStatusCattle(Id));
	}

	@Override
	public StatusCattle getStatusCattle(int Id) {
		// TODO Auto-generated method stub
		return (StatusCattle)session.getCurrentSession().get(StatusCattle.class, Id);
	}

	@Override
	public List getAllStatusCattle() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from StatusCattle").list();
	}

}
