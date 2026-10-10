
package com.example.session03.service;

import com.example.session03.model.Enrollment;
import com.example.session03.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository repository;

    public EnrollmentService(EnrollmentRepository repository) {
        this.repository = repository;
    }

    public List<Enrollment> getAllEnrollments() {
        return repository.findAll();
    }

    public Enrollment findEnrollmentById(long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy Enrollment có id: " + id));
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return repository.create(enrollment);
    }

    public Enrollment updateEnrollment(long id, Enrollment enrollment) {
        return repository.update(id, enrollment);
    }

    public void deleteEnrollmentById(long id) {
        repository.deleteById(id);
    }
}
