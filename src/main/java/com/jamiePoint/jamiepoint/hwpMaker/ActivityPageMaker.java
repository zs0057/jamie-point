package com.jamiePoint.jamiepoint.hwpMaker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.jamiePoint.jamiepoint.hwpController.user.UserInfoForm;
import com.jamiePoint.jamiepoint.hwpController.user.activity.Activity;
import com.jamiePoint.jamiepoint.hwpMaker.SecondPageMaker.MyControlFilter;
import com.jamiePoint.jamiepoint.hwpMaker.tools.ActImageEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.ActTextEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.LastPageTextEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.PsImageEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.UserImageEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.secondPageTextEditor;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.objectfinder.ControlFinder;
import kr.dogfoot.hwplib.writer.HWPWriter;

public class ActivityPageMaker {
	static public void go(UserInfoForm userInfoForm) throws Exception {	
		List<Activity> Activities = userInfoForm.getActivities();
		  List<Integer> ImgIdxes = new ArrayList<>(); 
		int imgIdx = 0;
		for(Activity act : Activities) {
			if(act.getType().equals("프로그래머스 1레벨/2레벨/3레벨 이상")) {
				userInfoForm.setPsChk(true);
			}
			else if(act.getType().equals("백준 Bronze/Silver/Gold/Platinum/Diamond/Ruby")) {
				userInfoForm.setPsChk(true);
			}
			else {
				if(!act.getActivityImg().equals("")) {
					ImgIdxes.add(imgIdx);
				}
			}
			imgIdx++;
		}
		
		
		
//		if (userInfoForm.getPsChk()) {
//			String filename = "basic_hwp" + File.separator + "jamie-point-3.hwp";
//			HWPFile hwpFile = HWPReader.fromFile(filename);
//	        if (hwpFile != null) {
//	            MyControlFilter myFilter = new MyControlFilter();
//	            ArrayList<Control> result = ControlFinder.find(hwpFile, myFilter);
//	            
//	            ControlTable curCtr = (ControlTable) result.get(0);
//	            
//	            PsImageEditor.PsImageToHwp(curCtr, hwpFile, userInfoForm);
//	            
//	            
//	            String writePath = "test_hwp" + File.separator + "result-jamie-point-PS.hwp";
//	            HWPWriter.toFile(hwpFile, writePath);
//	        }
//		}
		
		userInfoForm.setNumAcitivties(ImgIdxes.size());
		
		for (int i = 0; i < (ImgIdxes.size() + 1 ) / 2; i++) {
			String filename = "basic_hwp" + File.separator + "jamie-point-4.hwp";
			HWPFile hwpFile = HWPReader.fromFile(filename);
	        if (hwpFile != null) {
	            MyControlFilter myFilter = new MyControlFilter();
	            ArrayList<Control> result = ControlFinder.find(hwpFile, myFilter);
	            
	            ControlTable curCtr = (ControlTable) result.get(0);
	            
	            int firstIdx = ImgIdxes.get(i*2);
	            int secondIdx;
	            if(i * 2 + 1 == ImgIdxes.size()) {
	            	secondIdx = -1;
	            }
	            else {
	            	secondIdx = ImgIdxes.get(i*2+1);
	            }
	            
	            ActImageEditor.ActImageToHwp(curCtr, hwpFile, userInfoForm, firstIdx, secondIdx);
	            ActTextEditor.ActTextToHwp(curCtr, hwpFile, userInfoForm, firstIdx, secondIdx);
	            
	            String writePath = "test_hwp" + File.separator + "result-jamie-point-act-" + i + ".hwp";
	            HWPWriter.toFile(hwpFile, writePath);
	        }
		}
		
	}
}
