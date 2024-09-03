package com.springdataJPAexample.jpa.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass

//This class acts as a super class to group every common attributes that other subclasses have
//to make everything looks more concise and easier to manage and maintain
//This class do not have its table, it's just like a skeleton
public class BaseEntity {

    @Id
    @GeneratedValue
            /*(
            strategy = GenerationType.TABLE,
            generator = "author_id_gen"
    )

    @SequenceGenerator(
            name = "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )

    @TableGenerator(
            name = "author_id_gen",
            table = "id_generator",
            pkColumnName = "id_name",
            valueColumnName = "id_value",
            allocationSize = 1
    )
    */

    private Integer id;

    private LocalDateTime createdAt;

    private LocalDateTime lastModifiedAt;

    private String createdBy;

    private String lastModifiedBy;
}
