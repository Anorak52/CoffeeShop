package ru.zernoproject.zerno.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zernoproject.zerno.model.dto.AppResponse;
import ru.zernoproject.zerno.model.dto.requests.AddStaffRequest;
import ru.zernoproject.zerno.model.dto.requests.AddUserRequest;
import ru.zernoproject.zerno.service.ManageUsers;

@RestController
@RequestMapping("zerno/v1/manage/")
@RequiredArgsConstructor
public class ManageUsersController {

    private final ManageUsers manageUsers;

    @PostMapping(value = "add_user",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse> addUser(@RequestBody AddUserRequest dto) {
        return ResponseEntity.ok(manageUsers.addUser(dto));
    }

    @PostMapping(value = "add_staff",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppResponse> addStaff(@RequestBody AddStaffRequest dto) {
        return ResponseEntity.ok(manageUsers.addStaff(dto));
    }
}
