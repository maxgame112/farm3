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
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.BreedingDao;
import healthcares.spring.model.Breeding;
import healthcares.spring.model.TreatmentHistory;
@Repository
public class BreedingDaoImpl implements BreedingDao {

	@Autowired
	private SessionFactory sesssion;
	
	@Override
	public void add(Breeding breeding) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(breeding);
	}

	@Override
	public void edit(Breeding breeding) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(breeding);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getBreeding(Id));
	}

	@Override
	public Breeding getBreeding(int Id) {
		// TODO Auto-generated method stub 
		return (Breeding)sesssion.getCurrentSession().get(Breeding.class, Id);
	}
	
	
	@Override
	public List getAllBreeding() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from Breeding").list();
	}
	
	@Override
	public List<Breeding> getSearch(Breeding breeding,int page){
		Criteria criteria = sesssion.getCurrentSession().createCriteria(Breeding.class);
		if (breeding.getCattleByCattlemaId() != null) {
			criteria.setFetchMode("cattleByCattlemaId", FetchMode.JOIN);
			criteria.createAlias("cattleByCattlemaId", "cattleByCattlemaId");
			criteria.add(Restrictions.like("cattleByCattlemaId.num", "%"+breeding.getCattleByCattlemaId().getNum()+"%"));
		}
		criteria.addOrder(Order.desc("date"));
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return criteria.list();
	}

	@Override
	public int countAllBreeding(Breeding breeding){
		Criteria criteria = sesssion.getCurrentSession().createCriteria(Breeding.class);
		if (breeding.getCattleByCattlemaId() != null) {
			criteria.setFetchMode("cattleByCattlemaId", FetchMode.JOIN);
			criteria.createAlias("cattleByCattlemaId", "cattleByCattlemaId");
			criteria.add(Restrictions.like("cattleByCattlemaId.num", "%"+breeding.getCattleByCattlemaId().getNum()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

	@Override
	public List<Breeding> getSearchReport(String Start,String End){
		return sesssion.getCurrentSession().createQuery("from Breeding where date BETWEEN '"+Start+"' and '"+End+"' ").list();
	}
	
}
