package cs.mum.edu.orangeteam.compro.Controller;

import cs.mum.edu.orangeteam.compro.Model.TMInstructor;
import cs.mum.edu.orangeteam.compro.Model.caster.CastStudent;
import cs.mum.edu.orangeteam.compro.Service.TMIstructorService;
import javassist.expr.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tmInstructor/tmInstructors")
public class  TMInstructorController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TMIstructorService tmIstructorService;

    @GetMapping("")
    public ResponseEntity<?> getAllTMInstructors() {
        List<TMInstructor> TmInstructor = (List<TMInstructor>) tmIstructorService.getTMInstructors();
        return ResponseEntity.ok(TmInstructor);
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
        return list;
    }

    @GetMapping("studentsByInstructorId/{id}")
    public List<CastStudent> getAllStudentsByInstructor(@PathVariable("id") Long id) {
        String url = "http://course-service/course/students/bytminstructor/";
        ResponseEntity<List<CastStudent>> students = restTemplate.exchange(url + id,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<CastStudent>>() {
                });
        List<CastStudent> list = students.getBody();
        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTMInstructorById(@PathVariable Long id) {
        TMInstructor TmInstructor= tmIstructorService.findTMInstructorById(id);
        return ResponseEntity.ok(TmInstructor);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTMInstructor(@Valid @RequestBody final TMInstructor tmInstructor, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
         tmIstructorService.addTMInstructor(tmInstructor);
        return ResponseEntity.badRequest().body("TMInstructor is created successfully");
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateTMInstructor(@Valid @RequestBody final TMInstructor tmInstructor, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
       TMInstructor tm=tmIstructorService.updateTMInstructor(tmInstructor);
        return  ResponseEntity.status(HttpStatus.OK).body("TMInstructor is updated successfully");
    }
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTMInstructor(@PathVariable("id") Long id){
         TMInstructor tmInstructor = tmIstructorService.findTMInstructorById(id);
        if(tmInstructor == null) return ResponseEntity.badRequest().body("There is no TMInstructor has an id equal to" + id);
        tmIstructorService.deleteTMInstructor(id);
        return ResponseEntity.status(HttpStatus.OK).body("TMInstructor is deleted successfully");
    }
}