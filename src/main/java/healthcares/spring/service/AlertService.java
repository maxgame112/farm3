package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.Alert;


public interface AlertService {
	public void add(Alert alert);
	public void edit(Alert alert);
	public void delete(int Id);
	public Alert getalert(int Id);
	public List getAllalert();
	public List Date1();
	public List Date2();
	public List Date3();
	public List getAlertId(String cattleId, int i);
	public List getAlloalert(int page);
}
