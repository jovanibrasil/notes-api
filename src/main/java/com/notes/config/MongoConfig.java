package com.notes.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClientURI;

@Profile({"prod", "stage"})
@Configuration
@Slf4j
@EnableConfigurationProperties(NotesMongoProperties.class)
public class MongoConfig {

	private final NotesMongoProperties configuration;

	public MongoConfig(NotesMongoProperties configuration) {
		this.configuration = configuration;
	}
	
	@Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        log.info("Creating mongo factory ...");
		MongoClientURI clientURI = new MongoClientURI(this.configuration.getUrl());
        return new SimpleMongoDbFactory(clientURI);
    }
	
	/**
	 * 
	 * MongoTemplate is a wrapper with connection information.
	 * 
	 * 
	 * @return
	 * @throws Exception 
	 */
	@Bean(name = "mongoTemplate")
	public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory,
            MongoMappingContext context) throws Exception {
		log.info("Generating mongo template ...");
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
	}

}