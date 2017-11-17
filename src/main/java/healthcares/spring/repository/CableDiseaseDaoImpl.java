package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.CableDiseaseDao;
import healthcares.spring.model.CableDisease;
import healthcares.spring.model.Disease;
@Repository
public class CableDiseaseDaoImpl implements CableDiseaseDao {

	@Autowired
	private SessionFactory sesssion;
	
	@Override
	public void add(CableDisease cabledisease) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(cabledisease);
	}

	@Override
	public void edit(CableDisease cabledisease) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(cabledisease);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getCableDisease(Id));
	}

	@Override
	public CableDisease getCableDisease(int Id) {
		// TODO Auto-generated method stub
		return (CableDisease)sesssion.getCurrentSession().get(CableDisease.class, Id);
	}

	@Override
	public List getAllCableDisease() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from CableDisease").list();
	}

}
