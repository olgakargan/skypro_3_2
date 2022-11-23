package service;

import model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private Long lastId = 0L;

    public Student createStudent(Student student) {
        student.setId(++lastId);
        return students.put(lastId, student);
    }

    public Student findStudent(long lastId) {
        return students.get(lastId);
    }

    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(long id) {
        return students.remove(id);
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public Collection<Student> filterStudentsByAge(int age) {
        return students.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }


}