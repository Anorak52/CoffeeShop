package ru.zernoproject.zerno.model.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    private String staffName;
    private Long userMsisdn;
    private List<String> menuPostions;
}
