package com.example.epamPoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.epamPoc.entity.DatabaseDetailPK;
import com.example.epamPoc.entity.DatabasesDetail;

public interface DatabaseDetailRepository extends JpaRepository<DatabasesDetail, DatabaseDetailPK> {

}
