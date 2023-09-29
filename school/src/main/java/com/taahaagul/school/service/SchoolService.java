package com.taahaagul.school.service;

import com.taahaagul.school.client.StudentClient;
import com.taahaagul.school.dto.FullSchoolResponse;
import com.taahaagul.school.entity.School;
import com.taahaagul.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

     public void saveSchool(School school) {
         schoolRepository.save(school);
     }

     public List<School> findAllSchool() {
         return schoolRepository.findAll();
     }

    public FullSchoolResponse findSchoolWithStudents(Integer schoolId) {
         var school = schoolRepository.findById(schoolId)
                 .orElse(
                         School.builder()
                                 .name("NOT_FOUND")
                                 .email("NOT_FOUND")
                                 .build()
                 );
         var students = studentClient.findAllStudentsBySchool(schoolId);
         return FullSchoolResponse.builder()
                 .name(school.getName())
                 .email(school.getEmail())
                 .students(students)
                 .build();
    }
}
