package ru.zernoproject.zerno.service;

import ru.zernoproject.zerno.model.dto.AppResponse;
import ru.zernoproject.zerno.model.dto.requests.AddStaffRequest;
import ru.zernoproject.zerno.model.dto.requests.AddUserRequest;

public interface ManageUsers {
    AppResponse addUser(AddUserRequest dto);
    AppResponse addStaff(AddStaffRequest request);
}
