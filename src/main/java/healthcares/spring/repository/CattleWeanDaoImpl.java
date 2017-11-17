package healthcares.spring.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.CattleWeanDao;
import healthcares.spring.model.CattleWean;
import healthcares.spring.model.HornDetering;
@Repository
public class CattleWeanDaoImpl implements CattleWeanDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(CattleWean cattlewean) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(cattlewean);
	}

	@Override
	public void edit(CattleWean cattlewean) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(cattlewean);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getCattleWean(Id));
	}

	@Override
	public CattleWean getCattleWean(int Id) {
		// TODO Auto-generated method stub
		return (CattleWean) session.getCurrentSession().get(CattleWean.class, Id);
	}

	@Override
	public List getAllCattleWean() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from CattleWean").list();
	}
	@Override
	public List<CattleWean> getSearch(CattleWean cattlewean , int page){
		Criteria criteria = session.getCurrentSession().createCriteria(CattleWean.class);
		if(cattlewean.getCattle()!=null){
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "catt");
			criteria.add(Restrictions.like("catt.numDate", "%"+cattlewean.getCattle().getNumDate()+"%"));
		}
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return criteria.list();
	}
	@Override
	public int CountAllCattleWean(CattleWean cattlewean){
		Criteria criteria = session.getCurrentSession().createCriteria(CattleWean.class);
		if(cattlewean.getCattle()!=null){
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "catt");
			criteria.add(Restrictions.like("catt.numDate", "%"+cattlewean.getCattle().getNumDate()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public List<CattleWean> getSearchReport(String Start,String End){
		return session.getCurrentSession().createQuery("from CattleWean where date BETWEEN '"+Start+"' and '"+End+"'").list();
	}
}
