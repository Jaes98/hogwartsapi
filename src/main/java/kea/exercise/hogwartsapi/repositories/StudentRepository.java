package kea.exercise.hogwartsapi.repositories;

import kea.exercise.hogwartsapi.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
