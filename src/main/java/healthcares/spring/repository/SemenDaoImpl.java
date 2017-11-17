package healthcares.spring.repository;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.SemenDao;
import healthcares.spring.model.Semen;

@Repository
public class SemenDaoImpl implements SemenDao {
	@Autowired
	private SessionFactory session;
	
	
	@Override
	public void add(Semen semen) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(semen);
	}

	@Override
	public void edit(Semen semen) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(semen);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getSemen(Id));
	}

	@Override
	public Semen getSemen(int Id) {
		// TODO Auto-generated method stub
		return (Semen) session.getCurrentSession().get(Semen.class, Id);
	}

	@Override
	public List<Semen> getAllSemen() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Semen").list();
	}

	@Override //àª¤ª×èÍ«éÓ
	public List<Semen> getSemenByNameCattle(String nameCattle) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Semen where nameCattle='"+nameCattle+"' ").list();
	}

}
