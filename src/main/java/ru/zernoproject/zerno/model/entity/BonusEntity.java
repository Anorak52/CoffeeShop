package ru.zernoproject.zerno.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BonusEntity {

    private String firstName;
    private String lastName;
    private Integer bonus;
    @Id
    private String phone;
}
