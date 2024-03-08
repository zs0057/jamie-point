package com.jamiePoint.jamiepoint.hwpMaker;

import java.io.File;
import java.util.ArrayList;

import com.jamiePoint.jamiepoint.hwpController.user.UserInfoForm;
import com.jamiePoint.jamiepoint.hwpMaker.tools.firstPageTextEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.fistPageImageEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.secondPageTextEditor;

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

public class SecondPageMaker {

	static public void go(UserInfoForm userInfoForm) throws Exception {	
		String filename = "basic_hwp" + File.separator + "jamie-point-2.hwp";
		HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            MyControlFilter myFilter = new MyControlFilter();
            ArrayList<Control> result = ControlFinder.find(hwpFile, myFilter);
            
            ControlTable curCtr = (ControlTable) result.get(0);
            
            // 2페이지 ID 삽입 
            secondPageTextEditor.idToHwp(curCtr, userInfoForm.getStudentNumber());
            
            // 2페이지 성명 삽입
            secondPageTextEditor.nameToHwp(curCtr, userInfoForm.getName());
            
            // 2페이지 첫번째 프로젝트 내용 삽입
            secondPageTextEditor.programDetailToHwp(curCtr, userInfoForm);
            
            // 2페이지 전체 포인트 삽입
            secondPageTextEditor.totalPointToHwp(curCtr, userInfoForm.getTotalPoint());
            
            
            String writePath = "test_hwp" + File.separator + "result-jamie-point-2.hwp";
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
