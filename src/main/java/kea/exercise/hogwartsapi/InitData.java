package kea.exercise.hogwartsapi;

import kea.exercise.hogwartsapi.models.Course;
import kea.exercise.hogwartsapi.models.House;
import kea.exercise.hogwartsapi.models.Student;
import kea.exercise.hogwartsapi.models.Teacher;
import kea.exercise.hogwartsapi.repositories.CourseRepository;
import kea.exercise.hogwartsapi.repositories.HouseRepository;
import kea.exercise.hogwartsapi.repositories.StudentRepository;
import kea.exercise.hogwartsapi.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private HouseRepository houseRepository;

    public InitData(TeacherRepository teacherRepository, StudentRepository studentRepository, CourseRepository courseRepository, HouseRepository houseRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.houseRepository = houseRepository;
    }

    public void run(String... args) {
        //Starter alle 4 houses

        House gryffindor = new House("Gryffindor", "Godric Gryffindor", "Red and Gold");
        House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", "Yellow and Black");
        House ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw", "Blue and Silver");
        House slytherin = new House("Slytherin", "Salazar Slytherin", "Green and Silver");


        //Opretter students, 3 fra hvert hus.
        Student harry = new Student("Harry", "James", "Potter", LocalDate.of(1980, 7, 31), gryffindor, true, 1991, 1998, true);
        Student ron = new Student("Ron", "Bilius", "Weasley", LocalDate.of(1980, 3, 1), gryffindor, true, 1991, 1998, true);
        Student hermione = new Student("Hermione", "Jean", "Granger", LocalDate.of(1979, 9, 19), gryffindor, true, 1991, 1998, true);

        Student hannah = new Student("Hannah", "Abbott", "", LocalDate.of(1980, 2, 1), hufflepuff, true, 1991, 1998, true);
        Student justin = new Student("Justin", "", "Finch-Fletchley", LocalDate.of(1980, 10, 1), hufflepuff, true, 1991, 1998, true);
        Student cedric = new Student("Cedric", "", "Diggory", LocalDate.of(1977, 9, 1), hufflepuff, false, 1991, 1998, true);

        Student vincent = new Student("Vincent", "Crabbe", "", LocalDate.of(1980, 10, 31), slytherin, true, 1991, 1998, true);
        Student draco = new Student("Draco", "Lucius", "Malfoy", LocalDate.of(1980, 6, 5), slytherin, true, 1991, 1998, true);
        Student pansy = new Student("Pansy", "", "Parkinson", LocalDate.of(1980, 2, 1), slytherin, true, 1991, 1998, true);

        Student terry = new Student("Terry", "Boot", "", LocalDate.of(1980, 5, 1), ravenclaw, true, 1991, 1998, true);
        Student sue = new Student("Sue", "Li", "", LocalDate.of(1980, 6, 1), ravenclaw, true, 1991, 1998, true);
        Student luna = new Student("Luna", "", "Lovegood", LocalDate.of(1981, 2, 13), ravenclaw, true, 1991, 1998, true);

        // Opretter teacher Snape
        Teacher snape = new Teacher("Severus", "", "Snape", LocalDate.of(1960, 1, 9), slytherin, true, "tenured", LocalDate.of(1981, 9, 1), LocalDate.of(1998, 4, 2));

        List<Student> studentsInCourse = Arrays.asList(harry, ron, hermione, hannah, justin, cedric, vincent, draco, pansy, terry, sue, luna);

        courseRepository.save(new Course("Potions", 1991, true, snape, studentsInCourse));
    }
}
