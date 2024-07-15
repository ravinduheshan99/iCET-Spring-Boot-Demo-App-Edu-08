package edu.icet.crm.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Customer {
    private String name;
    private String email;
    private String age;
    private boolean isActive;

    public Customer(String name, String email, String age) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isActive=true;
    }

    /*
    // mannual way of doing the job, done by the builder annotation
    public Customer setName(String name) {
        this.name = name;
        return this;
    }
    */

}
