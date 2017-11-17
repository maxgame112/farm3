package healthcares.spring.repository;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.AlertDao;
import healthcares.spring.model.Alert;
@Repository
public class AlertDaoImpl implements AlertDao {
	
	@Autowired
	private SessionFactory sesssion;

	@Override
	public void add(Alert alert) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(alert);
	}

	@Override
	public void edit(Alert alert) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(alert);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getalert(Id));
	}

	@Override
	public Alert getalert(int Id) {
		// TODO Auto-generated method stub
		return (Alert) sesssion.getCurrentSession().get(Alert.class, Id);
	}

	@Override
	public List getAllalert() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from Alert Where statusAlert = 1 and datediff(datealert,CURDATE()) <= 7 ORDER BY datealert ").list();
	}
	
	@Override
	public List Date1(){
		return sesssion.getCurrentSession().createQuery("from Alert Where statusAlert = 1 and datediff(datealert,CURDATE()) < 8 and datediff(datealert,CURDATE()) > 0 ").list();
	}
	
	@Override
	public List Date2(){
		return sesssion.getCurrentSession().createQuery("from Alert Where statusAlert = 1 and datediff(datealert,CURDATE()) = 0 ").list();
	}
	
	
	@Override
	public List Date3(){
		return sesssion.getCurrentSession().createQuery("from Alert Where statusAlert = 1 and datediff(datealert,CURDATE()) < 0 ").list();
	}
	
	@Override
	public List getAlertId(String cattleId, int i){
		Criteria criteria = sesssion.getCurrentSession().createCriteria(Alert.class);
		criteria.add(Restrictions.eq("statusAlert.id", 1));
		criteria.add(Restrictions.eq("cattle_1", cattleId));
		criteria.add(Restrictions.eq("typeAlert.id", i));
		return criteria.list();
	}
	
	@Override
	public List getAlloalert(int page){
		Query q = sesssion.getCurrentSession().createQuery("from Alert Where statusAlert = 1 and datediff(datealert,CURDATE()) <= 3 ORDER BY datealert");
		q.setFirstResult((page-1)*10);
		q.setMaxResults(10);
		return q.list();
	
	}

}
