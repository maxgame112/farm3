package healthcares.spring.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.SyncDao;
import healthcares.spring.model.Sync;
@Repository
public class SyncDaoImpl implements SyncDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Sync sync) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(sync);
	}

	@Override
	public void edit(Sync sync) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(sync);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getSync(Id));
	}

	@Override
	public Sync getSync(int Id) {
		// TODO Auto-generated method stub
		return (Sync) session.getCurrentSession().get(Sync.class, Id);
	}

	@Override
	public List getAllSync() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Sync ").list();
	}
	

	@Override
	public List getSyncByq(String q) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Sync where typeSync = '"+q+"'").list();
	}
	
	@Override
	public List getAllSyncByType(int id){
		return session.getCurrentSession().createQuery("from Sync where typeSync = "+id).list();
	}
	
	@Override
	public List LastSync(int id){
		Criteria criteria = session.getCurrentSession().createCriteria(Sync.class);
		criteria.add(Restrictions.eq("typeSync.id", id));
		criteria.addOrder(Order.desc("dayalert"));
		criteria.addOrder(Order.desc("timealert"));
		criteria.setMaxResults(1);
		return criteria.list();
	}
}
