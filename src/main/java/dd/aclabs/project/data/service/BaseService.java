package dd.aclabs.project.data.service;

import java.util.List;

public interface BaseService <T,K>{
	
	public T save(T entity);
	public T get(K id);
	public List<T> getAll();
	public T update(T sp);
	public T delete(K id);
	
}
