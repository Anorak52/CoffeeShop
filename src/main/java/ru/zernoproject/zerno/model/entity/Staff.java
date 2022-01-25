package ru.zernoproject.zerno.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "staff", schema = "zerno")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;
    private String firstName;
    private String lastName;
    private Double salary;
    private String position;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn (name="phone_id")
    private Phone phone;

    public Staff(String firstName, String lastName, String address, String position, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.position = position;
        this.salary = salary;
    }
}
