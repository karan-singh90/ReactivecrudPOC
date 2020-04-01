package com.reactive.reacitveProgramming.modalEntity;


import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @PrimaryKey
    private Integer id;

    private String first_name;

    private String last_name;

    private int age;

    private String email;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
