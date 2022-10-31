package ru.zernoproject.zerno.model.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderItemsListRequest {
    private String position;
    @NotBlank(message = "Fill the amount field")
    private int amount;
}
