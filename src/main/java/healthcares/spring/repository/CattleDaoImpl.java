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

import healthcares.spring.dao.CattleDao;
import healthcares.spring.model.Cattle;
@Repository
public class CattleDaoImpl implements CattleDao {
	
	@Autowired
	private SessionFactory sesssion;
	
	@Override
	public void add(Cattle cattle) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(cattle);
	}

	@Override
	public void edit(Cattle cattle) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(cattle);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getCattle(Id));
	}

	@Override
	public Cattle getCattle(int Id) {
		// TODO Auto-generated method stub
		return (Cattle)sesssion.getCurrentSession().get(Cattle.class, Id);
	}

	@Override
	public List getAllCattle() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from Cattle").list();
	}
	@Override
	public List getCattleNum(String num) {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from Cattle where num LIKE '%"+num+"%'").list();
	}
	
	@Override
	public List GetMomCattle(int s){
		return sesssion.getCurrentSession().createQuery("from Cattle where  sex = 2 and statusCattle = 2  and teeth = "+s+" and groupCattle = 1 ").list(); //or  groupCattle = 2 
	}
	
	@Override
	public List GetMomCattle2(int s){
		return sesssion.getCurrentSession().createQuery("from Cattle where  sex = 2 and statusCattle = 2  and teeth = "+s+" and groupCattle = 2").list();
	}
	
	@Override
	public List GetMomCattle3(int s){
		return sesssion.getCurrentSession().createQuery("from Cattle where  sex = 2 and statusCattle = 2  and teeth = "+s+" and groupCattle = 10").list();
	}
	
	@Override
	public List GetFatCattle(){
		return sesssion.getCurrentSession().createQuery("from Cattle where  sex = 1 and groupCattle = 1 and statusCattle = 2").list();
	}
	
	@Override
	public List GetCalves(int c){
		return sesssion.getCurrentSession().createQuery("from Cattle Where ageWean =  "+c+" ").list();
	}
	
	@Override
	public List GetCalves1(int c){
		return sesssion.getCurrentSession().createQuery("from Cattle Where statusCattle = 1 and age = "+c+" ").list();
	}
	
	@Override
	public List getstaTreatcattle(){
		return sesssion.getCurrentSession().createQuery("from Cattle Where statusTreat = 2").list();
	}
	
	@Override
	public List<Cattle> getSearch(Cattle cattle,int page){
		Criteria criteria = sesssion.getCurrentSession().createCriteria(Cattle.class);
		if (cattle.getNum() != null) {
			criteria.add(Restrictions.like("num", "%"+cattle.getNum()+"%"));
		}
		if (cattle.getStatusBreed()	!= null	) {
			criteria.setFetchMode("statusBreed", FetchMode.JOIN);
			criteria.createAlias("statusBreed", "statusBreed");
			criteria.add(Restrictions.like("statusBreed.value", "%"+cattle.getStatusBreed().getValue()+"%"));
		}
		if (cattle.getNumDate() != null) {
			criteria.add(Restrictions.like("numDate", "%"+cattle.getNumDate()+"%"));
		}
		if (cattle.getMaId() != null) {
			criteria.add(Restrictions.like("maId", "%"+cattle.getMaId()+"%"));
		}
		criteria.addOrder(Order.desc("calved"));
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return criteria.list();
	}
	
	@Override
	public int countAllCattle(Cattle cattle){
		Criteria criteria = sesssion.getCurrentSession().createCriteria(Cattle.class);
		if (cattle.getNum() != null) {
			criteria.add(Restrictions.like("num", "%"+cattle.getNum()+"%"));
		}
		if (cattle.getStatusBreed()	!= null	) {
			criteria.setFetchMode("statusBreed", FetchMode.JOIN);
			criteria.createAlias("statusBreed", "statusBreed");
			criteria.add(Restrictions.like("statusBreed.value", "%"+cattle.getStatusBreed().getValue()+"%"));
		}
		if (cattle.getNumDate() != null) {
			criteria.add(Restrictions.like("numDate", "%"+cattle.getNumDate()+"%"));
		}
		if (cattle.getMaId() != null) {
			criteria.add(Restrictions.like("maId", "%"+cattle.getMaId()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public Cattle getCattleId(String num){
		return (Cattle) sesssion.getCurrentSession().createQuery("from Cattle where num = '"+num+"'").uniqueResult();
	}
	
	@Override
	public List<Cattle> getSearchReport(String Start,String End){
		return sesssion.getCurrentSession().createQuery("from Cattle where ageWean = 0 and calved BETWEEN '"+Start+"' and '"+End+"'").list();
	}
	
	@Override
	public List getCattleT(){
		return sesssion.getCurrentSession().createQuery("from Cattle where statusTreat = 1").list();
	}
}
