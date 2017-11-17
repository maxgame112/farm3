package healthcares.spring.service;

import java.util.List;


import healthcares.spring.model.MedicineImport;

public interface MedicineImportService {
	public void add(MedicineImport medicineimport);
	public void edit(MedicineImport medicineimport);
	public void delete(int Id);
	public MedicineImport getMedicineImport(int Id);
	public List<MedicineImport> getAllMedicineImport();
	public List<MedicineImport> CheckAlertExp(int day);
	public List<MedicineImport> CheckAlertExpForNextpage(int day, int page);
	
	public List<MedicineImport> getSearch(MedicineImport medicineimport,int page); //ค้นหา
	int CountAllMedicineImport(MedicineImport medicineimport);
	public List<MedicineImport> getSearchReport(String Start,String End,int memid);
	public List<MedicineImport> getSearchReportForNextPage(String Start,String End,int memid,int page);
}
