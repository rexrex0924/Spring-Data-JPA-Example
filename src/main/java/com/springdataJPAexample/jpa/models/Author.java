package com.springdataJPAexample.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "AUTHOR_TBL")
//Self-defined and named query
@NamedQuery(
        name = "Author.findByNamedQuery",
        query = "select a from Author a where a.age >= :age"
)

@NamedQuery(
        name = "Author.updateByNamedQuery",
        query = "update Author a set a.age = :age"
)
public class Author extends BaseEntity {

    @Column(name = "f_name", length = 31)
    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;

    /*
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime lastModified;
    */

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

    public String toString(){
        return "Name = " + firstName + " " + lastName
                + "\nage = " + age
                + "\nemail = " + email;
    }


}
