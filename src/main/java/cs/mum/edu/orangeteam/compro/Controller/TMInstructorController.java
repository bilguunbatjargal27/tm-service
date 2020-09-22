package cs.mum.edu.orangeteam.compro.Controller;

import cs.mum.edu.orangeteam.compro.Model.TMInstructor;
import cs.mum.edu.orangeteam.compro.Model.caster.CastStudent;
import cs.mum.edu.orangeteam.compro.Service.TMIstructorService;
import javassist.expr.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/tmInstructor/tmInstructors")
public class TMInstructorController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TMIstructorService tmIstructorService;

    @GetMapping("")
    public List<TMInstructor> getAllTMInstructors() {
        return tmIstructorService.getTMInstructors();
    }

    @GetMapping("students")
    public List<CastStudent> getAllStudents() {
        String url = "http://course-service/course/students";
        ResponseEntity<List<CastStudent>> students = restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<CastStudent>>() {
                });
        List<CastStudent> list = students.getBody();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");

        for(CastStudent student: list){
            student.setName(student.getName() + " UPDATED FROM TM SERVICE");
            HttpEntity<?> httpEntity = new HttpEntity<CastStudent>(student, headers);
            restTemplate.exchange(url + "/update", HttpMethod.PUT, httpEntity, CastStudent.class);
        }
        System.out.println(list.toString());
        return list;
    }

    @GetMapping("studentsByInstructorId/{id}")
    public List<CastStudent> getAllStudentsByInstructor(@PathVariable("id") Long id) {
        String url = "http://course-service/course/students/bytminstructor/";
        ResponseEntity<List<CastStudent>> students = restTemplate.exchange(url + id,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<CastStudent>>() {
                });
        List<CastStudent> list = students.getBody();

//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//        headers.add("HeaderName", "value");
//        headers.add("Content-Type", "application/json");
//
//        for(CastStudent student: list){
//            student.setName(student.getName() + " UPDATED FROM TM SERVICE");
//            HttpEntity<?> httpEntity = new HttpEntity<CastStudent>(student, headers);
//            restTemplate.exchange(url + "/update", HttpMethod.PUT, httpEntity, CastStudent.class);
//        }
//        System.out.println(list.toString());
        return list;
    }

    @GetMapping("/{id}")
    public TMInstructor getTMInstructorById(@PathVariable Long id) {
        return tmIstructorService.findTMInstructorById(id);
    }

    @PostMapping("/add")
    public TMInstructor addTMInstructor(@RequestBody final TMInstructor tmInstructor) {
        return tmIstructorService.addTMInstructor(tmInstructor);
    }

    @PatchMapping("update")
    public TMInstructor updateTMInstructor(@RequestBody final TMInstructor tmInstructor) {
        return tmIstructorService.updateTMInstructor(tmInstructor);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteTMInstructor(@PathVariable("id") Long id) {
        TMInstructor tmInstructor = tmIstructorService.findTMInstructorById(id);
        if (tmInstructor == null) return false;
        tmIstructorService.deleteTMInstructor(id);
        return true;
    }
}
