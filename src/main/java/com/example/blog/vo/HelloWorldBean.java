package com.example.blog.vo;

import lombok.Data;


//loambok
@Data
public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean{message='%s'}", message);

    }
}