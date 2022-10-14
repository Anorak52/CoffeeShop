package ru.zernoproject.zerno.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String stuffName;

    @ManyToOne
    @JoinColumn(name = "user_phone")
    Users users;

    @ManyToOne
    @JoinColumn(name = "menu_position")
    Menu menu;

    public CustomerOrder(String stuffName, Users users, Menu menu) {
        this.stuffName = stuffName;
        this.users = users;
        this.menu = menu;
    }
}
