package Message.entity;

import jakarta.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Embedded
    private Address address;

    public Person() {}
    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
