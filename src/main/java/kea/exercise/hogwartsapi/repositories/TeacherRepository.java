package kea.exercise.hogwartsapi.repositories;

import kea.exercise.hogwartsapi.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer>{
}
