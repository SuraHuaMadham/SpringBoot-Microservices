package com.dcb.user.service;

import com.dcb.user.VO.Department;
import com.dcb.user.VO.ResponseTemplateVO;
import com.dcb.user.entity.Users;
import com.dcb.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveUser(Users user) {
        log.info("Inside save user of service");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside get user of service");
        ResponseTemplateVO vo=new ResponseTemplateVO();
        Users user=userRepository.findByUserId(userId);

        Department department=restTemplate.getForObject
                ("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }
}
