package com.edwards.DAO;


import com.edwards.model.Empl;

import java.util.List;

// empl service
public interface EmplService {

    // save
    Empl save (Empl empl);

    // get a single record
    Empl get (long id);

    // get all the record
    List<Empl> getAll();

    // update the record:
    void update (Long id, Empl empl);

    // delete:
    void delete(Empl empl);
}
