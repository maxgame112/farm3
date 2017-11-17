package healthcares.spring.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healthcares.spring.dao.CattleStampDao;
import healthcares.spring.model.CattleStamp;
import healthcares.spring.model.CattleWean;
@Service
public class CattleStampDaoImpl implements CattleStampDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(CattleStamp cattlestamp) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(cattlestamp);
	}

	@Override
	public void edit(CattleStamp cattlestamp) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(cattlestamp);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getCattleStamp(Id));
	}

	@Override
	public CattleStamp getCattleStamp(int Id) {
		// TODO Auto-generated method stub
		return (CattleStamp) session.getCurrentSession().get(CattleStamp.class, Id);
	}

	@Override
	public List getAllCattleStamp() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from CattleStamp").list();
	}
	@Override
	public List<CattleStamp> getSearch(CattleStamp cattlestamp , int page){
		Criteria criteria = session.getCurrentSession().createCriteria(CattleStamp.class);
		if(cattlestamp.getCattle()!=null){
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "catt");
			criteria.add(Restrictions.like("catt.num", "%"+cattlestamp.getCattle().getNum()+"%"));
		}
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return criteria.list();
	}
	@Override
	public int CountAllCattleStamp(CattleStamp cattlestamp){
		Criteria criteria = session.getCurrentSession().createCriteria(CattleStamp.class);
		if(cattlestamp.getCattle()!=null){
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "catt");
			criteria.add(Restrictions.like("catt.num", "%"+cattlestamp.getCattle().getNum()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public List<CattleStamp> getSearchReport(String Start,String End){
		return session.getCurrentSession().createQuery("from CattleStamp where date BETWEEN '"+Start+"' and '"+End+"'").list();
	}
}
