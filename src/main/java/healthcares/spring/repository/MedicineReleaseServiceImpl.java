package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.MedicineReleaseDao;
import healthcares.spring.model.MedicineRelease;
import healthcares.spring.service.MedicineReleaseService;
@Service
public class MedicineReleaseServiceImpl implements MedicineReleaseService {
	@Autowired
	private MedicineReleaseDao medicinereleasedao;
	@Transactional
	public void add(MedicineRelease medicinerelease) {
		// TODO Auto-generated method stub
		medicinereleasedao.add(medicinerelease);
	}

	@Transactional
	public void edit(MedicineRelease medicinerelease) {
		// TODO Auto-generated method stub
		medicinereleasedao.edit(medicinerelease);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		medicinereleasedao.delete(Id);
	}

	@Transactional
	public MedicineRelease getMedicineRelease(int Id) {
		// TODO Auto-generated method stub
		return medicinereleasedao.getMedicineRelease(Id);
	}

	@Transactional
	public List<MedicineRelease> getAllMedicineRelease() {
		// TODO Auto-generated method stub
		return medicinereleasedao.getAllMedicineRelease();
	}
	@Transactional
	public List<MedicineRelease> getSearch(MedicineRelease medicinerelease,int page){
		return medicinereleasedao.getSearch(medicinerelease, page);
	}
	@Transactional
	public int CountAllMedicineRelease(MedicineRelease medicinerelease){
		return medicinereleasedao.CountAllMedicineRelease(medicinerelease);
	}
	@Transactional
	public List<MedicineRelease> getSearchReport(String Start,String End,int memid){
		return medicinereleasedao.getSearchReport(Start, End, memid);
	}
	@Transactional
	public List<MedicineRelease> getSearchReportForNextPage(String Start,String End,int memid,int page){
		return medicinereleasedao.getSearchReportForNextPage(Start, End, memid, page);
	}
}
