package com.usermicroservice.user.service;

import com.usermicroservice.user.dto.Department;
import com.usermicroservice.user.dto.ResponseTemplate;
import com.usermicroservice.user.entity.User;
import com.usermicroservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseTemplate getUserByDepartmentId(Long userId)  {
        ResponseTemplate responseTemplate=new ResponseTemplate();
        User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException());
        Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        responseTemplate.setUser(user);
        responseTemplate.setDepartment(department);
        return responseTemplate;
    }
}
