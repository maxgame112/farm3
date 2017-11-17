package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.Sync;



public interface SyncService {
	public void add(Sync sync);
	public void edit(Sync sync);
	public void delete(int Id);
	public Sync getSync(int Id);
	public List getAllSync();
	public List getSyncByq(String q);
	public List getAllSyncByType(int id);
	public List LastSync(int id);
}
