package ru.zernoproject.zerno.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BonusRequest {
    private String firstName;
    private String lastName;
    private String phone;
}
