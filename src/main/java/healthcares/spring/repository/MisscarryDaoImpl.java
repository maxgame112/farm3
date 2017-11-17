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

import healthcares.spring.dao.MisscarryDao;
import healthcares.spring.model.Misscarry;

@Repository
public class MisscarryDaoImpl implements MisscarryDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Misscarry misscarry) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(misscarry);
	}

	@Override
	public void edit(Misscarry misscarry) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(misscarry);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getMisscarry(id));
	}

	@Override
	public Misscarry getMisscarry(int id) {
		// TODO Auto-generated method stub
		return (Misscarry) session.getCurrentSession().get(Misscarry.class, id);
	}

	@Override
	public List getAllMisscarry() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Misscarry").list();
	}

	@Override
	public List CheckYearMisscarry(int id, String year) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Misscarry Where cattle.id = "+id+" and SUBSTR(day,1,4) = '"+year+"' ").list();
	}

	@Override
	public List getSearchMiscarry(Misscarry misscarry, int page) {
		// TODO Auto-generated method stub
		Criteria criteria = session.getCurrentSession().createCriteria(Misscarry.class);
		if (misscarry.getCattle() != null) {
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "cattle");
			criteria.add(Restrictions.like("cattle.num", "%"+misscarry.getCattle().getNum()+"%"));
		}
		criteria.addOrder(Order.desc("day"));
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return  criteria.list();
	}

	@Override
	public int CountAllMisscarry(Misscarry misscarry) {
		// TODO Auto-generated method stub
		Criteria criteria = session.getCurrentSession().createCriteria(Misscarry.class);
		if (misscarry.getCattle() != null) {
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "cattle");
			criteria.add(Restrictions.like("cattle.num", "%"+misscarry.getCattle().getNum()+"%"));
		}
		
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	@Override
	public List<Misscarry> getSearchReport(String Start,String End){
		return session.getCurrentSession().createQuery("from Misscarry where day BETWEEN '"+Start+"' and '"+End+"'").list();
	}

}
