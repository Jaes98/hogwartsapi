package kea.exercise.hogwartsapi.controllers;


import kea.exercise.hogwartsapi.models.Teacher;
import kea.exercise.hogwartsapi.repositories.TeacherRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/teachers")
public class TeacherController {
    private TeacherRepository repo;

    public TeacherController(TeacherRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return repo.save(teacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        return repo.save(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable int id) {
        repo.deleteById(id);
    }
}
