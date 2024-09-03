package com.springdataJPAexample.jpa.models.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_order")
public class Order {


    //Composite key
    @EmbeddedId
    private OrderID id;

    //This annotation can be used to create several fields in a database via only a single object
    //instead of creating multiple fields in each class and copy-and-paste them to other classes
    @Embedded
    private Address address;

    private String orderinfo;

    private String anotherField;
}
