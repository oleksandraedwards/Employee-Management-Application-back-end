package com.edwards.DAO;

import java.util.List;


import com.edwards.model.Empl;
import com.edwards.repository.EmplRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EmplServiceImpl implements EmplService {

    @Autowired
    EmplRep emplRep;


    // SAVE EMPL
    @Override
    public Empl save(Empl empl) {
        return emplRep.save(empl);
    }

    // FIND BY ID
    @Override
    public Empl get(long id) {
        return emplRep.getOne(id);
    }

    // GET ALL
    @Override
    public List<Empl> getAll() {
        return (List<Empl>) emplRep.findAll();
    }


    // HOW TO UPDATE?
    @Override
    public void update(Long id, Empl empl) {
    }

    // DELETE
    @Override
    public void delete(Empl emp) {
        emplRep.delete(emp);
    }
}
