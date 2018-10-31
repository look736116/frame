
package com.my.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.momel.Trade;
import com.my.momel.Weight;
import com.my.service.WeightService;

@Controller
@RequestMapping(value = "/weight")
public class WeightController {

	@Resource(name = "weightService")
	private WeightService weightService;

	private static Logger logger = LogManager.getLogger(WeightController.class);

	// to weight info page
	@RequestMapping(value = "/toWeightDetails")
	public String toWeightDetailsPage(final HttpServletRequest request, final HttpServletResponse response) {
		logger.info("To weight details page!");

		return "weight/weightDetails";
	}
	
	// to add weight info page
		@RequestMapping(value = "/toWeightInfo")
		public String toAddWeightInfoPage(final HttpServletRequest request, final HttpServletResponse response) {
			logger.info("To weight details page!");

			return "weight/weightInfo";
		}

	// query weight info list
	@RequestMapping(value = "/queryWeightList")
	@ResponseBody
	public List<Weight> queryWeightList(final HttpServletRequest request, final HttpServletResponse response) {
		logger.info("Query weight list!");
		
		List<Weight> weights = null;
		String recordName = request.getParameter("recordName");
		if("全部".equals(recordName)){
			weights = weightService.getAllWeightInfo();
		}else{
			weights = weightService.getWeightInfoByName(recordName);
		}

		return weights;
	}
	
	// to save weight info page
	@RequestMapping(value = "/saveWeightInfo")
	public String saveWeight(Weight weight) {

		logger.info("Save weight to DB: " + weight.toString());
		// save trade
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日 HH:mm:ss");
		weight.setRecordTime(sdf.format(new Date()).toString());
		weight.setRecordComment("");
		weightService.saveWightInfo(weight);
		return "weight/weightInfo";
	}

}
