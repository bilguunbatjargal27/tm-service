package cs.mum.edu.orangeteam.compro.Controller;

import cs.mum.edu.orangeteam.compro.Service.TMIstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class TMInstructorController {
    @Autowired
    private TMIstructorService tmIstructorService;
public List<Student> viewAllStudents(){
    return tmIstructorService.getAllStudents();
}
}
