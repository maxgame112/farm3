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

import healthcares.spring.dao.TreatmentHistoryDao;
import healthcares.spring.model.TreatmentHistory;

@Repository
public class TreatmentHistoryDaoImpl implements TreatmentHistoryDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(TreatmentHistory treamenthistory) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(treamenthistory);
	}

	@Override
	public void edit(TreatmentHistory treamenthistory) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(treamenthistory);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getTreatmentHistory(id));
	}

	@Override
	public TreatmentHistory getTreatmentHistory(int id) {
		// TODO Auto-generated method stub
		return (TreatmentHistory) session.getCurrentSession().get(TreatmentHistory.class, id);
	}

	@Override
	public List getAllTreatmentHistory() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from TreatmentHistory").list();
	}
	
/*	@Override
	public List getstaTreatcattle(){
		return session.getCurrentSession().createQuery("from TreatmentHistory Where statusTreat = 2").list();
	}*/
	
	@Override
	public List<TreatmentHistory> getSearch(TreatmentHistory treatmentHistory,int page){
		Criteria criteria = session.getCurrentSession().createCriteria(TreatmentHistory.class);
		if (treatmentHistory.getCattle() != null) {
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "catt");
			criteria.add(Restrictions.like("catt.num", "%"+treatmentHistory.getCattle().getNum()+"%"));
		}
		if (treatmentHistory.getMedicine() != null) {
			criteria.setFetchMode("medicine",FetchMode.JOIN);
			criteria.createAlias("medicine", "med");
			criteria.add(Restrictions.like("med.tradeName","%"+treatmentHistory.getMedicine().getTradeName()+"%"));
		}
		if (treatmentHistory.getDisease() != null) {
			criteria.setFetchMode("disease", FetchMode.JOIN);
			criteria.createAlias("disease", "dis");
			criteria.add(Restrictions.like("dis.nameDisease", "%"+treatmentHistory.getDisease().getNameDisease()+"%"));
		}
		criteria.addOrder(Order.desc("dateTreat"));
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return criteria.list();
	}
	
	@Override
	public int countAllTreatmentHistory(TreatmentHistory treatmentHistory){
		Criteria criteria = session.getCurrentSession().createCriteria(TreatmentHistory.class);
		if (treatmentHistory.getCattle() != null) {
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "catt");
			criteria.add(Restrictions.like("catt.num", "%"+treatmentHistory.getCattle().getNum()+"%"));
		}
		if (treatmentHistory.getMedicine() != null) {
			criteria.setFetchMode("medicine",FetchMode.JOIN);
			criteria.createAlias("medicine", "med");
			criteria.add(Restrictions.like("med.tradeName","%"+treatmentHistory.getMedicine().getTradeName()+"%"));
		}
		if (treatmentHistory.getDisease() != null) {
			criteria.setFetchMode("disease", FetchMode.JOIN);
			criteria.createAlias("disease", "dis");
			criteria.add(Restrictions.like("dis.nameDisease", "%"+treatmentHistory.getDisease().getNameDisease()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	@Override
	public List<TreatmentHistory> getSearchReport(String Start,String End){
/*		if (memid == 0) {
			return session.getCurrentSession().createQuery("from TreatmentHistory where day BETWEEN '"+Start+"' and '"+End+"'").list();
		}*/
		return session.getCurrentSession().createQuery("from TreatmentHistory where dateTreat BETWEEN '"+Start+"' and '"+End+"'").list();
	}

}
