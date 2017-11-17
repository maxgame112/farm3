package healthcares.spring.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.DiseaseDao;
import healthcares.spring.model.Disease;
@Repository
public class DiseaseDaoImpl implements DiseaseDao {

	@Autowired
	private SessionFactory sesssion;
	
	@Override
	public void add(Disease disease) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(disease);
	}

	@Override
	public void edit(Disease disease) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(disease);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getDisease(Id));
	}

	@Override
	public Disease getDisease(int Id) {
		// TODO Auto-generated method stub
		return (Disease)sesssion.getCurrentSession().get(Disease.class, Id);
	}

	@Override
	public List getAllDisease() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from Disease").list();
	}
	
	@Override
	public List getDiseaseName(String nameDisease) {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from Disease where nameDisease LIKE '%"+nameDisease+"%'").list();
	}
	
	@Override
	public List<Disease> getSearch(Disease disease , int page){
		Criteria criteria = sesssion.getCurrentSession().createCriteria(Disease.class);
		if (disease.getNameDisease() != null) {
			criteria.add(Restrictions.like("nameDisease", "%"+disease.getNameDisease()+"%"));
		}
		if (disease.getSymptomsOfDisease() !=null) {
			criteria.add(Restrictions.like("symptomsOfDisease", "%"+disease.getSymptomsOfDisease()+"%"));
		}
		if (disease.getCableDisease() != null) {
			criteria.setFetchMode("cableDisease", FetchMode.JOIN);
			criteria.createAlias("cableDisease", "cableD");
			criteria.add(Restrictions.like("cableD.value", "%"+disease.getCableDisease().getValue()+"%"));
		}
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return criteria.list();
	}
	
	@Override
	public int CountAllDisease(Disease disease){
		Criteria criteria = sesssion.getCurrentSession().createCriteria(Disease.class);
		if (disease.getNameDisease() != null) {
			criteria.add(Restrictions.like("nameDisease", "%"+disease.getNameDisease()+"%"));
		}
		if (disease.getSymptomsOfDisease() !=null) {
			criteria.add(Restrictions.like("symptomsOfDisease", "%"+disease.getSymptomsOfDisease()+"%"));
		}
		if (disease.getCableDisease() != null) {
			criteria.setFetchMode("cableDisease", FetchMode.JOIN);
			criteria.createAlias("cableDisease", "cableDisease");
			criteria.add(Restrictions.like("cableDisease.value", "%	"+disease.getCableDisease().getValue()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}

}
