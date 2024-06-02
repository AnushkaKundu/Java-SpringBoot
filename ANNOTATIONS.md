### RestController:  
### RequestMapping: map to path
### Component: 
```java
@Component
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "mary",
                        "mary@gmail.com",
                        LocalDate.of(2000, Month.JANUARY,5),
                        21
                )
        );
    }
}
```
### Service: 
```java
@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "mary",
                        "mary@gmail.com",
                        LocalDate.of(2000, Month.JANUARY,5),
                        21
                )
        );
    }
}
```
### Autowired: dependency injection 
(needs service/ component in the called fxn)

```java
private final StudentService studentService;

@Autowired
public StudentController(StudentService studentService) {
    this.studentService = studentService;
}
```

### GetMapping: 

### Entity
### Table
###
