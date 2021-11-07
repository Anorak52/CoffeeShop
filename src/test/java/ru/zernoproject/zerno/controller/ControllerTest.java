package ru.zernoproject.zerno.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.zernoproject.zerno.model.dto.VisitorOrder;
import ru.zernoproject.zerno.model.dto.VisitorRequest;
import ru.zernoproject.zerno.service.impl.ZernoCoffeeImpl;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ZernoController.class)
class TestZernoController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ZernoCoffeeImpl zernoCoffeeImpl;

    @BeforeEach
    public void setUp() {
        List<VisitorOrder> visitorOrder = List.of(new VisitorOrder("Flet", 1));
        VisitorRequest visitorRequest = new VisitorRequest("John", "Markovich","1", visitorOrder, true);
        Mockito.when(zernoCoffeeImpl.makeOrder(visitorRequest)).thenReturn("Спасибо за ваш заказ, вам начисленно 3 баллов");
    }

    @Test
    void thenZernoThen404() throws Exception {
        this.mockMvc.perform(post("/zerno")).andExpect(status().is4xxClientError());
    }

    @Test
    void zernoOrderThenOk() throws Exception {
    this.mockMvc
        .perform(
            post("/zerno/order")
                .contentType("application/json")
                .content(
                    "{\n"
                        + "    \"firstName\": \"John\",\n"
                        + "    \"lastName\": \"Markovich\",\n"
                        + "    \"order\": [\n"
                        + "        {\n"
                        + "            \"orderName\": \"Flet\",\n"
                        + "            \"orderNumber\": 1\n"
                        + "        }\n"
                        + "    ],\n"
                        + "    \"discount\": \"true\"\n"
                        + "}"))
        .andExpect(status().isOk());
    }

    @Test
    void addBonusOk() throws Exception {
        this.mockMvc
                .perform(
                        post("/zerno/addBonus")
                                .contentType("application/json")
                                .content(
                                        "{\n" +
                                                "    \"firstName\": \"John\",\n" +
                                                "    \"lastName\": \"Markovich\",\n" +
                                                "    \"phone\": \"89048563245\"\n" +
                                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    void getBonusOk() throws Exception {
        this.mockMvc
                .perform(
                        get("/zerno/getBonus")
                                .contentType("application/json")
                                .content(
                                        "{\n" +
                                                "    \"phone\": \"89024576375\"\n" +
                                                "}"))
                .andExpect(status().isOk());
    }
}