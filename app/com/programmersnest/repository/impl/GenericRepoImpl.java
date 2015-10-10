/**
 * 
 */
package com.programmersnest.repository.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.WriteResult;
import com.programmersnest.configuration.MongoDbConfig;
import com.programmersnest.documents.AbstractDocument;
import com.programmersnest.repository.GenericRepo;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
@SuppressWarnings({"unchecked"})
public class GenericRepoImpl<T extends AbstractDocument> implements GenericRepo<T>{

	private Class<T> entityClass;
	private MongoTemplate mongoTemplate;
	@Inject
	private MongoDbConfig mongoDbConfig;

	private static final Logger logger = LoggerFactory.getLogger(GenericRepoImpl.class);
	
	public GenericRepoImpl(){
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	
	public MongoTemplate getMongoTemplate() {
		logger.info("mongoTemplate method in Repository");
		
		if(this.mongoTemplate != null){
			return mongoTemplate;
		}else{
			mongoTemplate = mongoDbConfig.mongoTemplate();
			return mongoTemplate;
		}
	}
	
	private Query queryPagination(int page, int pageSize){
		logger.info("queryPagination method in Repository");
		
		Query query = new Query();
		int offset = (page - 1) * pageSize;
		query.skip(offset);
		query.limit(pageSize);
		return query;
	}
	
	@Override
	public Optional<String> save(T object) {
		logger.info("save method in Repository");
		
		getMongoTemplate().save(object);
		return Optional.ofNullable(object.getId());
	}

	@Override
	public Optional<List<T>> findAll() {
		logger.info("findAll method in Repository");
		
		return Optional.ofNullable(getMongoTemplate().findAll(entityClass));
	}

	@Override
	public Optional<List<T>> findAll(int page, int pageSize) {
		logger.info("findAll pager method in Repository");
		
		return Optional.ofNullable(getMongoTemplate().find(queryPagination(page, pageSize), entityClass));
	}

	@Override
	public Optional<List<T>> findByProperty(String property, String value, int page, int pageSize) {
		logger.info("findByProperty pager method in Repository");
		
		Criteria criteria = where(property).is(value);
		Query query = queryPagination(page, pageSize);
		query.addCriteria(criteria);
		return Optional.ofNullable(getMongoTemplate().findAllAndRemove(query, entityClass));
	}

	@Override
	public Optional<T> findById(String id) {
		logger.info("findById pager method in Repository");
		
		return Optional.ofNullable(getMongoTemplate().findById(id, entityClass));
	}

	public Optional<Boolean> removeByProperty(String propery, String value){
		logger.info("removeByProperty pager method in Repository");
		
		Criteria criteria = where(propery).is(value);
		Query query = new Query(criteria);
		WriteResult result = getMongoTemplate().remove(query, entityClass);
		return (result.getN() >= 1)? Optional.of(true): Optional.of(false);  
	}
	
	@Override
	public Optional<Boolean> removeById(String id) {
		logger.info("removeById pager method in Repository");
		
		return removeByProperty("_id", id);
	}

	@Override
	public Optional<Long> count() {
		logger.info("count pager method in Repository");
		
		return Optional.ofNullable(getMongoTemplate().count(new Query(), entityClass));
	}
	
	
}
