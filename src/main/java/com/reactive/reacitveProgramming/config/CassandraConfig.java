package com.reactive.reacitveProgramming.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories(basePackages = "com.reactive.reacitveProgramming.repository")
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {
    @Value("${spring.data.cassandra.contactpoints}")
    private String contactPoints;
    @Value("${spring.data.cassandra.port}")
    private int port;
    @Value("${spring.data.cassandra.keyspace}")
    private String keyspace;

    @Override
    protected String getKeyspaceName() {
        return keyspace;
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected boolean getMetricsEnabled() {
        // see https://stackoverflow.com/questions/53101753/spring-boot-data-cassandra-reactive-jmxreporter-problem
        // and https://docs.datastax.com/en/developer/java-driver/3.5/manual/metrics/
        return false;
    }
}
