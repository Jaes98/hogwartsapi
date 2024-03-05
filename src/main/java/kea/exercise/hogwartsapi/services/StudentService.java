package kea.exercise.hogwartsapi.services;

import kea.exercise.hogwartsapi.EmpType;
import kea.exercise.hogwartsapi.dtos.StudentRequestDTO;
import kea.exercise.hogwartsapi.dtos.StudentResponseDTO;
import kea.exercise.hogwartsapi.models.House;
import kea.exercise.hogwartsapi.models.Student;
import kea.exercise.hogwartsapi.repositories.HouseRepository;
import kea.exercise.hogwartsapi.repositories.StudentRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final HouseRepository houseRepository;

    public StudentService(StudentRepository studentRepository, HouseRepository houseRepository) {
        this.studentRepository = studentRepository;
        this.houseRepository = houseRepository;
    }

    public List<StudentResponseDTO> findAll() {
        return studentRepository.findAll().stream().map(this::toDTO).toList();
    }

    public Optional<StudentResponseDTO> findById(int id) {
        return studentRepository.findById(id).map(this::toDTO);
    }

    public StudentResponseDTO save(StudentRequestDTO student) {
        return toDTO(studentRepository.save(toEntity(student)));
    }

    public Student toEntity(StudentRequestDTO student) {
        Student entity = new Student();
        entity.setFullName(student.getFullName());
        entity.setDateOfBirth(student.getDateOfBirth());
        Optional<House> house = houseRepository.findById(student.getHouse());
        house.ifPresent(entity::setHouse);
        entity.setPrefect(student.isPrefect());
        entity.setEnrollmentYear(student.getEnrollmentYear());
        entity.setGraduationYear(student.getGraduationYear());
        entity.setGraduated(student.isGraduated());
        entity.setSchoolYear(student.getSchoolYear());
        return entity;
    }

    public Optional<StudentResponseDTO> deleteById(int id) {
        Optional<StudentResponseDTO> existingStudent = this.findById(id);
        studentRepository.deleteById(id);
        return existingStudent;
    }

    public Student updateIfExists(int id, Student student) {
        if(studentRepository.findById(id).isPresent()) {
            student.setId(id);
            studentRepository.save(student);
            return student;
        }
        else {
            return null;
        }

    }
    public StudentResponseDTO toDTO(Student entity) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setLastName(entity.getLastName());
        dto.setDateOfBirth(entity.getDateOfBirth());
        dto.setHouse(entity.getHouse().getName());
        dto.setPrefect(entity.isPrefect());
        dto.setEnrollmentYear(entity.getEnrollmentYear());
        dto.setGraduationYear(entity.getGraduationYear());
        dto.setGraduated(entity.isGraduated());
        return dto;
    }
}
