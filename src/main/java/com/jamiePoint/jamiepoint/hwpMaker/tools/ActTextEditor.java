package com.jamiePoint.jamiepoint.hwpMaker.tools;

import java.io.UnsupportedEncodingException;

import com.jamiePoint.jamiepoint.hwpController.user.UserInfoForm;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;

public class ActTextEditor {

	public static void ActTextToHwp(ControlTable curCtr, HWPFile hwpFile, UserInfoForm userInfoForm, int firstIdx,
			int secondIdx) {
		
		Row firstRow = curCtr.getRowList().get(2);
        Cell firstCell = firstRow.getCellList().get(1);

        try {
			firstCell.getParagraphList().getParagraph(0).getText().insertString(0, userInfoForm.getActivities()
					.get(firstIdx).getDetail());
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        
        Row secondRow = curCtr.getRowList().get(2);
        Cell secondCell = secondRow.getCellList().get(3);

        try {
        	secondCell.getParagraphList().getParagraph(0).getText().insertString(0, userInfoForm.getActivities()
					.get(firstIdx).getAgency());
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        if(secondIdx != -1) {
        	Row thirdRow = curCtr.getRowList().get(4);
            Cell thirdCell = thirdRow.getCellList().get(1);

            try {
            	thirdCell.getParagraphList().getParagraph(0).getText().insertString(0, userInfoForm.getActivities()
    					.get(secondIdx).getDetail());
    			
    		} catch (UnsupportedEncodingException e) {
    			e.printStackTrace();
    		}
            
            
            Row forthRow = curCtr.getRowList().get(4);
            Cell forthCell = forthRow.getCellList().get(3);

            try {
            	forthCell.getParagraphList().getParagraph(0).getText().insertString(0, userInfoForm.getActivities()
    					.get(secondIdx).getAgency());
    			
    		} catch (UnsupportedEncodingException e) {
    			e.printStackTrace();
    		}
            
        }
		
	}

}
