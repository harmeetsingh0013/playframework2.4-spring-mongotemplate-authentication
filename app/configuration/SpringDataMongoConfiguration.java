/**
 * 
 */
package configuration;


import java.net.InetSocketAddress;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.ServerAddress;

/**
 * @author Harmeet Singh(Taara)
 * @version 1.0
 */
@Configuration
@ComponentScan
@EnableMongoRepositories(basePackages="repository")
public class SpringDataMongoConfiguration extends AbstractMongoConfiguration{

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
	
	@Override
	protected String getDatabaseName() {
		return configuration.getString("mongodb.dbname");
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(serverAddress(), mongoClientOptions());
	}
	
	@Override
	protected String getMappingBasePackage() {
		return configuration.getString("package.scan");
	}
}
