package ru.zernoproject.zerno.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @NotBlank(message = "Fill the fullName field")
    @JsonProperty("fullName")
    private String fullName;
    @NotBlank(message = "Fill the msisdn field")
    @JsonProperty("msisdn")
    private Long msisdn;
}
