package com.trgr.discorch.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
public class PersistenceRestRepositoryServiceApp {

    public static void main( String[] args ) throws UnknownHostException {
        SpringApplication app = new SpringApplication( PersistenceRestRepositoryServiceApp.class );
        Environment env = app.run( args ).getEnvironment();
        log.info(
                "Access URLs:\n----------------------------------------------------------\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}\n\t" +
                        "External: \thttp://{}:{}\n\t" +
                        "Profiles: \t{}\n----------------------------------------------------------",
                env.getProperty( "server.port" ),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty( "server.port" ),
                env.getActiveProfiles()
        );
    }
}
