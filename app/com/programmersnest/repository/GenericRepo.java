/**
 * 
 */
package com.programmersnest.repository;

import java.util.List;
import java.util.Optional;


/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

public interface GenericRepo<T>{

	public Optional<String> save(T object);
	public Optional<List<T>> findAll();
	public Optional<List<T>> findAll(int page, int pageSize);
	public Optional<List<T>> findByProperty(String property, String value, int page, int pageSize);
	public Optional<T> findById(String id);
	public Optional<Boolean> removeByProperty(String propery, String value);
	public Optional<Boolean> removeById(String id);
	public Optional<Long> count();
}
