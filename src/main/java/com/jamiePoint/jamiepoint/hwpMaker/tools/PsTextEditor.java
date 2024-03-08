package com.jamiePoint.jamiepoint.hwpMaker.tools;



import java.io.File;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;

import com.jamiePoint.jamiepoint.hwpController.user.UserInfoForm;
import com.jamiePoint.jamiepoint.hwpController.user.psinfo.PsInfo;

import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;

public class PsTextEditor {
	public static void PsToHwp(ControlTable curCtr, UserInfoForm userInfoForm) {
		
		List<PsInfo> PsInfos = userInfoForm.getPsInfos();
		
		for(PsInfo act : PsInfos) {
			if(act.getType().equals("백준 Bronze/Silver/Gold/Platinum/Diamond/Ruby")){

				 Row seventhRow = curCtr.getRowList().get(2);
			     Cell seventhCell = seventhRow.getCellList().get(1);
			     
			     try {
			    	 seventhCell.getParagraphList().getParagraph(0).getText().insertString(0, act.getPsID());
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
			    
			     Row eightRow = curCtr.getRowList().get(2);
			     Cell eightCell = eightRow.getCellList().get(3);
			     
			     try {
			    	 eightCell.getParagraphList().getParagraph(0).getText().insertString(0, act.getDetail());
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

			}
			if(act.getType().equals("프로그래머스 1레벨/2레벨/3레벨")) {
				 Row seventhRow = curCtr.getRowList().get(4);
			     Cell seventhCell = seventhRow.getCellList().get(1);
			     
			     try {
			    	 seventhCell.getParagraphList().getParagraph(0).getText().insertString(0, act.getPsID());
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
			    
			     Row eightRow = curCtr.getRowList().get(4);
			     Cell eightCell = eightRow.getCellList().get(3);
			     
			     try {
			    	 eightCell.getParagraphList().getParagraph(0).getText().insertString(0, act.getDetail());
						
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

			}
		}
		
	}
	
}
