package ru.zernoproject.zerno.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.zernoproject.zerno.model.dto.AppResponse;
import ru.zernoproject.zerno.model.dto.requests.AddStaffRequest;
import ru.zernoproject.zerno.model.dto.requests.AddUserRequest;
import ru.zernoproject.zerno.model.entity.Staff;
import ru.zernoproject.zerno.model.entity.Users;
import ru.zernoproject.zerno.repository.StaffRepository;
import ru.zernoproject.zerno.repository.UsersRepository;
import ru.zernoproject.zerno.service.ManageUsers;

import static ru.zernoproject.zerno.utils.Constants.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class ManageUsersImpl implements ManageUsers {

    private final UsersRepository usersRepository;
    private final StaffRepository staffRepository;

    public AppResponse addUser(AddUserRequest request) {
        Users existing = usersRepository.findUsersByMsisdn(request.getMsisdn());
        if (existing == null) {
            usersRepository.save(new Users(request.getFullName(), request.getMsisdn()));
            return new AppResponse(CREATED);
        }
        return new AppResponse(USER_ALREADY_EXISTS);
    }

    public AppResponse addStaff(AddStaffRequest request) {
        Staff existingStaff = staffRepository.findStaffByFullName(request.getFullName());
        if (existingStaff == null ) {
            staffRepository.save(new Staff(request.getFullName(), request.getMsisdn(), request.getPosition()));
            return new AppResponse(CREATED);
        }
        return new AppResponse(STAFF_ALREADY_EXISTS);
    }
}
