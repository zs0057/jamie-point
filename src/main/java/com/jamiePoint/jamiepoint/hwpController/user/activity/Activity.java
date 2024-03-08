package com.jamiePoint.jamiepoint.hwpController.user.activity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class Activity {
    private String id;
    private String pageType;
    private String activityImg;
    private String program;
    private String type;
    private String topic;
    private int point;
    private String agency;
    private String date;
    private String detail;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public String getActivityImg() {
		return stripMIME(activityImg);
	}
	public void setActivityImg(String activityImg) {
		this.activityImg = activityImg;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String stripMIME(String base64Image) {
        String[] parts = base64Image.split(",");
        String tmp = base64Image;
        if (parts.length == 2) {
        	tmp = parts[1];
        }
        return tmp;
	}
	
	
	@Override
	public String toString() {
		return "Activity [id=" + id + ", pageType=" + pageType + ", activityImg=" + activityImg + ", program=" + program
				+ ", type=" + type + ", topic=" + topic + ", point=" + point + ", agency=" + agency + ", date=" + date
				+ ", detail=" + detail + "]";
	}

}
