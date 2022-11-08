package ru.zernoproject.zerno.model.dto.requests;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderItemsListRequest {
    private String position;
    @NotBlank(message = "Fill the amount field")
    private int amount;
}
