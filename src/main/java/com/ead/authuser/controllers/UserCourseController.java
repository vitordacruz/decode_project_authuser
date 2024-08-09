package com.ead.authuser.controllers;

import com.ead.authuser.clients.CourseClient;
import com.ead.authuser.dtos.CourseDTO;
import com.ead.authuser.services.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Log4j2
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class UserCourseController {

    public static final String ERROR_SUBSCRIPTION_ALREADY_EXISTS = "Error: subscription already exists!";
    public static final String USER_NOT_FOUND = "User not found";

    public static final String USER_COURSE_NOT_FOUND = "User Course not found";

    @Autowired
    CourseClient courseClient;

    @Autowired
    UserService userService;

    @GetMapping("/users/{userId}/courses")
    public ResponseEntity<Page<CourseDTO>> getAllCoursesByUser(
            @PageableDefault(page = 0,
            size = 10,
            sort = "courseID",
            direction = Sort.Direction.ASC) Pageable pageable,
            @PathVariable(value = "userId") UUID userId) {

        return ResponseEntity.status(HttpStatus.OK).body(courseClient.getAllCoursesByUser(userId, pageable));

    }

}
