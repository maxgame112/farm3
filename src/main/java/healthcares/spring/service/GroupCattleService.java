package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.GroupCattle;



public interface GroupCattleService {
	public void add(GroupCattle groupcattle);
	public void edit(GroupCattle groupcattle);
	public void delete(int Id);
	public GroupCattle getGroupCattle(int Id);
	public List getAllGroupCattle();
}
