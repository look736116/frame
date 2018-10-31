package com.my.momel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_weight")
public class Weight {
	
	@Id
	@Column(name="Record_Id")
	private int recordId;
	
	@Column(name="Record_Name")
	private String recordName;
	
	@Column(name="Record_weigth")
	private double recordWeigth;	
	
	
	@Column(name="Record_Time")
	private String recordTime;
	
	@Column(name="Record_Comment")
	private String recordComment;	

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getRecordName() {
		return recordName;
	}

	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}	

	public double getRecordWeigth() {
		return recordWeigth;
	}

	public void setRecordWeigth(double recordWeigth) {
		this.recordWeigth = recordWeigth;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	public String getRecordComment() {
		return recordComment;
	}

	public void setRecordComment(String recordComment) {
		this.recordComment = recordComment;
	}

	@Override
	public String toString() {
		return "Weight [recordId=" + recordId + ", recordName=" + recordName + ", recordWeigth=" + recordWeigth
				+ ", recordTime=" + recordTime + ", recordComment=" + recordComment + "]";
	}

	
	

}
