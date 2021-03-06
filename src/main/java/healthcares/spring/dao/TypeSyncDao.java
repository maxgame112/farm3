package healthcares.spring.dao;

import java.util.List;

import healthcares.spring.model.TypeSync;



public interface TypeSyncDao {
	public void add(TypeSync typesync);
	public void edit(TypeSync typesync);
	public void delete(int Id);
	public TypeSync getTypeSync(int Id);
	public List getAllTypeSync();
	public List getAllTypeSyncByName(String value);
}
