package com.example.myrok.repository;

import com.example.myrok.domain.Project;
import com.example.myrok.domain.Record;
import com.example.myrok.repository.search.RecordSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>, RecordSearch {


    List<Record> findAllByProjectId(@Param("projectId") Long projectId);

    @Query("SELECT r FROM Record r WHERE r.project.id = :projectId")
    Page<Object> selectList(Pageable Pageablepageable, @Param("projectId") Long projectId);
}
