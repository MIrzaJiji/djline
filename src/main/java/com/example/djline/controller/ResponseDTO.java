package com.example.djline.controller;

public class ResponseDTO {
    private Long id;
    private String name;
    private String data;

    public ResponseDTO(long id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
