package ru.zernoproject.zerno.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitorRequest {
    private String phone;
    private List<VisitorOrder> order;
    private boolean discount;
}
