package kea.exercise.hogwartsapi.services;

import kea.exercise.hogwartsapi.dtos.StudentRequestDTO;
import kea.exercise.hogwartsapi.dtos.StudentResponseDTO;
import kea.exercise.hogwartsapi.models.House;
import kea.exercise.hogwartsapi.models.Student;
import kea.exercise.hogwartsapi.repositories.HouseRepository;
import kea.exercise.hogwartsapi.repositories.StudentRepository;
import org.springframework.stereotype.Service;

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

    private Student toEntity(StudentRequestDTO student) {
        Student entity = new Student();
        entity.setFirstName(student.getFirstName());
        entity.setMiddleName(student.getMiddleName());
        entity.setLastName(student.getLastName());
        entity.setDateOfBirth(student.getDateOfBirth());
        Optional<House> house = houseRepository.findById(student.getHouse());
        house.ifPresent(entity::setHouse);
        entity.setPrefect(student.isPrefect());
        entity.setEnrollmentYear(student.getEnrollmentYear());
        entity.setGraduationYear(student.getGraduationYear());
        entity.setGraduated(student.isGraduated());
        return entity;
    }

    public Optional<StudentResponseDTO> deleteById(int id) {
        Optional<StudentResponseDTO> existingStudent = this.findById(id);
        studentRepository.deleteById(id);
        return existingStudent;
    }

    public Optional<Student> updateIfExists(int id, Student student) {
        if(studentRepository.findById(id).isPresent()) {
            student.setId(id);
            studentRepository.save(student);
            return Optional.of(student);
        } else {
            return Optional.empty();
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
