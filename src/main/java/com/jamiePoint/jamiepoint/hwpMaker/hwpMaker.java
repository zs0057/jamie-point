package com.jamiePoint.jamiepoint.hwpMaker;

import java.io.File;
import java.util.ArrayList;

import com.jamiePoint.jamiepoint.hwpMaker.tools.fistPageImageEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.secondPageTextEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.thirdPageImageEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.thirdPageTextEditor;
import com.jamiePoint.jamiepoint.hwpController.user.UserInfoForm;
import com.jamiePoint.jamiepoint.hwpMaker.tools.LastPageTextEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.firstPageTextEditor;

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


public class hwpMaker {
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

    public static void main(String[] args) throws Exception {
        String filename = "basic_hwp" + File.separator + "jamie-point-1.hwp";

        HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            MyControlFilter myFilter = new MyControlFilter();
            ArrayList<Control> result = ControlFinder.find(hwpFile, myFilter);
            
            ControlTable curCtr = (ControlTable) result.get(0);
            
            // 1페이지 ID 입력
            firstPageTextEditor.idToHwp(curCtr, "201918298");
            
            // 1페이지 학과 입력
            firstPageTextEditor.majorToHwp(curCtr, "컴퓨터공학부");
            
            // 1페이지 학년 입력
            firstPageTextEditor.gradeToHwp(curCtr, "3");
           
            // 1페이지 이름 입력 
            firstPageTextEditor.nameToHwp(curCtr, "김지성");
            
            // 1페이지 전화번호 입력 
            firstPageTextEditor.phoneToHwp(curCtr, "010-5485-4823");
            
            // 1페이지 이메일 입력
            firstPageTextEditor.emailToHwp(curCtr, "soss0527@naver.com");
            
            // 1페이지 은행명 입력
            firstPageTextEditor.bankNameToHwp(curCtr, "KB국민");
            
            // 1페이지 계좌 입력
            firstPageTextEditor.bankNumberToHwp(curCtr, "477001-04-135790");

            // 1페이지 첫번째 섹션 포인트 입력  
            firstPageTextEditor.firstSectionPointToHwp(curCtr, "165");
            
            // 1페이지 두번째 섹션 포인트 입력
            firstPageTextEditor.secondSectionPointToHwp(curCtr, "15");
            
            // 1페이지 세번째 섹션 포인트 입력
            firstPageTextEditor.thirdSectionPointToHwp(curCtr, "20");
            
            // 1페이지 네번째 섹션 포인트 입력
            firstPageTextEditor.forthSectionPointToHwp(curCtr, "25");
            
            // 1페이지 전체 섹션 포인트 입력
            firstPageTextEditor.totalSectionPointToHwp(curCtr, "225");
            
            // 1페이지 총 수상 수 입력
            firstPageTextEditor.prizeNumToHwp(curCtr, "1");
            
            // 1페이지 년 월 일 입력
            firstPageTextEditor.YearToHwp(curCtr);
            
            // 1페이지 싸인 이미지 삽입 
//            fistPageImageEditor.signToHwp(curCtr, hwpFile, userInfoForm);
            
        }
        String filename2 = "basic_hwp" + File.separator + "jamie-point-2.hwp";
        
        HWPFile hwpFile2 = HWPReader.fromFile(filename2);
        if (hwpFile != null) {
            MyControlFilter myFilter = new MyControlFilter();
            ArrayList<Control> result = ControlFinder.find(hwpFile2, myFilter);
            
            ControlTable curCtr2 = (ControlTable) result.get(0);
            
            // 2페이지 ID 삽입 
            secondPageTextEditor.idToHwp(curCtr2, "201918298");
            
            // 2페이지 성명 삽입
            secondPageTextEditor.nameToHwp(curCtr2, "김지성");
            
//            // 2페이지 첫번째 프로젝트 내용 삽입
//            secondPageTextEditor.programDetailToHwp(curCtr2, "1", "코딩 문제풀이", "백준 Gold1 -> Platinum5", "백준", "2023.09.01", "30");
//            
//            // 2페이지 첫번째 프로젝트 내용 삽입
//            secondPageTextEditor.programDetailToHwp2(curCtr2, "2", "SW 인턴십", "국내 SW기업 인턴십 15주", "구름", "2023.09.01", "90");
        }
        
        String filename3 = "basic_hwp" + File.separator + "jamie-point-last.hwp";
        
        HWPFile hwpFile3 = HWPReader.fromFile(filename3);
        if (hwpFile != null) {
            MyControlFilter myFilter = new MyControlFilter();
            ArrayList<Control> result = ControlFinder.find(hwpFile3, myFilter);
            
            ControlTable curCtr3 = (ControlTable) result.get(0);
            
//            // 3페이지 백준 ID 삽입 
//            thirdPageTextEditor.bojIdToHwp(curCtr3, "zszszszs");
//            
//            // 3페이지 백준레벨 삽입
//            thirdPageTextEditor.bojLevelToHwp(curCtr3, "Platinum5");
//            
//            // 3페이지 프로그래머스 ID 삽입 
//            thirdPageTextEditor.proIdToHwp(curCtr3, "soss0527");
//            
//            // 3페이지 프로그래머스 레벨 삽입
//            thirdPageTextEditor.proLevelToHwp(curCtr3, "level3");
//            
//            // 3페이지 백준 이미지 삽입 
//            thirdPageImageEditor.bojImageToHwp(curCtr3, hwpFile3);
            
//            // 3페이지 프로그래머스 이미지 삽입 
//            thirdPageImageEditor.bojImageToHwp(curCtr, hwp3File);
            
            LastPageTextEditor.DateToHwp(curCtr3);
            LastPageTextEditor.NameToHwp(curCtr3, "김지성");
        }


//        String writePath = "basic_hwp" + File.separator + "result-jamie-point.hwp";
//        String writePath2 = "basic_hwp" + File.separator + "result-jamie-point2.hwp";
        String writePath3 = "basic_hwp" + File.separator + "result-jamie-point-last.hwp";
        
//        
//        HWPWriter.toFile(hwpFile, writePath);
//        HWPWriter.toFile(hwpFile2, writePath2);
        HWPWriter.toFile(hwpFile3, writePath3);
        
        System.out.println("The file ressult-jamie-point.hwp Clear!");
        System.out.println("ok Jamie sir! Let's go!");

    }
    
}