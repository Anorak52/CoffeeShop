package ru.zernoproject.zerno.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JsonIgnore
    private Integer id;

    private String address;
    private String firstName;
    private String lastName;
    private Double salary;
    private String position;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn (name="phone_id", referencedColumnName = "id")
    private Phone phone;

    @JsonIgnore
    public Phone getPhone() {
        return phone;
    }

    public Staff(String firstName, String lastName, String address, String position, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.position = position;
        this.salary = salary;
    }
}
