package ru.zernoproject.zerno.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Menu {
    @Id
    private String title;
    private Double price;

    @OneToMany(mappedBy = "menu")
    List<CustomerOrder> orders;

    public Menu(String title, Double price) {
        this.title = title;
        this.price = price;
    }
}
