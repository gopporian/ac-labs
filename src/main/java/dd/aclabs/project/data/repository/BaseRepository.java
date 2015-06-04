package dd.aclabs.project.data.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Maris Alexandru
 */
@Transactional
public abstract class BaseRepository<T, K extends Serializable> implements BaseDAO<T, K> {

	@Autowired
	protected  SessionFactory sessionFactory;
	
	protected Session getCurrentSession(){
	     return sessionFactory.getCurrentSession();
	}
	
	protected abstract Class<T> getDomainClass();
	
	@Transactional(readOnly = false)
	@Override
	public T save(T entity) {
		getCurrentSession().saveOrUpdate(entity);
		return entity;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		Criteria criteria = getCurrentSession().createCriteria(getDomainClass());
		return criteria.list();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public T getById(K id) {
		return (T) getCurrentSession().get(getDomainClass(), id);
	}
	
	@Transactional(readOnly = false)
	@Override
	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}
}
