package com.task.api.repository;

import com.task.api.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.*;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>, QuerydslPredicateExecutor<Report>
{

}
