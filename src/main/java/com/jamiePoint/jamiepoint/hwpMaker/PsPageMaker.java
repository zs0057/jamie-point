package com.jamiePoint.jamiepoint.hwpMaker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.jamiePoint.jamiepoint.hwpController.user.UserInfoForm;
import com.jamiePoint.jamiepoint.hwpController.user.activity.Activity;
import com.jamiePoint.jamiepoint.hwpController.user.psinfo.PsInfo;
import com.jamiePoint.jamiepoint.hwpMaker.SecondPageMaker.MyControlFilter;
import com.jamiePoint.jamiepoint.hwpMaker.tools.ActImageEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.ActTextEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.LastPageTextEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.PsImageEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.PsTextEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.UserImageEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.secondPageTextEditor;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.objectfinder.ControlFinder;
import kr.dogfoot.hwplib.writer.HWPWriter;

public class PsPageMaker {
	static public void go(UserInfoForm userInfoForm) throws Exception {	
		List<PsInfo> PsInfos = userInfoForm.getPsInfos();
		for(PsInfo act : PsInfos) {
			if(act.getType().equals("프로그래머스 1레벨/2레벨/3레벨 이상")) {
				userInfoForm.setPsChk(true);
			}
			else if(act.getType().equals("백준 Bronze/Silver/Gold/Platinum/Diamond/Ruby")) {
				userInfoForm.setPsChk(true);
			}
	
		}
		
		
		
		if (userInfoForm.getPsChk()) {
			String filename = "basic_hwp" + File.separator + "jamie-point-3.hwp";
			HWPFile hwpFile = HWPReader.fromFile(filename);
	        if (hwpFile != null) {
	            MyControlFilter myFilter = new MyControlFilter();
	            ArrayList<Control> result = ControlFinder.find(hwpFile, myFilter);
	            
	            ControlTable curCtr = (ControlTable) result.get(0);
	            
	            PsImageEditor.PsImageToHwp(curCtr, hwpFile, userInfoForm);
	            PsTextEditor.PsToHwp(curCtr, userInfoForm);
	            
	            String writePath = "test_hwp" + File.separator + "result-jamie-point-PS.hwp";
	            HWPWriter.toFile(hwpFile, writePath);
	        }
		}
		
		
	 
	}
}
