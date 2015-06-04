package dd.aclabs.project.data.repository;

import java.util.List;

/**
 * Created by Maris Alexandru
 */
public interface BaseDAO<T,K> {

	public T save(T entity);
	public List<T> getAll();
	public T getById(K id);
	public void delete(T user);
	
}
