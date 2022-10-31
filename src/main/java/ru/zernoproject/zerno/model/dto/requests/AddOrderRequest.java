package ru.zernoproject.zerno.model.dto.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    @NotBlank(message = "Fill the staff field")
    @JsonProperty("staffName")
    private String staffName;
    @NotBlank(message = "Fill the user msisdn field")
    @JsonProperty("userMsisdn")
    private Long userMsisdn;
    @JsonProperty("order")
    private List<AddOrderItemsListRequest> orderItemsList;
}
