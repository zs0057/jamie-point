package com.jamiePoint.jamiepoint.hwpMaker.tools;

import java.io.UnsupportedEncodingException;

import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;

public class thirdPageTextEditor {
	public static void bojIdToHwp(ControlTable curCtr, String id) {
		Row firstRow = curCtr.getRowList().get(2);
        Cell firstCell = firstRow.getCellList().get(1);

        try {
			firstCell.getParagraphList().getParagraph(0).getText().addString(id);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void bojLevelToHwp(ControlTable curCtr, String name) {
		Row firstRow = curCtr.getRowList().get(2);
        Cell firstCell = firstRow.getCellList().get(3);

        try {
			firstCell.getParagraphList().getParagraph(0).getText().addString(name);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void proIdToHwp(ControlTable curCtr, String name) {
		Row firstRow = curCtr.getRowList().get(4);
        Cell firstCell = firstRow.getCellList().get(1);

        try {
			firstCell.getParagraphList().getParagraph(0).getText().addString(name);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void proLevelToHwp(ControlTable curCtr, String name) {
		Row firstRow = curCtr.getRowList().get(4);
        Cell firstCell = firstRow.getCellList().get(3);

        try {
			firstCell.getParagraphList().getParagraph(0).getText().addString(name);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
