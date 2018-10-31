
package com.my.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.my.base.Error;
import com.my.momel.Trade;
import com.my.service.TradeService;

@Controller
@RequestMapping(value = "/trade")
public class TradeController {

	@Resource(name = "tradeService")
	private TradeService tradeService;

	private static Logger logger = LogManager.getLogger(TradeController.class);

	// to trade info page
	@RequestMapping(value = "/toTradeInfo")
	public String toTradeInfoPage(final HttpServletRequest request, final HttpServletResponse response) {
		logger.info("To trade info page!");
		return "trade/tradeInfo";
	}
	
	// to trade info page
		@RequestMapping(value = "/toTradeDetails")
		public String toTradeDetailsPage(final HttpServletRequest request, final HttpServletResponse response) {
			logger.info("To trade details page!");
			List<Trade> trades = null;
			trades = tradeService.getAllTrades();	
			
			request.setAttribute("trades", trades);
			
			return "trade/tradeDetails";
		}

	// to save trade info page
	@RequestMapping(value = "/saveTradeInfo")
	public String saveTrade(Trade trade) {

		logger.info("Save trade to DB: " + trade.toString());
		// save trade
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日 HH:mm:ss");
		trade.setTradeTime(sdf.format(new Date()).toString());
		trade.setTradeComment("");
		tradeService.saveTrade(trade);

		return "trade/tradeInfo";
	}

	// query trade list by condition
	@RequestMapping(value = "/queryTradeList")
	@ResponseBody
	public Map<String, Object> queryTradeList(final HttpServletRequest request, final HttpServletResponse response) {

		logger.info("query trade list by conditon!");

		List<Trade> trades = null;
		String tradeServer = request.getParameter("tradeServer");
		String tradeTime = request.getParameter("tradeTime");
		String tradeMoney = request.getParameter("tradeMoney");
		int firstResult = Integer.parseInt(request.getParameter("firstResult"));
		int maxResults = Integer.parseInt(request.getParameter("maxResults"));
		trades = tradeService.getTradesByCondition(tradeServer, tradeTime, tradeMoney, firstResult, maxResults);
		int pagesNum =tradeService.getPagesNumByCondition(tradeServer, tradeTime, tradeMoney, maxResults);

		Map<String, Object> results = new HashMap<String, Object>();
		results.put("trades", trades);
		results.put("pagesNum", pagesNum);
		
		return results;
	}
	

		@RequestMapping(value = "/restClinet")
		@ResponseBody
		public Map<String, Object> restClinet(@RequestBody Trade trade,@RequestHeader("userType") String  userType) {

			logger.info("TestRestClient"  + trade);
			// save trade
			Map<String, Object> results = new HashMap<String, Object>();
			results.put(Error.S001.getErrorCode(),Error.S001.getErrorMessage());
			results.put("userType", userType);
			results.put("trades",this.tradeService.getAllTrades());	
			
			
			return results;
		}


}
