package kea.exercise.hogwartsapi.repositories;

import kea.exercise.hogwartsapi.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
}
