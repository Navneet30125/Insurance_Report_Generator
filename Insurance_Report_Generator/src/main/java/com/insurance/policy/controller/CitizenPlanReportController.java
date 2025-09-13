package com.insurance.policy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.insurance.policy.entity.CitizenPlan;
import com.insurance.policy.request.SearchRequest;
import com.insurance.policy.service.ICitizenPlanReportService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CitizenPlanReportController {

	@Autowired
	private ICitizenPlanReportService service;

	@GetMapping("/pdf")
	public String pdfExport(HttpServletResponse response, Model model) throws Exception {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=plans.pdf");
		boolean status = service.exportPdf(response);
		if (status) {
			model.addAttribute("msg", "Excel Repoprt to send to your Gmail");
		}
		model.addAttribute("search", new SearchRequest());
		init(model);
//		return "index";
		return "view";
	}

	@GetMapping("/excel")
	public String excelExport(HttpServletResponse response, Model model) throws Exception {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=plans.xls");
		boolean status = service.exportExcel(response);
		if (status) {
			model.addAttribute("msg", "Pdf Repoprt to send to your Gmail");
		}
		model.addAttribute("search", new SearchRequest());
		init(model);
		//return "index";
		return "view";
	}

	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest search, Model model) {
//		System.out.println(search);/
		List<CitizenPlan> plans = service.search(search);
		model.addAttribute("plans", plans);
		init(model);
//		return "index";
		return "view";
	}

	@GetMapping("/")
	public String getIndexPage(Model model) {
		model.addAttribute("search", new SearchRequest());
		init(model);
//		return "index";
		return "view";
	}

	private void init(Model model) {
//		model.addAttribute("search", new SearchRequest());
		model.addAttribute("names", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatuss());
	}
}
