package com.company.onlinestore.core;

import com.haulmont.addon.bproc.provider.UserProvider;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.security.entity.User;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component(EmployeeUserProvider.NAME)
public class EmployeeUserProvider implements UserProvider {
    public static final String NAME = "onlinestore_EmployeeUserProvider";
    private static final String EMPLOYEE_ROLE_NAME = "application-employee";
    @Inject
    private DataManager dataManager;

    @Override
    public User get(String executionId) {
        return dataManager.load(User.class).query("select u from sec$User u join u.userRoles ur where ur.role.name = :roleName")
                .parameter("roleName", EMPLOYEE_ROLE_NAME)
                .one();
    }
}