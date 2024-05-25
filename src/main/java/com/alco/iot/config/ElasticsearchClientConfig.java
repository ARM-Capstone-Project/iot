package com.alco.iot.config;

import org.apache.catalina.User;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.alco.iot.repository")
public class ElasticsearchClientConfig {

    @Value("${spring.elasticsearch.uris}")
    private String uris;

    @Value("${spring.elasticsearch.username}")
    private String userName;

    @Value("${spring.elasticsearch.password}")
    private String password;

    @Bean(name = "highLevelClient")
    public RestClient restclient() {
        HttpHost[] httpHosts = new HttpHost[1];
        httpHosts[0] = new HttpHost("812f1966c0e94b07a22210fb1326f2c3.us-central1.gcp.cloud.es.io",9243,"https");
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(userName,password));
        return RestClient.builder(httpHosts)
                .setHttpClientConfigCallback(httpAsyncClientBuilder -> httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider))
                .build();


    }

}
