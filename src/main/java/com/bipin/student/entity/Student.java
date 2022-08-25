package com.bipin.student.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Document
public class Student {

    @Id
    private String id ;
    @Column(unique=true)
    private String username ;
    private String name;
    private int age ;

}
