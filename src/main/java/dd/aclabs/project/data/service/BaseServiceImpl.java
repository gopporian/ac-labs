package dd.aclabs.project.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public abstract class BaseServiceImpl<T, K extends Serializable> implements BaseService<T, K> {

	@Override
	public T save(T entity) {
		return (T) getRepository().save(entity);
	}

	@Override
	public T get(K id) {
		return (T) getRepository().findOne(id);
	}
	
	public abstract CrudRepository<T,K> getRepository();
		
	@Override
	public List<T> getAll() {
		return (List<T>) getRepository().findAll();
	}
	
	@Override
	public T update(T entity) {
		return (T) getRepository().save(entity);
	}

	@Override
	public T delete(K id) {
		T entity = get(id);
		getRepository().delete(entity);
		return entity;
	}
	
}
