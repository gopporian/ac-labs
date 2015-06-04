package dd.aclabs.project.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dd.aclabs.project.data.repository.BaseDAO;

/**
 * Created by Maris Alexandru
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class })
public abstract class BaseServiceImpl<T, K extends Serializable> implements BaseService<T, K> {

	@Override
	public T save(T entity) {
		return (T) getRepository().save(entity);
	}

	@Override
	public T get(K id) {
		return (T) getRepository().getById(id);
	}
	
	public abstract BaseDAO<T,K> getRepository();
		
	@Override
	public List<T> getAll() {
		return (List<T>) getRepository().getAll();
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
