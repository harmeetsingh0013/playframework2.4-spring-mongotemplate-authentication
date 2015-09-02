/**
 * 
 */
package repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends MongoRepository<T, Serializable>{

	public Optional<T> findById(String id);
	//public Optional<List<T>> findListByProperty(String property, Object value);
}
