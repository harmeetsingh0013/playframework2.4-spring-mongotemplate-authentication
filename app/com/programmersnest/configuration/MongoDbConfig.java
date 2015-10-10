/**
 * 
 */
package com.programmersnest.configuration;


import java.net.InetSocketAddress;

import javax.inject.Singleton;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.ServerAddress;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */

@Singleton
public class MongoDbConfig{

	private play.Configuration configuration = play.Configuration.root();
	
	private MongoClientOptions mongoClientOptions(){
		Builder builder = new Builder();
		builder.connectionsPerHost(configuration.getInt("connections-per-host"));
		builder.connectTimeout(configuration.getInt("connections-timeout"));
		builder.maxConnectionIdleTime(configuration.getInt("max-connections-idle-time"));
		builder.maxConnectionLifeTime(configuration.getInt("max-connections-life-time"));
		builder.minConnectionsPerHost(configuration.getInt("max-connections-per-host"));
		builder.socketKeepAlive(configuration.getBoolean("socket-keep-live"));
		builder.socketTimeout(configuration.getInt("socket-timeout"));
		return builder.build();
	}
	
	private ServerAddress serverAddress(){
		ServerAddress serverAddress = new ServerAddress(new InetSocketAddress(configuration.getString("mongodb.uri"), configuration.getInt("mongodb.port")));
		return serverAddress;
	}
	
	private MongoClient mongoClient(){
		return new MongoClient(serverAddress(), mongoClientOptions());
	}
	
	private MongoDbFactory mongoDbFactory(){
		SimpleMongoDbFactory factory = new SimpleMongoDbFactory(mongoClient(), configuration.getString("mongodb.dbname"));
		return factory;
	}
	
	public MongoTemplate mongoTemplate(){
		MongoTemplate template = new MongoTemplate(mongoDbFactory());
		return template;
	}
	
}
