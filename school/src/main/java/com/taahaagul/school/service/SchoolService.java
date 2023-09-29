package com.taahaagul.school.service;

import com.taahaagul.school.entity.School;
import com.taahaagul.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

     public void saveSchool(School school) {
         schoolRepository.save(school);
     }

     public List<School> findAllSchool() {
         return schoolRepository.findAll();
     }
}
