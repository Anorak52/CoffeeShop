package ru.zernoproject.zerno.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "phone", schema = "zerno")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    @OneToOne(mappedBy="phone", cascade = CascadeType.ALL)
    private Staff staff;

    public Phone(String number) {
        this.number = number;
    }
}
