package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.MedicineOrderDao;
import healthcares.spring.model.MedicineOrder;
import healthcares.spring.service.MedicineOrderService;
@Service
public class MedicineOrderServiceImpl implements MedicineOrderService {
	@Autowired
	private MedicineOrderDao medicineorderdao;
	
	
	@Transactional
	public void add(MedicineOrder medicineorder) {
		// TODO Auto-generated method stub
		medicineorderdao.add(medicineorder);
	}

	@Transactional
	public void edit(MedicineOrder medicineorder) {
		// TODO Auto-generated method stub
		medicineorderdao.edit(medicineorder);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		medicineorderdao.delete(Id);
	}

	@Transactional
	public MedicineOrder getMedicineOrder(int Id) {
		// TODO Auto-generated method stub
		return medicineorderdao.getMedicineOrder(Id);
	}

	@Transactional
	public List<MedicineOrder> getAllMedicineOrder() {
		// TODO Auto-generated method stub
		return medicineorderdao.getAllMedicineOrder();
	}
	@Transactional
	public List<MedicineOrder> getSearch(MedicineOrder medicineorder,int page){
		return medicineorderdao.getSearch(medicineorder, page);
	}
	@Transactional
	public int CountAllMedicineOrder(MedicineOrder medicineorder){
		return medicineorderdao.CountAllMedicineOrder(medicineorder);
	}
	@Transactional
	public List<MedicineOrder> getSearchReport(String Start,String End,int memid){
		return medicineorderdao.getSearchReport(Start, End, memid);
	}
	@Transactional
	public List<MedicineOrder> getSearchReportForNextPage(String Start,String End,int memid,int page){
		return medicineorderdao.getSearchReportForNextPage(Start, End, memid, page);
	}
}
