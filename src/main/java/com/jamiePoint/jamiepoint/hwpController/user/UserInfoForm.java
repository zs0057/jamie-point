package com.jamiePoint.jamiepoint.hwpController.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import com.jamiePoint.jamiepoint.hwpController.user.activity.Activity;
import com.jamiePoint.jamiepoint.hwpController.user.psinfo.PsInfo;

public class UserInfoForm {
    private String name;
    private String grade;
    private String major;
    private String studentNumber;
    private String phoneNumber;
    private String email;
    private String bankAccount;
    private String bankName;
    private String bankBookImg;
    private String idCardImg;
    private String signImg;
    private List<Activity> activities;
    private SWInfo swCoreInfo;
    private SWInfo swCooperationInfo;
    private SWInfo swValueInfo;
    private SWInfo swConvergenceInfo;
    private String totalAwards;
    private String totalPoint;
    private List<PsInfo> psInfos;
    
    private boolean PsChk;
    private int NumAcitivties;

    

    // Constructor, getters, and setters
    public class SWInfo {
        private String activityCount;
        private String totalPoint;
        
		public String getActivityCount() {
			return activityCount;
		}
		public void setActivityCount(String activityCount) {
			this.activityCount = activityCount;
		}
		public String getTotalPoint() {
			return totalPoint;
		}
		public void setTotalPoint(String totalPoint) {
			this.totalPoint = totalPoint;
		}

		@Override
		public String toString() {
		    return "SWInfo{" +
		            "activityCount=" + activityCount +
		            ", totalPoint=" + totalPoint +
		            '}';
		}

    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBookImg() {
		return stripMIME(bankBookImg);
	}

	public void setBankBookImg(String bankBookImg) {
		this.bankBookImg = bankBookImg;
	}

	public String getIdCardImg() {
		return stripMIME(idCardImg);
	}

	public void setIdCardImg(String idCardImg) {
		this.idCardImg = idCardImg;
	}

	public String getSignImg() {
		return stripMIME(signImg);
	}

	public void setSignImg(String signImg) {
		this.signImg = signImg;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public SWInfo getSwCoreInfo() {
		return swCoreInfo;
	}

	public void setSwCoreInfo(SWInfo swCoreInfo) {
		this.swCoreInfo = swCoreInfo;
	}

	public SWInfo getSwCooperationInfo() {
		return swCooperationInfo;
	}

	public void setSwCooperationInfo(SWInfo swCooperationInfo) {
		this.swCooperationInfo = swCooperationInfo;
	}

	public SWInfo getSwValueInfo() {
		return swValueInfo;
	}

	public void setSwValueInfo(SWInfo swValueInfo) {
		this.swValueInfo = swValueInfo;
	}

	public SWInfo getSwConvergenceInfo() {
		return swConvergenceInfo;
	}

	public void setSwConvergenceInfo(SWInfo swConvergenceInfo) {
		this.swConvergenceInfo = swConvergenceInfo;
	}

	public String getTotalAwards() {
		return totalAwards;
	}

	public void setTotalAwards(String totalAwards) {
		this.totalAwards = totalAwards;
	}

	public String getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(String totalPoint) {
		this.totalPoint = totalPoint;
	}
	
	public boolean getPsChk() {
		return PsChk;
	}
	
	public void setPsChk(boolean PsChk) {
		this.PsChk = PsChk;
	}
	
	
	
	public String stripMIME(String base64Image) {
        String[] parts = base64Image.split(",");
        String tmp = base64Image;
        if (parts.length == 2) {
        	tmp = parts[1];
        }
        return tmp;
	}
	
	public void makeImage(String base64Image, String imgFilePath) {
		 // 파일 경로를 Path 객체로 변환
        Path path = Paths.get(imgFilePath);

        try {
            // 파일 삭제
            Files.delete(path);
            System.out.println("파일이 삭제되었습니다.");
        } catch (IOException e) {
            System.err.println("파일 삭제 중 오류가 발생했습니다: " + e.getMessage());
        }
        
        try {

            // Base64 디코딩
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

            // 이미지 파일로 저장
            
            OutputStream outputStream = new FileOutputStream(imgFilePath);
            outputStream.write(imageBytes);
            outputStream.close();

            System.out.println("이미지가 성공적으로 저장되었습니다.");
        } catch (Exception e) {
            System.out.println("이미지 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
	}
	
	@Override
	public String toString() {
	    return "UserInfoForm{" +
	            "name='" + name + '\'' +
	            ", grade='" + grade + '\'' +
	            ", major='" + major + '\'' +
	            ", studentNumber='" + studentNumber + '\'' +
	            ", phoneNumber='" + phoneNumber + '\'' +
	            ", email='" + email + '\'' +
	            ", bankAccount='" + bankAccount + '\'' +
	            ", bankName='" + bankName + '\'' +
	           // ", bankBookImg='" + bankBookImg + '\'' +
	           // ", idCardImg='" + idCardImg.substring(0, 10)  + '\'' +
	           // ", signImg='" + signImg + '\'' +
	            ", activities=" + activities +
	            ", swCoreInfo=" + swCoreInfo +
	            ", swCooperationInfo=" + swCooperationInfo +
	            ", swValueInfo=" + swValueInfo +
	            ", swConvergenceInfo=" + swConvergenceInfo +
	            ", totalAwards='" + totalAwards + '\'' +
	            ", totalPoint='" + totalPoint + '\'' +
	            ", PsInfos=" + psInfos +
	            '}'
	            ;
	}

	public int getNumAcitivties() {
		return NumAcitivties;
	}

	public void setNumAcitivties(int numAcitivties) {
		NumAcitivties = numAcitivties;
	}

	public List<PsInfo> getPsInfos() {
		return psInfos;
	}

	public void setPsInfos(List<PsInfo> psInfos) {
		this.psInfos = psInfos;
	}

}


