package com.reactive.reacitveProgramming.config;

import com.reactive.reacitveProgramming.controller.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
//Using Router functions which will use handler function

@Configuration
public class UserRouter {

    @Bean
    public RouterFunction userRoutes(UserHandler userHandler) {
        return RouterFunctions
                .route(RequestPredicates.POST("/users/createuser").and(accept(MediaType.APPLICATION_JSON)), userHandler::addUser)
                .andRoute(RequestPredicates.GET("/users").and(accept(MediaType.APPLICATION_JSON)), userHandler::getUsers)
                .andRoute(RequestPredicates.GET("/users/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::getUserById)
                .andRoute(RequestPredicates.DELETE("/deleteUser/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::deleteUserById)
                .andRoute(RequestPredicates.PUT("/updateUser").and(accept(MediaType.APPLICATION_JSON)), userHandler::updateUser);

    }


}
