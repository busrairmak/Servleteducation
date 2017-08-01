package com.mebitech.Servleteducation.domain;

public class Student {
    private Long id;
    private String name;
    private Integer no;

    public Student(String name, Integer no) {
        this.name = name;
        this.no = no;
    }

    public Student(Long id, String name, Integer no) {
        this.id = id;
        this.name = name;
        this.no = no;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
}
