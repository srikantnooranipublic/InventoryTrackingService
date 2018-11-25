/*
Author: Srikant nooorani @ broadcom.com
*/

package com.example.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class InventoryTrackingService {

	public static void main(String[] args) {
		SpringApplication.run(InventoryTrackingService.class);
	}
	
	/*
	@Bean
    public RouterFunction<ServerResponse> monoRouterFunction(EchoHandler echoHandler) {
        return route(POST("/echo"), echoHandler::echo);
    }

	
	  @Bean
	  public RouterFunction<ServerResponse> route(EchoHandler echoHandler) {
	    return RouterFunctions
	        .route(RequestPredicates.GET("/example").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), echoHandler::echo);
	  }
	  */
}
