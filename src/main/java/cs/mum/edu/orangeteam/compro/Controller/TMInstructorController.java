package cs.mum.edu.orangeteam.compro.Controller;

import cs.mum.edu.orangeteam.compro.Model.TMInstructor;
import cs.mum.edu.orangeteam.compro.Service.TMIstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/tmInstructor/tmInstructors")
public class TMInstructorController {
    @Autowired
    private TMIstructorService tmIstructorService;
    @GetMapping("")
public List<TMInstructor> getAllTMInstructors(){
        return tmIstructorService.getTMInstructors();
}
    @GetMapping("/{id}")
    public TMInstructor getTMInstructorById(@PathVariable Long id) {
       return tmIstructorService.findTMInstructorById(id);
    }
    @PostMapping("/add")
    public TMInstructor addTMInstructor(@RequestBody final TMInstructor tmInstructor) {
        return tmIstructorService.addTMInstructor(tmInstructor);
    }
    @PatchMapping  ("update")
    public TMInstructor updateTMInstructor(@RequestBody final TMInstructor tmInstructor) {
        return tmIstructorService.updateTMInstructor(tmInstructor);
    }
    @DeleteMapping("delete/{id}")
    public boolean deleteTMInstructor(@PathVariable ("id") Long id) {
       TMInstructor tmInstructor=tmIstructorService.findTMInstructorById(id);
       if(tmInstructor==null) return false;
        tmIstructorService.deleteTMInstructor(id);
        return true;
    }
}
