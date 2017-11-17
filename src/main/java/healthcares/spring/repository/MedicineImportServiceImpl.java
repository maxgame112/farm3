package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.MedicineImportDao;
import healthcares.spring.model.MedicineImport;
import healthcares.spring.service.MedicineImportService;
@Service
public class MedicineImportServiceImpl implements MedicineImportService {
	@Autowired
	private MedicineImportDao medicineimportdao;
	@Transactional
	public void add(MedicineImport medicineimport) {
		// TODO Auto-generated method stub
		medicineimportdao.add(medicineimport);
	}

	@Transactional
	public void edit(MedicineImport medicineimport) {
		// TODO Auto-generated method stub
		medicineimportdao.edit(medicineimport);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		medicineimportdao.delete(Id);
	}

	@Transactional
	public MedicineImport getMedicineImport(int Id) {
		// TODO Auto-generated method stub
		return medicineimportdao.getMedicineImport(Id);
	}
@Transactional
public List<MedicineImport> CheckAlertExp(int day){
 return medicineimportdao.CheckAlertExp(day);
}
@Transactional
public List<MedicineImport> CheckAlertExpForNextpage(int day, int page){
	return medicineimportdao.CheckAlertExpForNextpage(day, page);
}
	@Transactional
	public List<MedicineImport> getAllMedicineImport() {
		// TODO Auto-generated method stub
		return medicineimportdao.getAllMedicineImport();
	}
	@Transactional
	public List<MedicineImport> getSearch(MedicineImport medicineimport,int page){
		return medicineimportdao.getSearch(medicineimport, page);
	}
	@Transactional
	public int CountAllMedicineImport(MedicineImport medicineimport){
		return medicineimportdao.CountAllMedicineImport(medicineimport);
	}
	@Transactional
	public List<MedicineImport> getSearchReport(String Start,String End,int memid){
		return medicineimportdao.getSearchReport(Start, End, memid);
	}
	@Transactional
	public List<MedicineImport> getSearchReportForNextPage(String Start,String End,int memid,int page){
		return medicineimportdao.getSearchReportForNextPage(Start, End, memid, page);
	}

}
