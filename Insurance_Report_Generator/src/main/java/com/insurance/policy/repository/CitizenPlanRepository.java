package com.insurance.policy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insurance.policy.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {

    @Query("SELECT DISTINCT c.planName FROM CitizenPlan c")
    List<String> getPlanName();

    @Query("SELECT DISTINCT c.planStatus FROM CitizenPlan c")
    List<String> getPlanStatus();
}
