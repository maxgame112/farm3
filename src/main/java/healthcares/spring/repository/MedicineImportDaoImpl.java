package healthcares.spring.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import healthcares.spring.dao.MedicineImportDao;
import healthcares.spring.model.MedicineImport;
@Repository
public class MedicineImportDaoImpl implements MedicineImportDao {
	@Autowired
	private SessionFactory session;

	@Override
	public void add(MedicineImport medicineimport) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(medicineimport);
	}

	@Override
	public void edit(MedicineImport medicineimport) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(medicineimport);
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getMedicineImport(Id));
	}

	@Override
	public MedicineImport getMedicineImport(int Id) {
		// TODO Auto-generated method stub
		return (MedicineImport) session.getCurrentSession().get(MedicineImport.class, Id);
	}
@Override //เชควันหมดอายุล่วงหน้า.0
public List<MedicineImport> CheckAlertExp(int day){
	return session.getCurrentSession().createQuery("from MedicineImport where status=0 and DATEDIFF(dayExp,curdate()) < "+day).list();
}
@Override
public List<MedicineImport> CheckAlertExpForNextpage(int day, int page){
	Query q = session.getCurrentSession().createQuery("from MedicineImport where status=0 and DATEDIFF(dayExp,curdate()) < "+day);
	q.setFirstResult((page-1)*10);
	q.setMaxResults(10);
	
	return q.list();		
}
	@Override
	public List<MedicineImport> getAllMedicineImport() {
		// TODO Auto-generated method stub

		//String Start="2016-05-10";
		//String End="2016-06-09";
		//int id = 42; // and day BETWEEN '"+Start+"' and '"+End+"'
		return session.getCurrentSession().createQuery("from MedicineImport").list();
	}
	@Override
	public List<MedicineImport> getSearchReport(String Start,String End,int memid){
		//String mem = "admin";
		if(memid==0){
			return session.getCurrentSession().createQuery("from MedicineImport where day BETWEEN '"+Start+"' and '"+End+"'").list();
		}
		else{
			return session.getCurrentSession().createQuery
					("from MedicineImport medicineimport where medicineimport.member.id='"+memid+"' and day BETWEEN '"+Start+"' and '"+End+"'").list();
		}
		
		
	}
	@Override
	public List<MedicineImport> getSearchReportForNextPage(String Start,String End,int memid,int page){
		Query q=null;
		if(memid==0){
			q = session.getCurrentSession().createQuery("from MedicineImport where day BETWEEN '"+Start+"' and '"+End+"'");
		}
		else{
			q = session.getCurrentSession().createQuery
					("from MedicineImport medicineimport where medicineimport.member.id='"+memid+"' and day BETWEEN '"+Start+"' and '"+End+"'");
		}
		q.setFirstResult((page-1)*10);
		q.setMaxResults(10);
		
		return q.list();
	}
	
	
	
	
	@Override
	public List<MedicineImport> getSearch(MedicineImport medicineimport,int page){
		Criteria criteria = session.getCurrentSession().createCriteria(MedicineImport.class);
		if(medicineimport.getMedicine()!=null){
			criteria.setFetchMode("medicine", FetchMode.JOIN);
			criteria.createAlias("medicine", "med");
			criteria.add(Restrictions.like("med.tradeName", "%"+medicineimport.getMedicine().getTradeName()+"%"));
		}
		if(medicineimport.getMember()!=null){
			criteria.setFetchMode("member", FetchMode.JOIN);
			criteria.createAlias("member", "mem");
			criteria.add(Restrictions.like("mem.first", "%"+medicineimport.getMember().getFirst()+"%"));
		}
		if(medicineimport.getDay()!=null){
			criteria.add(Restrictions.like("day", "%"+medicineimport.getDay()+"%"));
		}
		criteria.addOrder(Order.desc("day")); //เอาวันที่ล่าสุดขึ้นก่อน
		criteria.setFirstResult((page-1)*10);
		criteria.setMaxResults(10);
		return  criteria.list();
	}
	@Override
	public int CountAllMedicineImport(MedicineImport medicineimport){
		Criteria criteria = session.getCurrentSession().createCriteria(MedicineImport.class);
		if(medicineimport.getMedicine()!=null){
			criteria.setFetchMode("medicine", FetchMode.JOIN);
			criteria.createAlias("medicine", "med");
			criteria.add(Restrictions.like("med.tradeName", "%"+medicineimport.getMedicine().getTradeName()+"%"));
		}
		if(medicineimport.getMember()!=null){
			criteria.setFetchMode("member", FetchMode.JOIN);
			criteria.createAlias("member", "mem");
			criteria.add(Restrictions.like("mem.first", "%"+medicineimport.getMember().getFirst()+"%"));
		}
		if(medicineimport.getDay()!=null){
			criteria.add(Restrictions.like("day", "%"+medicineimport.getDay()+"%"));
		}
		return (int) criteria.setProjection(Projections.rowCount()).uniqueResult();
	}
	
}
