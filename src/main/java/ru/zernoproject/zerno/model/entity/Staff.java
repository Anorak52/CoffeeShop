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
@Table(name = "Staff")
public class Staff {
    @Id
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "msisdn")
    private Long msisdn;
    private String position;

    @OneToMany(mappedBy = "staff")
    List<CustomerOrder> orders;

    public Staff(String fullName, Long msisdn, String position) {
        this.fullName = fullName;
        this.msisdn = msisdn;
        this.position = position;
    }

    public Staff(String fullName) {
        this.fullName = fullName;
    }
}
