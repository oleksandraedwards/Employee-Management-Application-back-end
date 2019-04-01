package com.edwards.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import com.edwards.SpringBootJwtAuthenticationApplication;
import com.edwards.model.Empl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;



@RunWith(SpringRunner.class)
// @RunWith(SpringRunner.class) : SpringRunner is short hand for SpringJUnit4ClassRunner which extends BlockJUnit4ClassRunner
// providing the functionality to launch a Spring TestContext Framework.


// @WebMvcTest(value = StudentController.class, secure = false): WebMvcTest annotation is used for unit
// testing Spring MVC application. This can be used when a test focuses only Spring MVC components. In this test,
// we want to launch only StudentController. All other controllers and mappings will not be launched when this unit test is executed.
// @WebMvcTest(value = EmplContr.class, secure = false)
@SpringBootTest(classes = SpringBootJwtAuthenticationApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest {
     @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void contextLoads() {

     }

     @Test
     public void testGetAll() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/empl-list",
        HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }


    @Test
    public void testGetEmployeeById() {
        Empl empl = restTemplate.getForObject(getRootUrl() + "/employees/1", Empl.class);
        System.out.println(empl.getName());
        assertNotNull(empl);
    }

    @Test
    public void testCreateEmployee() {
        Empl empl = new Empl();
        empl.setName("Sasha");
        empl.setLastName("Edwards");
        empl.setPosition("software developer");
        empl.setSalary(15.64);

        ResponseEntity<Empl> postResponse = restTemplate.postForEntity(getRootUrl() + "/empl-list/empl-new", empl, Empl.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateEmployee() {
        int id = 1;
        Empl employee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Empl.class);
        employee.setName("pasha");
        employee.setLastName("ivanov");
        restTemplate.put(getRootUrl() + "/employees/" + id, employee);
        Empl updatedEmployee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Empl.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void testDeleteEmployee() {
         int id = 2;
         Empl employee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Empl.class);
         assertNotNull(employee);
         restTemplate.delete(getRootUrl() + "/employees/" + id);
         try {
              employee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Empl.class);
         } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}