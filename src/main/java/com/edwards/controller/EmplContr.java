package com.edwards.controller;

import com.edwards.DAO.EmplServiceImpl;
import com.edwards.model.Empl;
import com.edwards.repository.EmplRep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class EmplContr{

    // save an empl
    @Autowired
    EmplServiceImpl emplServiceImpl;

    @Autowired
    EmplRep emplRep;

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    /////////////////////////////////////////////////
    // FIND ALL
    @GetMapping("empl-list")
    public List<Empl> getAllEmpl()
    {
        return emplServiceImpl.getAll();
    }


    /////////////////////////////////////////////////
    // CREATE EMPL
    @PostMapping("empl-list")
    public Empl createEmployee(@Valid @RequestBody Empl empl) {
        return emplRep.save(empl);
    }


    /////////////////////////////////////////////////
    // FIND BY ID
    @GetMapping("empl-list/{id}")
    public ResponseEntity<Empl>
    findByID(@PathVariable(value = "id") Long id)
//            throws ResourceNotFoundException {
//        Empl empl = emplRep.findById()
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
    {
        {
            Empl emp = emplServiceImpl.get(id);

            if (emp == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(emp);
        }
    }


    /////////////////////////////////////////////////
    // UPDATE EMPL
    @PutMapping("empl-list/{id}")
    public ResponseEntity<Empl>
    updateEmpl( @PathVariable(value = "id") Long id,
           @Valid @RequestBody Empl emplDetails)
//            throws ResourceNotFoundException {
//        Empl empl = emplRep.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        {

        Empl emp = emplServiceImpl.get(id);

        if (emp == null) {
            return ResponseEntity.notFound().build();
        }

        emp.setName(emplDetails.getName());
        emp.setLastName(emplDetails.getLastName());
        emp.setSalary(emplDetails.getSalary());
        emp.setPosition(emplDetails.getPosition());

        Empl updatedEmpl = emplServiceImpl.save(emp);

        return ResponseEntity.ok().body(updatedEmpl);
    }


    /////////////////////////////////////////////////
    // DELETE EMPL
    @DeleteMapping("empl-list/{id}")
    public ResponseEntity<Empl>
    deleteEmpl(@PathVariable(value = "id") Long id) {

        Empl emp = emplServiceImpl.get(id);

        try{
            LOG.info("Employee id to delete " + id);
        } catch (EntityNotFoundException rx){
            LOG.error(rx.getMessage(), rx);
        }
        if (emp == null) {
            return ResponseEntity.notFound().build();
        }

        emplRep.delete(emp);
        return ResponseEntity.ok().body(emp);

    }

//
//    @DeleteMapping("/employees/{id}")
//    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
//            throws ResourceNotFoundException {
//        Empl employee = emplRep.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        emplRep.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
}



//    @DeleteMapping("/empl/{id}")
//    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
//            throws ResourceNotFoundException {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        emplRep.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
