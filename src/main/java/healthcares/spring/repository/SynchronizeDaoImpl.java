package healthcares.spring.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.SynchronizeDao;
import healthcares.spring.model.Synchronize;
@Repository
public class SynchronizeDaoImpl implements SynchronizeDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Synchronize synchrnize) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(synchrnize);
	}

	@Override
	public void edit(Synchronize synchrnize) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(synchrnize);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getSynchronize(Id));
	}

	@Override
	public Synchronize getSynchronize(int Id) {
		// TODO Auto-generated method stub
		return (Synchronize) session.getCurrentSession().get(Synchronize.class, Id);
	}

	@Override
	public List getAllSynchronize() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Synchronize").list();
	}

	@Override
	public List<Synchronize> getSearch(Synchronize synchronize,int page){
		Criteria criteria = session.getCurrentSession().createCriteria(Synchronize.class);
		if (synchronize.getCattle() != null) {
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "catt");
			criteria.add(Restrictions.like("catt.num", "%"+synchronize.getCattle().getNum()+"%"));
		}
		if (synchronize.getTypeSync() != null) {
			criteria.setFetchMode("typeSync", FetchMode.JOIN);
			criteria.createAlias("typeSync", "type");
			criteria.add(Restrictions.like("type.value", "%"+synchronize.getTypeSync().getValue()+"%"));
		}
		criteria.addOrder(Order.desc("dateSync"));
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return criteria.list();
	}
	
	@Override
	public int countAllSynchronize(Synchronize synchronize){
		Criteria criteria = session.getCurrentSession().createCriteria(Synchronize.class);
		if (synchronize.getCattle() != null) {
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "catt");
			criteria.add(Restrictions.like("catt.num", "%"+synchronize.getCattle().getNum()+"%"));
		}
		if (synchronize.getTypeSync() != null) {
			criteria.setFetchMode("typeSync", FetchMode.JOIN);
			criteria.createAlias("typeSync", "type");
			criteria.add(Restrictions.like("type.value", "%"+synchronize.getTypeSync().getValue()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	@Override
	public List<Synchronize> getSearchReport(String Start,String End){
		return session.getCurrentSession().createQuery("from Synchronize where dateSync BETWEEN '"+Start+"' and '"+End+"'").list();
	}
}
