package ru.zernoproject.zerno.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JsonIgnore
    private Integer id;
    @Column(unique = true, nullable = false)
    private String number;

    @OneToOne(mappedBy = "phoneId", fetch = FetchType.LAZY)
    private Bonus bonusId;
    @OneToOne(mappedBy = "phone", fetch = FetchType.LAZY)
    private Staff staff;

    @JsonIgnore
    public Bonus getBonusId() {
        return bonusId;
    }

    @JsonIgnore
    public Staff getStaff() {
        return staff;
    }

    public Phone(String number) {
        this.number = number;
    }

    public Phone(Integer id, String number) {
        this.id = id;
        this.number = number;
    }
}
