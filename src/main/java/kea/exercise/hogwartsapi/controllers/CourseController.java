package kea.exercise.hogwartsapi.controllers;


import kea.exercise.hogwartsapi.models.Course;
import kea.exercise.hogwartsapi.models.Teacher;
import kea.exercise.hogwartsapi.repositories.CourseRepository;
import kea.exercise.hogwartsapi.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private CourseRepository repo;
    private StudentRepository studentRepo;

    public CourseController(CourseRepository repo, StudentRepository studentRepo) {
        this.repo = repo;
        this.studentRepo = studentRepo;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    @GetMapping("/{id}/teacher")
    public ResponseEntity<Teacher> getTeacherByCourseId(@PathVariable int id) {
        Optional<Course> optionalCourse = repo.findById(id);
        if (optionalCourse.isPresent()) {
            if (optionalCourse.get().getTeacher() != null) {
                return ResponseEntity.ok(optionalCourse.get().getTeacher());
            } else {
                return ResponseEntity.noContent().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        return repo.save(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
        course.setId(id);
        return repo.save(course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Course> deleteOne(@PathVariable int id) {
        Optional<Course> deleteCourse = repo.findById(id);
        repo.deleteById(id);
        return ResponseEntity.of(deleteCourse);
    }


}
