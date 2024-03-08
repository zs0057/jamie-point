package com.jamiePoint.jamiepoint.hwpMaker;

import java.io.File;
import java.util.ArrayList;

import com.jamiePoint.jamiepoint.hwpController.user.UserInfoForm;
import com.jamiePoint.jamiepoint.hwpMaker.tools.firstPageTextEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.fistPageImageEditor;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.ControlType;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.objectfinder.ControlFilter;
import kr.dogfoot.hwplib.tool.objectfinder.ControlFinder;
import kr.dogfoot.hwplib.writer.HWPWriter;

public class FirstPageMaker {

	static public void go(UserInfoForm userInfoForm) throws Exception {	
		String filename = "basic_hwp" + File.separator + "jamie-point-1.hwp";
		HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            MyControlFilter myFilter = new MyControlFilter();
            ArrayList<Control> result = ControlFinder.find(hwpFile, myFilter);
            
            ControlTable curCtr = (ControlTable) result.get(0);
            
            // 1페이지 ID 입력
            firstPageTextEditor.idToHwp(curCtr, userInfoForm.getStudentNumber());
            
            // 1페이지 학과 입력
            firstPageTextEditor.majorToHwp(curCtr, userInfoForm.getMajor());
       
            // 1페이지 학년 입력
            firstPageTextEditor.gradeToHwp(curCtr, userInfoForm.getGrade());
           
            // 1페이지 이름 입력 
            firstPageTextEditor.nameToHwp(curCtr, userInfoForm.getName());
            
            // 1페이지 전화번호 입력 
            firstPageTextEditor.phoneToHwp(curCtr, userInfoForm.getPhoneNumber());
            
            // 1페이지 이메일 입력
            firstPageTextEditor.emailToHwp(curCtr, userInfoForm.getEmail());
            
            // 1페이지 은행명 입력
            firstPageTextEditor.bankNameToHwp(curCtr, userInfoForm.getBankName());
            
            // 1페이지 계좌 입력
            firstPageTextEditor.bankNumberToHwp(curCtr, userInfoForm.getBankAccount());

            // 1페이지 첫번째 섹션 포인트 입력  
            firstPageTextEditor.firstSectionPointToHwp(curCtr, userInfoForm.getSwCoreInfo().getTotalPoint());
            
            // 1페이지 두번째 섹션 포인트 입력
            firstPageTextEditor.secondSectionPointToHwp(curCtr, userInfoForm.getSwCooperationInfo().getTotalPoint());
            
            // 1페이지 세번째 섹션 포인트 입력
            firstPageTextEditor.thirdSectionPointToHwp(curCtr, userInfoForm.getSwValueInfo().getTotalPoint());
            
            // 1페이지 네번째 섹션 포인트 입력
            firstPageTextEditor.forthSectionPointToHwp(curCtr, userInfoForm.getSwConvergenceInfo().getTotalPoint());
            
            // 1페이지 전체 섹션 포인트 입력
            firstPageTextEditor.totalSectionPointToHwp(curCtr, userInfoForm.getTotalPoint());
            
            // 1페이지 총 수상 수 입력
            firstPageTextEditor.prizeNumToHwp(curCtr, userInfoForm.getTotalAwards());
            
            // 1페이지 년 월 일 입력
            firstPageTextEditor.YearToHwp(curCtr);
            
            // 1페이지 싸인 이미지 삽입 
            fistPageImageEditor.signToHwp(curCtr, hwpFile, userInfoForm);
            
            String writePath = "test_hwp" + File.separator + "result-jamie-point-1.hwp";
            HWPWriter.toFile(hwpFile, writePath);
        }
	}
	
	public static class MyControlFilter implements ControlFilter {
        public boolean isMatched(Control control, Paragraph paragrpah,
                                 Section section) {
        	
            if (control.getType() == ControlType.Table) {
                ControlTable table = (ControlTable) control;
                return true;
				
            }
            return false;
        }
    }
	

	
	 
}
