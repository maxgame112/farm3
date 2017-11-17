package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.MedicineOrder;

public interface MedicineOrderService {
	public void add(MedicineOrder medicineorder);
	public void edit(MedicineOrder medicineorder);
	public void delete(int Id);
	public MedicineOrder getMedicineOrder(int Id);
	public List<MedicineOrder> getAllMedicineOrder();
	public List<MedicineOrder> getSearch(MedicineOrder medicineorder,int page); //
	int CountAllMedicineOrder(MedicineOrder medicineorder);
	public List<MedicineOrder> getSearchReport(String Start,String End,int memid);
	public List<MedicineOrder> getSearchReportForNextPage(String Start,String End,int memid,int page);

}
