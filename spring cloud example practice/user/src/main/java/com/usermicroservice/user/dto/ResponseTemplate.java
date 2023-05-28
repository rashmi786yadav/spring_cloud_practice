package com.usermicroservice.user.dto;

import com.usermicroservice.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ResponseTemplate {
    private User user;
    private Department department;

    public ResponseTemplate(User user, Department department) {
        this.user = user;
        this.department = department;
    }
    public ResponseTemplate() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
