/**
 * 
 */
package repository.custom.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;


import documents.User;
import repository.custom.UserRepoCustom;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
public class UserRepoImpl implements UserRepoCustom{

	private MongoTemplate mongoTemplate;
	
	@Override
	public Optional<List<User>> searchUsersByName(String name) {
		Optional<List<User>> optional = Optional.empty();
		
		Query query = TextQuery.queryText(new TextCriteria().matching(name)).sortByScore();
		Optional.ofNullable(mongoTemplate.find(query, User.class));
		return optional;
	}

}
