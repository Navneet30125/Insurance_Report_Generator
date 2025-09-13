package com.insurance.policy.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.insurance.policy.entity.CitizenPlan;
import com.insurance.policy.repository.CitizenPlanRepository;
import com.insurance.policy.request.SearchRequest;
import com.insurance.policy.util.EmailUtils;
import com.insurance.policy.util.ExcelGenerator;
import com.insurance.policy.util.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class CitizenPlanReportServiceImpl implements ICitizenPlanReportService {
	@Autowired
	public CitizenPlanRepository plansRepo;
	@Autowired
	public ExcelGenerator Excel;
	@Autowired
	public PdfGenerator pdf;
	@Autowired
	public EmailUtils mailSender;

	@Override
	public List<String> getPlanNames() {
		return plansRepo.getPlanName();
	}

	@Override
	public List<String> getPlanStatuss() {
		return plansRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();

		if (request.getPlanName() != null && !request.getPlanName().isEmpty()) {
			entity.setPlanName(request.getPlanName());
		}
		if (request.getPlanStatus() != null && !request.getPlanStatus().isEmpty()) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (request.getGender() != null && !request.getGender().isEmpty()) {
			entity.setGender(request.getGender());
		}

		if (request.getStartDate() != null && !"".equals(request.getStartDate())) {
			entity.setPlanStartDate(request.getStartDate());
		}
		if (request.getEndDate() != null && !"".equals(request.getEndDate())) {
			entity.setPlanEndDate(request.getEndDate());
		}

		return plansRepo.findAll(Example.of(entity));
	}

	@Override
	public Boolean exportExcel(HttpServletResponse response) throws Exception {
		File f = new File("plans.xls");
		List<CitizenPlan> plans = plansRepo.findAll();
		Excel.generate(response, plans, f);
		String subject = "Insurance Report";
		String body = "<h1>Mail From Sbi.insurance.com</h1>";
		String to = "rajpootnavneet62@gmail.com";
		mailSender.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}

	@Override
	public Boolean exportPdf(HttpServletResponse response) throws Exception {
		File f = new File("plans.pdf");
		List<CitizenPlan> records = plansRepo.findAll();
		pdf.generate(response, records, f);
		String subject = "Insurance Report";
		String body = "<h1>Mail From Sbi.insurance.com</h1>";
		String to = "rajpootnavneet62@gmail.com";
		mailSender.sendEmail(subject, body, to, f);
		f.delete();
		return true;
	}

}
