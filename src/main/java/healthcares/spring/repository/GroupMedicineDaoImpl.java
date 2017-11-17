package healthcares.spring.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import healthcares.spring.dao.GroupMedicineDao;
import healthcares.spring.model.GroupMedicine;

@Repository
public class GroupMedicineDaoImpl implements GroupMedicineDao {

	@Autowired
	private SessionFactory sesssion;
	
	@Override
	public void add(GroupMedicine groupMedicine) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().save(groupMedicine);
	}

	@Override
	public void edit(GroupMedicine groupMedicine) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().update(groupMedicine);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		sesssion.getCurrentSession().delete(getGroupMedicine(Id));
	}

	@Override
	public GroupMedicine getGroupMedicine(int Id) {
		// TODO Auto-generated method stub
		return (GroupMedicine) sesssion.getCurrentSession().get(GroupMedicine.class, Id);
	}

	@Override
	public List getAllGroupMedicine() {
		// TODO Auto-generated method stub
		return sesssion.getCurrentSession().createQuery("from GroupMedicine ").list();
		
	}
	
	@Override
	public List getGroupMed(String name){
		return sesssion.getCurrentSession().createQuery("from GroupMedicine where value = '"+name+"'").list();
	}

}
