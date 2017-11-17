package healthcares.spring.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.MedicineDao;
import healthcares.spring.model.Medicine;


@Repository
public class MedicineDaoImpl implements MedicineDao {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Medicine medicine) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(medicine);
	}

	@Override
	public void edit(Medicine medicine) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(medicine);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getMedicine(Id));
	}	

	@Override
	public Medicine getMedicine(int Id) {
		// TODO Auto-generated method stub
		return (Medicine) session.getCurrentSession().get(Medicine.class, Id);
	}

	@Override
	public Medicine getMedicine2(int[] Id) {
		// TODO Auto-generated method stub
		return (Medicine) session.getCurrentSession().get(Medicine.class, Id);
	}
	
	
	@Override
	public List getAllMedicine() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Medicine").list();
	}
	
	@Override
	public List<Medicine> getNameMedBygroup(int Id){
		return session.getCurrentSession().createQuery("from Medicine where GroupMedicine ="+Id).list();
	}
	
	@Override
	public List<Medicine> getSearch(Medicine medicine,int page){
		Criteria criteria = session.getCurrentSession().createCriteria(Medicine.class);
		if (medicine.getTradeName() != null) {
			criteria.add(Restrictions.like("tradeName", "%"+medicine.getTradeName()+"%"));
		}
		if (medicine.getGroupMedicine() != null) {
			criteria.setFetchMode("groupMedicine", FetchMode.JOIN);
			criteria.createAlias("groupMedicine", "groupM");
			criteria.add(Restrictions.like("groupM.value", "%"+medicine.getGroupMedicine().getValue()+"%"));
		}
		if (medicine.getProperties() != null) {
			criteria.add(Restrictions.like("properties", "%"+medicine.getProperties()+"%"));
		}
		criteria.addOrder(Order.desc("medicineSuccess"));
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return criteria.list();
	}

	@Override
	public int CountAllMedicine(Medicine medicine){
		Criteria criteria = session.getCurrentSession().createCriteria(Medicine.class);
		if (medicine.getTradeName() != null) {
			criteria.add(Restrictions.like("tradeName", "%"+medicine.getTradeName()+"%"));
		}
		if (medicine.getGroupMedicine() != null) {
			criteria.setFetchMode("groupMedicine", FetchMode.JOIN);
			criteria.createAlias("groupMedicine", "groupM");
			criteria.add(Restrictions.like("groupM.value", "%"+medicine.getGroupMedicine().getValue()+"%"));
		}
		if (medicine.getProperties() != null) {
			criteria.add(Restrictions.like("properties", "%"+medicine.getProperties()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
	/*-------------------------------ค้นหา-----------------------------*/
	/*@Override
	public List getSeachAllMedicine2(Medicine medicine) {
		// TODO Auto-generated method stub
		Criteria criteria = session.getCurrentSession().createCriteria(Medicine.class);
		
		
        if( medicine.getMediId() != "" && medicine.getMediId() != null){
        	criteria.add(Restrictions.like("Id", "%"+ medicine.getMediId() +"%"));
        	
        }else if( medicine.getCommonName() != "" && medicine.getCommonName() != null){
        	criteria.add(Restrictions.like("commonName", "%"+ medicine.getCommonName() +"%"));
        }
        
        
        
	return  criteria.list();
	}

	@Override
	public List getSeachAllMedicine3(Medicine medicine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getSeachAllMedicine5(Medicine medicine) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
