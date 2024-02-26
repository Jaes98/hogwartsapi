package kea.exercise.hogwartsapi.controllers;


import kea.exercise.hogwartsapi.dtos.StudentRequestDTO;
import kea.exercise.hogwartsapi.dtos.StudentResponseDTO;
import kea.exercise.hogwartsapi.models.Student;
import kea.exercise.hogwartsapi.repositories.StudentRepository;
import kea.exercise.hogwartsapi.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentRepository repo) {
        this.studentService = studentService;
    }

    @GetMapping
    public Iterable<StudentResponseDTO> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable int id) {
        return ResponseEntity.of(studentService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDTO createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody StudentRequestDTO student) {
        return ResponseEntity.of(studentService.updateIfExists(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> deleteOne(@PathVariable int id) {
        return ResponseEntity.of(studentService.deleteById(id));
    }
}
