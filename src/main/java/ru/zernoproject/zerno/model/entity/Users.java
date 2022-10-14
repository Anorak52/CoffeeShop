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
//@IdClass(BonusKey.class)
public class Users {
    //@Id
    @Column(name = "full_name")
    private String fullName;
    @Id
    @Column(name = "phone")
    private Long phone;
    @Column(name = "bonuses")
    private int bonuses;

    @OneToMany(mappedBy = "users")
    List<CustomerOrder> orders;

    public Users(String fullName, Long phone, int bonuses) {
        this.fullName = fullName;
        this.phone = phone;
        this.bonuses = bonuses;
    }
}
