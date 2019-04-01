package com.edwards.repository;

import com.edwards.model.Empl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//JpaRepository will have all the functions
// of CrudRepository and PagingAndSortingRepository.
// So if you don't need the com.edwards.crudsecurity.repository to have the
// functions provided by JpaRepository and
// PagingAndSortingRepository , use CrudRepository.



@CrossOrigin(origins = "http://localhost:4200")
@Repository

public interface EmplRep extends JpaRepository<Empl, Long> {

}


