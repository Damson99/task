package com.task;

import com.task.api.model.Report;
import com.task.api.service.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TaskApplicationTests
{

	@Autowired
	private ReportService reportService;

	@Test
	void contextLoads()
	{
		Report report = new Report.ReportBuilder()
				.setFilm_name("STAR WARS")
				.setCharacter_name("Grievous")
				.setPlanet_name("EARTH").build();

		Report report1 = new Report.ReportBuilder()
				.setFilm_name("WORLD WAR")
				.setCharacter_name("LUKE")
				.setPlanet_name("Jupiter").build();
		List<Report> reportList = new ArrayList<>();
		reportList.add(report);
		reportList.add(report1);


		reportService.saveReports(reportList);

		Report savedReport1 = reportService.saveReport(report1);
		savedReport1.setFilm_name("FILM NAME");
		reportService.saveReport(savedReport1);
	}

}
