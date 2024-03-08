package com.jamiePoint.jamiepoint.hwpMaker.tools;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.jamiePoint.jamiepoint.hwpController.user.UserInfoForm;
import com.jamiePoint.jamiepoint.hwpController.user.activity.Activity;

import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;

public class secondPageTextEditor {
	public static void idToHwp(ControlTable curCtr, String id) {
		Row firstRow = curCtr.getRowList().get(2);
        Cell firstCell = firstRow.getCellList().get(1);

        try {
			firstCell.getParagraphList().getParagraph(0).getText().insertString(0, id);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void nameToHwp(ControlTable curCtr, String name) {
		Row firstRow = curCtr.getRowList().get(2);
        Cell firstCell = firstRow.getCellList().get(3);

        try {
			firstCell.getParagraphList().getParagraph(0).getText().insertString(0, name);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void programDetailToHwp(ControlTable curCtr, UserInfoForm userInfoForm) {
		List<Activity> acts = userInfoForm.getActivities();
		for (int i = 0; i < acts.size(); i++) {
			Activity curAct = acts.get(i); 

			programDetail(curCtr, 
					curAct.getPageType(),
					curAct.getProgram(), 
					curAct.getDetail(), 
					curAct.getAgency(), 
					curAct.getDate(), 
					String.valueOf(curAct.getPoint()), 
					i);
		
			
		}
	}
	
	public static void programDetail(ControlTable curCtr, String section, String programName, String programDetail,
			String agency, String date, String point, int idx) {
		
		// 섹션 인덱싱
		if(section.equals("SW핵심역량")) {
			section = "1";
		}
		else if(section.equals("SW산학협력·창업역량")) {
			section = "2";
		}
		else if(section.equals("SW가치확산역량")) {
			section = "3";
		}
		else if(section.equals("SW융합역량")) {
			section = "4";
		}
		
		
		Row firstRow = curCtr.getRowList().get(5+idx);
        Cell firstCell = firstRow.getCellList().get(0);

        try {
			firstCell.getParagraphList().getParagraph(0).getText().insertString(0, section);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        Row secondRow = curCtr.getRowList().get(5+idx);
        Cell secondCell = secondRow.getCellList().get(1);

        try {
        	secondCell.getParagraphList().getParagraph(0).getText().insertString(0, programName);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
 
        Row thirdRow = curCtr.getRowList().get(5+idx);
        Cell thirdCell = thirdRow.getCellList().get(2);

        try {
        	thirdCell.getParagraphList().getParagraph(0).getText().insertString(0, programDetail);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        Row fourthRow = curCtr.getRowList().get(5+idx);
        Cell fourthCell = fourthRow.getCellList().get(3);

        try {
        	fourthCell.getParagraphList().getParagraph(0).getText().insertString(0, agency);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        Row fifthRow = curCtr.getRowList().get(5+idx);
        Cell fifthCell = fifthRow.getCellList().get(4);

        try {
        	fifthCell.getParagraphList().getParagraph(0).getText().insertString(0, date);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        Row sixthRow = curCtr.getRowList().get(5+idx);
        Cell sixthCell = sixthRow.getCellList().get(5);

        try {
        	sixthCell.getParagraphList().getParagraph(0).getText().insertString(0, point);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void totalPointToHwp(ControlTable curCtr, String point) {
		Row firstRow = curCtr.getRowList().get(21);
        Cell firstCell = firstRow.getCellList().get(1);

        try {
			firstCell.getParagraphList().getParagraph(0).getText().insertString(0, point);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
		
	
}
