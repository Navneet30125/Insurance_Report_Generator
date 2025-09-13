package com.insurance.policy.runner;

//import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.insurance.policy.entity.CitizenPlan;
import com.insurance.policy.repository.CitizenPlanRepository;

import lombok.RequiredArgsConstructor;

//@Component
//@RequiredArgsConstructor
//public class DataLoader implements ApplicationRunner {
//	
//	private final CitizenPlanRepository cpRepo;
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//
//		 // Sample Cash Plans
//        CitizenPlan c1 = new CitizenPlan();
//        c1.setCitizenName("Ramesh");
//        c1.setGender("Male");
//        c1.setPlanName("Cash");
//        c1.setPlanStatus("Approved");
//        c1.setPlanStartDate(LocalDate.now());
//        c1.setPlanEndDate(LocalDate.now().plusMonths(6));
//        c1.setBenefitAmount(5000.0);
//
//        CitizenPlan c2 = new CitizenPlan();
//        c2.setCitizenName("Suresh");
//        c2.setGender("Male");
//        c2.setPlanName("Cash");
//        c2.setPlanStatus("Denied");
//        c2.setDenialReason("Income too high");

//        CitizenPlan c3 = new CitizenPlan();
//        c3.setCitizenName("Geeta");
//        c3.setGender("Female");
//        c3.setPlanName("Cash");
//        c3.setPlanStatus("Terminated");
//        c3.setPlanStartDate(LocalDate.now().minusMonths(3));
//        c3.setPlanEndDate(LocalDate.now().plusMonths(3));
//        c3.setTerminatedDate(LocalDate.now());
//        c3.setTerminationReason("Job secured");
//
//        // Sample Food Plans
//        CitizenPlan f1 = new CitizenPlan();
//        f1.setCitizenName("Mahesh");
//        f1.setGender("Male");
//        f1.setPlanName("Food");
//        f1.setPlanStatus("Approved");
//        f1.setPlanStartDate(LocalDate.now());
//        f1.setPlanEndDate(LocalDate.now().plusMonths(12));
//        f1.setBenefitAmount(2000.0);
//
//        CitizenPlan f2 = new CitizenPlan();
//        f2.setCitizenName("Neha");
//        f2.setGender("Female");
//        f2.setPlanName("Food");
//        f2.setPlanStatus("Denied");
//        f2.setDenialReason("Already availing another scheme");
//
//        CitizenPlan f3 = new CitizenPlan();
//        f3.setCitizenName("Anil");
//        f3.setGender("Male");
//        f3.setPlanName("Food");
//        f3.setPlanStatus("Terminated");
//        f3.setPlanStartDate(LocalDate.now().minusMonths(5));
//        f3.setPlanEndDate(LocalDate.now().plusMonths(7));
//        f3.setTerminatedDate(LocalDate.now());
//        f3.setTerminationReason("Relocated");
//
//        // Sample Medical Plans
//        CitizenPlan m1 = new CitizenPlan();
//        m1.setCitizenName("Sunita");
//        m1.setGender("Female");
//        m1.setPlanName("Medical");
//        m1.setPlanStatus("Approved");
//        m1.setPlanStartDate(LocalDate.now());
//        m1.setPlanEndDate(LocalDate.now().plusYears(1));
//        m1.setBenefitAmount(10000.0);
//
//        CitizenPlan m2 = new CitizenPlan();
//        m2.setCitizenName("Rajesh");
//        m2.setGender("Male");
//        m2.setPlanName("Medical");
//        m2.setPlanStatus("Denied");
//        m2.setDenialReason("Not eligible under age criteria");
//
//        CitizenPlan m3 = new CitizenPlan();
//        m3.setCitizenName("Kavita");
//        m3.setGender("Female");
//        m3.setPlanName("Medical");
//        m3.setPlanStatus("Terminated");
//        m3.setPlanStartDate(LocalDate.now().minusMonths(8));
//        m3.setPlanEndDate(LocalDate.now().plusMonths(4));
//        m3.setTerminatedDate(LocalDate.now());
//        m3.setTerminationReason("Policy expired");
//        
//        // Save all to DB
//        List<CitizenPlan> plans = Arrays.asList(c1, c2, c3,
//        		                                f1, f2, f3,
//        		                                m1, m2, m3);
//    
//        cpRepo.saveAll(plans);
//		
//		
//	}
//
//}
