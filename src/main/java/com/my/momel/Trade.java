package com.my.momel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_trade")
public class Trade {
	
	@Id
	@Column(name="Trade_Id")
	private int tradeId;
	
	@Column(name="Trade_Server")
	private String tradeServer;
	
	@Column(name="Trade_Currency")
	private int tradeCurrency;
	
	@Column(name="Trade_Money")
	private int tradeMoney;
	
	@Column(name="Trade_Time")
	private String tradeTime;
	
	@Column(name="Trade_Comment")
	private String tradeComment;

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	public String getTradeServer() {
		return tradeServer;
	}

	public void setTradeServer(String tradeServer) {
		this.tradeServer = tradeServer;
	}

	public int getTradeCurrency() {
		return tradeCurrency;
	}

	public void setTradeCurrency(int tradeCurrency) {
		this.tradeCurrency = tradeCurrency;
	}

	public int getTradeMoney() {
		return tradeMoney;
	}

	public void setTradeMoney(int tradeMoney) {
		this.tradeMoney = tradeMoney;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getTradeComment() {
		return tradeComment;
	}

	public void setTradeComment(String tradeComment) {
		this.tradeComment = tradeComment;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", tradeServer=" + tradeServer + ", tradeCurrency=" + tradeCurrency
				+ ", tradeMoney=" + tradeMoney + ", tradeTime=" + tradeTime + ", tradeComment=" + tradeComment + "]";
	}	
	

}
