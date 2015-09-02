/**
 * 
 */
package repository.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

import repository.GenericRepository;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
@SuppressWarnings({"unchecked"})
public class GenericRepositoryImpl<T, ID extends Serializable> extends SimpleMongoRepository<T, Serializable> implements GenericRepository<T, Serializable>{

	private Type entityClass;
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public GenericRepositoryImpl(MongoEntityInformation<T, Serializable> metadata, MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
		
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public Optional<T> findById(String id) {
		Optional<T> optional = Optional.empty();
		Optional.ofNullable(mongoTemplate.findOne(query(where("id").is(id)), entityClass.getClass()));
		return optional;
	}

	/*@Override
	public Optional<List<T>> findListByProperty(String property, Object value) {
		Optional<List<T>> optional = Optional.empty();
		Optional.ofNullable(mongoTemplate.find(query(where(property).is(value)), entityClass.getClass()));
		return optional;
	}*/
}
