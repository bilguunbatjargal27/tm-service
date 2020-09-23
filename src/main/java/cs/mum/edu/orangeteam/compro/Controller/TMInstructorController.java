package cs.mum.edu.orangeteam.compro.Controller;

import cs.mum.edu.orangeteam.compro.Model.TMInstructor;
import cs.mum.edu.orangeteam.compro.Model.TMRecord;
import cs.mum.edu.orangeteam.compro.DTO.Student;
import cs.mum.edu.orangeteam.compro.Service.TMIstructorService;
import cs.mum.edu.orangeteam.compro.Service.TMRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tmInstructor/tmInstructors")
public class TMInstructorController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TMIstructorService tmIstructorService;

    @Autowired
    private TMRecordService tmRecordService;

    @GetMapping("")
    public List<TMInstructor> getAllTMInstructors() {
        return tmIstructorService.getTMInstructors();
    }

    @GetMapping("students")
    public List<Student> getAllStudents() {
        String url = "http://course-service/course/students";
        ResponseEntity<List<Student>> students = restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {
                });
        List<Student> list = students.getBody();
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//        headers.add("Content-Type", "application/json");
//
//        for(CastStudent student: list){
//            student.setName(student.getName() + " UPDATED FROM TM SERVICE");
//            HttpEntity<?> httpEntity = new HttpEntity<CastStudent>(student, headers);
//            restTemplate.exchange(url + "/update", HttpMethod.PUT, httpEntity, CastStudent.class);
//        }
        return list;
    }

    @GetMapping("studentsByInstructorId/{id}")
    public List<Student> getAllStudentsByInstructor(@PathVariable("id") Long id) {
        String url = "http://course-service/course/students/bytminstructor/";
        ResponseEntity<List<Student>> students = restTemplate.exchange(url + id,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {
                });
        List<Student> list = students.getBody();
        return list;
    }

    @GetMapping("/{id}")
    public TMInstructor getTMInstructorById(@PathVariable Long id) {
        return tmIstructorService.findTMInstructorById(id);
    }

    @GetMapping("assignStudent/{tmId}/{stuId}")
    public ResponseEntity<?> getTMInstructorById(@PathVariable Long tmId, @PathVariable Long stuId) {
        String url = "http://course-service/course/students";
        ResponseEntity<Student> responseEntity = restTemplate.exchange(url + "/" + stuId,
                HttpMethod.GET, null, new ParameterizedTypeReference<Student>() {
                });
        Student student = responseEntity.getBody();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Content-Type", "application/json");

        student.setTmInstructor(tmId);

        HttpEntity<?> httpEntity = new HttpEntity<Student>(student, headers);
        restTemplate.exchange(url + "/update", HttpMethod.PUT, httpEntity, Student.class);
        return ResponseEntity.ok("Successfully assign student");
    }

    @GetMapping("assignTM/{tmId}/{stuId}/{date}")
    public ResponseEntity<?> assignTMAppointment(@PathVariable Long tmId, @PathVariable Long stuId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        TMRecord tmRecord = new TMRecord();
        tmRecord.setStudentId(stuId);
        TMInstructor tmInstructor = tmIstructorService.findTMInstructorById(tmId);
        tmRecord.setTmInstructor(tmInstructor);
        tmRecord.setCheckingDate(date);
        tmRecordService.addTMRecord(tmRecord);
        return ResponseEntity.ok("Successfully assign tm record");
    }

    @PostMapping("/add")
    public TMInstructor addTMInstructor(@RequestBody final TMInstructor tmInstructor) {
        return tmIstructorService.addTMInstructor(tmInstructor);
    }

//    @GetMapping("/{courseId}/{tmAttendance}")
//    public TMInstructor getTMInstructorById(@PathVariable Long courseId, @PathVariable int tmAttendance) {
//        String url = "http://course-service/course/courses";
//        ResponseEntity<Student> responseEntity = restTemplate.exchange(url + "/" + courseId,
//                HttpMethod.GET, null, new ParameterizedTypeReference<Student>() {
//                });
//        Student student = responseEntity.getBody();
//    }

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
