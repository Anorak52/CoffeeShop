package ru.zernoproject.zerno.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    @Column(name = "msisdn")
    private Long msisdn;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "bonuses")
    private int bonuses;

    @OneToMany(mappedBy = "users")
    List<CustomerOrder> orders;

    public Users(String fullName, Long msisdn) {
        this.fullName = fullName;
        this.msisdn = msisdn;
    }
}
