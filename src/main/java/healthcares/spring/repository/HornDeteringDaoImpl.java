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

import healthcares.spring.dao.HornDeteringDao;
import healthcares.spring.model.Disease;
import healthcares.spring.model.HornDetering;

@Repository
public class HornDeteringDaoImpl implements HornDeteringDao {

	@Autowired
	private SessionFactory sesssion;
	
	@Override
	public void add(HornDetering horndetering) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(horndetering);
	}

	@Override
	public void edit(HornDetering horndetering) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(horndetering);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getHornDetering(Id));
	}

	@Override
	public HornDetering getHornDetering(int Id) {
		// TODO Auto-generated method stub
		return (HornDetering) sesssion.getCurrentSession().get(HornDetering.class, Id);
	}

	@Override
	public List getAllHornDetering() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from HornDetering").list();
	}
	@Override
	public List<HornDetering> getSearch(HornDetering horndetering , int page){
		Criteria criteria = sesssion.getCurrentSession().createCriteria(HornDetering.class);
		if(horndetering.getCattle()!=null){
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "catt");
			criteria.add(Restrictions.like("catt.numDate", "%"+horndetering.getCattle().getNumDate()+"%"));
		}
		if(horndetering.getTypeHorn()!=null){
			criteria.setFetchMode("typeHorn", FetchMode.JOIN);
			criteria.createAlias("typeHorn", "type");
			criteria.add(Restrictions.like("type.value", "%"+horndetering.getTypeHorn().getValue()+"%"));
		}
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return criteria.list();
		
	}
	@Override
	public int CountAllHornDetering(HornDetering horndetering){
		Criteria criteria = sesssion.getCurrentSession().createCriteria(HornDetering.class);
		if(horndetering.getCattle()!=null){
			criteria.setFetchMode("cattle", FetchMode.JOIN);
			criteria.createAlias("cattle", "catt");
			criteria.add(Restrictions.like("catt.numDate", "%"+horndetering.getCattle().getNumDate()+"%"));
		}
		if(horndetering.getTypeHorn()!=null){
			criteria.setFetchMode("typeHorn", FetchMode.JOIN);
			criteria.createAlias("typeHorn", "type");
			criteria.add(Restrictions.like("type.value", "%"+horndetering.getTypeHorn().getValue()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	@Override
	public List<HornDetering> getSearchReport(String Start,String End){
		return sesssion.getCurrentSession().createQuery("from HornDetering where date BETWEEN '"+Start+"' and '"+End+"'").list();
	}

}
