package healthcares.spring.service;

import java.util.List;
import healthcares.spring.model.Privilege;

public interface PrivilegeService {
	public void add(Privilege privilege);
	public void edit(Privilege privilege);
	public void delete(int id);
	public Privilege getPrivilege(int id);
	public List getAllPrivilege();
}
