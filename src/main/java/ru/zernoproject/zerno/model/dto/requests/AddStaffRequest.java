package ru.zernoproject.zerno.model.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.zernoproject.zerno.model.dto.Person;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddStaffRequest extends Person {
    private String position;
}
