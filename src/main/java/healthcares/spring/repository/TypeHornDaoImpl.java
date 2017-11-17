package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.TypeHornDao;
import healthcares.spring.model.TypeHorn;
@Repository
public class TypeHornDaoImpl implements TypeHornDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(TypeHorn typehorn) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(typehorn);
	}

	@Override
	public void edit(TypeHorn typehorn) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(typehorn);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getTypeHorn(Id));
	}

	@Override
	public TypeHorn getTypeHorn(int Id) {
		// TODO Auto-generated method stub
		return (TypeHorn) session.getCurrentSession().get(TypeHorn.class, Id);
	}

	@Override
	public List getAllTypeHorn() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from TypeHorn").list();
	}

}
