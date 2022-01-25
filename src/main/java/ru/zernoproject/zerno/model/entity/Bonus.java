package ru.zernoproject.zerno.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bonus", schema = "zerno")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private int bonuses;
    private String phone;
}
