package ru.zernoproject.zerno.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "stuff_name")
    Staff staff;

    @ManyToOne
    @JoinColumn(name = "user_phone")
    Users users;

    @ManyToOne
    @JoinColumn(name = "menu_position")
    Menu menu;

    @Column(name = "order_creation_date")
    private LocalDateTime orderCreationDate;

    public CustomerOrder(Users users, Menu menu, Staff staff) {
        this.users = users;
        this.menu = menu;
        this.staff = staff;
    }

    public CustomerOrder(Staff staff, Users users, Menu menu, LocalDateTime orderCreationDate) {
        this.staff = staff;
        this.users = users;
        this.menu = menu;
        this.orderCreationDate = orderCreationDate;
    }
}
