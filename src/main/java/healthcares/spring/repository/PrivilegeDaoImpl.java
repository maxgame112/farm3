package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.PrivilegeDao;
import healthcares.spring.model.Privilege;
@Repository
public class PrivilegeDaoImpl implements PrivilegeDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Privilege privilege) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(privilege);
	}

	@Override
	public void edit(Privilege privilege) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(privilege);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getPrivilege(id));
	}

	@Override
	public Privilege getPrivilege(int id) {
		// TODO Auto-generated method stub
		return (Privilege) session.getCurrentSession().get(Privilege.class, id);
	}

	@Override
	public List getAllPrivilege() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Privilege").list();
	}

}
