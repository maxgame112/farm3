package healthcares.spring.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.CattleYearDao;
import healthcares.spring.model.CattleWean;
import healthcares.spring.model.CattleYear;
@Repository
public class CattleYearDaoImpl implements CattleYearDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(CattleYear cattleyear) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(cattleyear);
	}

	@Override
	public void edit(CattleYear cattleyear) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(cattleyear);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getCattleYear(Id));
	}

	@Override
	public CattleYear getCattleYear(int Id) {
		// TODO Auto-generated method stub
		return (CattleYear)session.getCurrentSession().get(CattleYear.class, Id);
	}

	@Override
	public List getAllCattleYear() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from CattleYear").list();
	}
	
	@Override
	public List<CattleYear> getSearch(CattleYear cattleyear , int page){
		Criteria criteria = session.getCurrentSession().createCriteria(CattleYear.class);
		if(cattleyear!=null){
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "cattle");
			criteria.add(Restrictions.like("cattle.num","%"+cattleyear.getCattle().getNum()+"%"));
		}
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return criteria.list();
	}
	@Override
	public int CountAllCattleYear(CattleYear cattleyear){
		Criteria criteria = session.getCurrentSession().createCriteria(CattleYear.class);
		if(cattleyear!=null){
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "cattle");
			criteria.add(Restrictions.like("cattle.num", "%"+cattleyear.getCattle().getNum()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	@Override
	public List<CattleYear> getSearchReport(String Start,String End){
		return session.getCurrentSession().createQuery("from CattleYear where date BETWEEN '"+Start+"' and '"+End+"'").list();
	}
}
