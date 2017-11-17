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

import healthcares.spring.dao.PregnantDao;
import healthcares.spring.model.Breeding;
import healthcares.spring.model.Pregnant;
import healthcares.spring.model.TreatmentHistory;
@Repository
public class PregnantDaoImpl implements PregnantDao {

	@Autowired
	private SessionFactory sesssion;
	
	@Override
	public void add(Pregnant pregnant) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(pregnant);
	}

	@Override
	public void edit(Pregnant pregnant) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(pregnant);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getPregnant(Id));
	}

	@Override
	public Pregnant getPregnant(int Id) {
		// TODO Auto-generated method stub
		return (Pregnant) sesssion.getCurrentSession().get(Pregnant.class,Id);
	}

	

	@Override
	public List getAllPregnant() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from Pregnant").list();
	}
	
/*	@Override
	public List getPregnantBynum(int s){
		return sesssion.getCurrentSession().createQuery("from Pregnant where statusPregnant = 2 and and stat = "+s+" ").list();
	}*/
	
	@Override
	public List getSearch(Pregnant pregnant,int page){
		Criteria criteria = sesssion.getCurrentSession().createCriteria(Pregnant.class);
		if (pregnant.getBreeding() != null) {
			if(pregnant.getBreeding().getCattleByCattlemaId() != null){
			criteria.setFetchMode("breeding", FetchMode.JOIN);
			criteria.createAlias("breeding.cattleByCattlemaId", "breeding");
			criteria.add(Restrictions.like("breeding.num", "%"+pregnant.getBreeding().getCattleByCattlemaId().getNum()+"%"));
			}
			if(pregnant.getBreeding().getCattleByCattlefaId() != null){
				criteria.setFetchMode("breeding", FetchMode.JOIN);
				criteria.createAlias("breeding.cattleByCattlefaId", "breeding");
				criteria.add(Restrictions.like("breeding.num", "%"+pregnant.getBreeding().getCattleByCattlefaId().getNum()+"%"));
				}
		}
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return criteria.list();
	}
	
	@Override
	public List getSearch(Pregnant pregnant){
		Criteria criteria = sesssion.getCurrentSession().createCriteria(Pregnant.class);
		if (pregnant.getBreeding() != null) {
			if(pregnant.getBreeding().getCattleByCattlemaId() != null){
				criteria.setFetchMode("breeding", FetchMode.JOIN);
				criteria.createAlias("breeding.cattleByCattlemaId", "breeding");
				criteria.add(Restrictions.like("breeding.num", "%"+pregnant.getBreeding().getCattleByCattlemaId().getNum()+"%"));
				}
				if(pregnant.getBreeding().getCattleByCattlefaId() != null){
					criteria.setFetchMode("breeding", FetchMode.JOIN);
					criteria.createAlias("breeding.cattleByCattlefaId", "breeding");
					criteria.add(Restrictions.like("breeding.num", "%"+pregnant.getBreeding().getCattleByCattlefaId().getNum()+"%"));
					}
		}
		return criteria.list();
	}
	
	@Override
	public int getPregnantByCattle(int id){
		return (int) sesssion.getCurrentSession().createQuery("SELECT MAX(id) from Pregnant p where p.breeding.cattleByCattlemaId.id =" +id).uniqueResult();
	}

	@Override
	public int getFartherIdByMomId(int id){
		return (int) sesssion.getCurrentSession().createQuery("SELECT MAX(id) from Pregnant where breeding.cattleByCattlemaId.id = "+id+" and statusPregnant = 1").uniqueResult();
	}
	
	@Override
	public List<Pregnant> getSearchReport(String Start,String End){
		return sesssion.getCurrentSession().createQuery("from Pregnant where datePreg BETWEEN '"+Start+"' and '"+End+"' ").list();
	}
	
}
