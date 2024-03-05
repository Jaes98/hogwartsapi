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

        houseRepository.save(gryffindor);
        houseRepository.save(hufflepuff);
        houseRepository.save(ravenclaw);
        houseRepository.save(slytherin);


        //Opretter students, 3 fra hvert hus.
        Student harry = new Student("Harry", "James", "Potter", LocalDate.of(1980, 7, 31), gryffindor, true, 1991, 1998, true, 7);
        studentRepository.save(harry);
        Student ron = new Student("Ron", "Bilius", "Weasley", LocalDate.of(1980, 3, 1), gryffindor, true, 1991, 1998, true, 7);
        studentRepository.save(ron);
        Student hermione = new Student("Hermione", "Jean", "Granger", LocalDate.of(1979, 9, 19), gryffindor, true, 1991, 1998, true, 7);
        studentRepository.save(hermione);

        Student hannah = new Student("Hannah", "Abbott", "", LocalDate.of(1980, 2, 1), hufflepuff, true, 1991, 1998, true, 7);
        studentRepository.save(hannah);
        Student justin = new Student("Justin", "", "Finch-Fletchley", LocalDate.of(1980, 10, 1), hufflepuff, true, 1991, 1998, true, 7);
        studentRepository.save(justin);
        Student cedric = new Student("Cedric", "", "Diggory", LocalDate.of(1977, 9, 1), hufflepuff, false, 1991, 1998, true, 7);
        studentRepository.save(cedric);

        Student vincent = new Student("Vincent", "Crabbe", "", LocalDate.of(1980, 10, 31), slytherin, true, 1991, 1998, true, 7);
        studentRepository.save(vincent);
        Student draco = new Student("Draco", "Lucius", "Malfoy", LocalDate.of(1980, 6, 5), slytherin, true, 1991, 1998, true, 7);
        studentRepository.save(draco);
        Student pansy = new Student("Pansy", "", "Parkinson", LocalDate.of(1980, 2, 1), slytherin, true, 1991, 1998, true, 7);
        studentRepository.save(pansy);

        Student terry = new Student("Terry", "Boot", "", LocalDate.of(1980, 5, 1), ravenclaw, true, 1991, 1998, true, 7);
        studentRepository.save(terry);
        Student sue = new Student("Sue", "Li", "", LocalDate.of(1980, 6, 1), ravenclaw, true, 1991, 1998, true, 7);
        studentRepository.save(sue);
        Student luna = new Student("Luna", "", "Lovegood", LocalDate.of(1981, 2, 13), ravenclaw, true, 1991, 1998, true, 7);
        studentRepository.save(luna);


        // Opretter teacher Snape
        Teacher snape = new Teacher("Severus", "", "Snape", LocalDate.of(1960, 1, 9), slytherin, true, EmpType.Tenured, LocalDate.of(1981, 9, 1), LocalDate.of(1998, 4, 2));
        teacherRepository.save(snape);

        List<Student> studentsInCourse = Arrays.asList(harry, ron, hermione, hannah, justin, cedric, vincent, draco, pansy, terry, sue, luna);

        courseRepository.save(new Course("Potions", 1991, true, snape, studentsInCourse));
    }
}
