package cs.mum.edu.orangeteam.compro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import cs.mum.edu.orangeteam.compro.Model.Address;
import cs.mum.edu.orangeteam.compro.Model.TMInstructor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;
import java.util.List;


public class TMInstructorControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getAllTmInstructors() throws Exception {
        String uri = "/tmInstructor/tmInstructors";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        TMInstructor[] productlist = super.mapFromJson(content, TMInstructor[].class);
        assertTrue(productlist.length > 0);
    }
    @Test
    public void getTMInstructorById() throws Exception {
        String uri = "/tmInstructor/tmInstructors/2";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void createTMInstructorSuccessfully() throws Exception {
        String uri = "/tmInstructor/tmInstructors/add";
        TMInstructor tmInstructor = new TMInstructor();
        Address address = new Address();
        address.setState("AA");
        address.setStreet("MyStreet");
        address.setZipCode("ZipCode");
        address.setCity("CITY");
        tmInstructor.setId(2L);
        tmInstructor.setName("Ginger");
        tmInstructor.setHireDate(new Date());
        tmInstructor.setOffice("6y");
        tmInstructor.setDescription("hshjahsj");
        tmInstructor.setAddress(address);
        String inputJson = super.mapToJson(tmInstructor);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }

    @Test
    public void createTMInstructorFailure() throws Exception {
        String uri = "/tmInstructor/tmInstructors/add";
        TMInstructor tmInstructor = new TMInstructor();
        Address address = new Address();
        address.setState("AA");
        address.setStreet("MyStreet");
        address.setZipCode("ZipCode");
        address.setCity("CITY");
        tmInstructor.setId(2L);
        tmInstructor.setName("Ginger");
        tmInstructor.setHireDate(new Date());
        tmInstructor.setOffice("6y");
        tmInstructor.setDescription("hshjahsj");
        tmInstructor.setAddress(address);

        String inputJson = super.mapToJson(tmInstructor);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

    @Test
    public void updateTMInstructorSuccessfully() throws Exception {
        String uri = "/tmInstructor/tmInstructors/update";
        TMInstructor tmInstructor = new TMInstructor();
        Address address = new Address();
        address.setState("AA");
        address.setStreet("MyStreet");
        address.setZipCode("ZipCode");
        address.setCity("CITY");
        tmInstructor.setId(2L);
        tmInstructor.setName("Ginger");
        tmInstructor.setHireDate(new Date());
        tmInstructor.setOffice("6y");
        tmInstructor.setDescription("hshjahsj");
        tmInstructor.setAddress(address);
        String inputJson = super.mapToJson(tmInstructor);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Student is updated successfully");
    }
   @Test
    public void updateTMInstructorFailure() throws Exception {
        String uri = "/tmInstructor/tmInstructors/update";
        TMInstructor tmInstructor = new TMInstructor();
        Address address = new Address();
        address.setState("AA");
        address.setStreet("MyStreet");
        address.setZipCode("ZipCode");
        address.setCity("CITY");
       tmInstructor.setId(2L);
       tmInstructor.setName("Ginger");
       tmInstructor.setHireDate(new Date());
       tmInstructor.setOffice("6y");
       tmInstructor.setDescription("hshjahsj");
       tmInstructor.setAddress(address);
        String inputJson = super.mapToJson(tmInstructor);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

    @Test
    public void deleteTMInstructor() throws Exception {
        String uri = "/tmInstructor/tmInstructors/delete";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "TMInstructor is deleted successfully");
    }
}
