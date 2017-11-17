package healthcares.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import healthcares.spring.dao.CattleStampDao;
import healthcares.spring.model.CattleStamp;
import healthcares.spring.service.CattleStampService;
@Service
public class CattleStampServiceImpl implements CattleStampService {

	@Autowired
	private CattleStampDao cattlestampdao;
	
	@Transactional
	public void add(CattleStamp cattlestamp) {
		// TODO Auto-generated method stub
		cattlestampdao.add(cattlestamp);
	}

	@Transactional
	public void edit(CattleStamp cattlestamp) {
		// TODO Auto-generated method stub
		cattlestampdao.edit(cattlestamp);
	}

	@Transactional
	public void delete(int Id) {
		// TODO Auto-generated method stub
		cattlestampdao.delete(Id);
	}

	@Transactional
	public CattleStamp getCattleStamp(int Id) {
		// TODO Auto-generated method stub
		return cattlestampdao.getCattleStamp(Id);
	}

	@Transactional
	public List getAllCattleStamp() {
		// TODO Auto-generated method stub
		return cattlestampdao.getAllCattleStamp();
	}
	@Transactional
	public List<CattleStamp> getSearch(CattleStamp cattlestamp , int page){
		
		return cattlestampdao.getSearch(cattlestamp, page);
	}
	@Transactional
	public int CountAllCattleStamp(CattleStamp cattlestamp){
		return cattlestampdao.CountAllCattleStamp(cattlestamp);
	}

	@Transactional
	public List<CattleStamp> getSearchReport(String Start,String End){
		return cattlestampdao.getSearchReport(Start, End);
	}
}
