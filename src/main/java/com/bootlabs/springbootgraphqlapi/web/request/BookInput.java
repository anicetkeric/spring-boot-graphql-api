package com.bootlabs.springbootgraphqlapi.web.request;

public record BookInput(String title,String description,String isbn, Double price, Integer page, Long authorId){}