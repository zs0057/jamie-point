package com.jamiePoint.jamiepoint.hwpController.user.psinfo;

public class PsInfo {
	private String type;
	private String psID;
	private String detail;
	private String psImage;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPsID() {
		return psID;
	}
	public void setPsID(String psID) {
		this.psID = psID;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Override
	public String toString() {
		return "PsInfo [type=" + type + ", psID=" + psID + ", detail=" + detail + ", psImage=" + psImage + "]";
	}
	public String getPsImage() {
		return stripMIME(psImage);
	}
	public void setPsImage(String psImage) {
		this.psImage = psImage;
	}
	
	public String stripMIME(String base64Image) {
        String[] parts = base64Image.split(",");
        String tmp = base64Image;
        if (parts.length == 2) {
        	tmp = parts[1];
        }
        return tmp;
	}
	
}
