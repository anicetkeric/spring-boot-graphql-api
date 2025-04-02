package com.bootlabs.springbootgraphqlapi.exception;


import graphql.GraphQLError;
import org.springframework.dao.DataAccessException;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GraphQLExceptionHandler {

    @GraphQlExceptionHandler
    public GraphQLError handle(DataNotFoundException ex) {
        return GraphQLError.newError()
                .errorType(ErrorType.NOT_FOUND)
                .message(ex.getMessage())
                .build();
    }

    @GraphQlExceptionHandler
    public GraphQLError handle(DataAccessException ex) {
        return GraphQLError.newError()
                .errorType(ErrorType.INTERNAL_ERROR)
                .message("Data access error occurred")
                .build();
    }
}