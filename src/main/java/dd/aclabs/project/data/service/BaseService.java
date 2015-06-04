package dd.aclabs.project.data.service;

import java.util.List;

/**
 * Created by Maris Alexandru
 */
public interface BaseService <T,K>{
	
	public T save(T entity);
	public T get(K id);
	public List<T> getAll();
	public T update(T sp);
	public T delete(K id);
	
}
