package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.TypeAlertDao;
import healthcares.spring.model.TypeAlert;
@Repository
public class TypeAlertDaoImpl implements TypeAlertDao {

	@Autowired
	private SessionFactory sesssion;	
	
	@Override
	public void add(TypeAlert typealert) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(typealert);
	}

	@Override
	public void edit(TypeAlert typealert) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(typealert);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getTypeAlerte(id));
	}

	@Override
	public TypeAlert getTypeAlerte(int id) {
		// TODO Auto-generated method stub
		return (TypeAlert) sesssion.getCurrentSession().get(TypeAlert.class, id);
	}

	@Override
	public List getAllTypeAlert() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from TypeAlert").list();
	}

	@Override
	public List getAllTypeAlertById(int id) {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from TypeAlert where id ="+id).list();
	}

}
