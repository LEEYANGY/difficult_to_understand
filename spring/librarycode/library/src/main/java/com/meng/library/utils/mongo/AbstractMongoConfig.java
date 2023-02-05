package com.meng.library.utils.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public abstract class AbstractMongoConfig {

    // Mongo DB Properties
    private String hostPort, database, username, password;
    // private String port;
    // Setter methods go here..

    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @SuppressWarnings({"resource"})
    public MongoDbFactory mongoDbFactory() throws Exception {
        List<ServerAddress> seeds = new ArrayList<>();
        String[] hostPorts = hostPort.split(",");
        for (int i = 0; i < hostPorts.length; i++) {
            String[] hps = hostPorts[i].split(":");
            ServerAddress serverAddress = new ServerAddress(hps[0], Integer.valueOf(hps[1]));
            seeds.add(serverAddress);
        }
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return new SimpleMongoDbFactory(new MongoClient(seeds), database);
        }
        List<MongoCredential> mongoCredentialList = new ArrayList<>();
        mongoCredentialList.add(MongoCredential.createCredential(username, database, password.toCharArray()));
        return new SimpleMongoDbFactory(new MongoClient(seeds, mongoCredentialList), database);
    }

    abstract public MongoTemplate getMongoTemplate() throws Exception;

}
