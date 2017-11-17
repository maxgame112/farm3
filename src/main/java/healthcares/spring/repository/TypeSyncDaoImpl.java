package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.TypeSyncDao;
import healthcares.spring.model.TypeSync;
@Repository
public class TypeSyncDaoImpl implements TypeSyncDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(TypeSync typesync) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(typesync);
	}

	@Override
	public void edit(TypeSync typesync) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(typesync);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getTypeSync(Id));
	}

	@Override
	public TypeSync getTypeSync(int Id) {
		// TODO Auto-generated method stub
		return (TypeSync) session.getCurrentSession().get(TypeSync.class, Id);
	}

	@Override
	public List getAllTypeSync() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from TypeSync").list();
	}

	@Override
	public List getAllTypeSyncByName(String value){
		return session.getCurrentSession().createQuery("from TypeSync where value = '"+value+"' ").list();
	}
}
