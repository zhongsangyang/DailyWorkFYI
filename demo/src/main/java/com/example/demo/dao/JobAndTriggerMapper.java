package com.example.demo.dao;

import com.example.demo.entity.JobAndTrigger;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobAndTriggerMapper {
	List<JobAndTrigger> getJobAndTriggerDetails();

}
