package com.project.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement// it will tell spring, find those methods where transactional is written.
//then springboot will create a transactional context corresponding to the method.Hence we achieved Atomicity.
//Also we achieved isolation as any transaction that happens, is independent of each other.
//PlatFormTransactionManagement: does all the commits and rollback.It's an interface
//MongoTransactionManager : is implementation of PlatFormTransactionManagement

//Not: that if you are using mongoDb shell, there is only one instance running. But replication is necessary in
//mongodb for the transaction to happen. Therefore you will need mongoDb atlas to use transaction.
public class JournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalApplication.class, args);
	}

	@Bean
	public PlatformTransactionManager randomName(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);
	}

}
