package ru.zernoproject.zerno.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bonus {

    private String firstName;
    private String lastName;
    private int bonuses;
    @Id
    private String phone;
}
