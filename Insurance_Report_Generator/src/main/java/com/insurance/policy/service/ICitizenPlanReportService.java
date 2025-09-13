package com.insurance.policy.service;

import java.util.List;

import com.insurance.policy.entity.CitizenPlan;
import com.insurance.policy.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface ICitizenPlanReportService {

	public List<String> getPlanNames();

	public List<String> getPlanStatuss();

	public List<CitizenPlan> search(SearchRequest request);

	public Boolean exportExcel(HttpServletResponse response) throws Exception;

	public Boolean exportPdf(HttpServletResponse response) throws Exception;

}
