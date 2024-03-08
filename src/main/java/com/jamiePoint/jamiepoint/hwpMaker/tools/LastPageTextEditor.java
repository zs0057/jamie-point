package com.jamiePoint.jamiepoint.hwpMaker.tools;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;

public class LastPageTextEditor {
	public static void DateToHwp(ControlTable curCtr) {
		LocalDate today = LocalDate.now();
        String year = String.valueOf(today.getYear());
        String month = String.valueOf(today.getMonthValue());
        String day = String.valueOf(today.getDayOfMonth());
        
		Row firstRow = curCtr.getRowList().get(5);
        Cell firstCell = firstRow.getCellList().get(1);

        try {
			firstCell.getParagraphList().getParagraph(0).getText().insertString(0, year);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        Row secondRow = curCtr.getRowList().get(5);
        Cell secondCell = secondRow.getCellList().get(3);

        try {
        	secondCell.getParagraphList().getParagraph(0).getText().insertString(0, month);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        Row thirdRow = curCtr.getRowList().get(5);
        Cell thirdCell = thirdRow.getCellList().get(5);

        try {
        	thirdCell.getParagraphList().getParagraph(0).getText().insertString(0, day);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void NameToHwp(ControlTable curCtr, String name) {

		Row firstRow = curCtr.getRowList().get(6);
        Cell firstCell = firstRow.getCellList().get(2);

        try {
			firstCell.getParagraphList().getParagraph(0).getText().insertString(0, name);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

    
	}
	
}
