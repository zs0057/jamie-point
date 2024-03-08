package com.jamiePoint.jamiepoint.hwpMaker;

import java.io.File;
import java.util.ArrayList;

import com.jamiePoint.jamiepoint.hwpController.user.UserInfoForm;
import com.jamiePoint.jamiepoint.hwpMaker.SecondPageMaker.MyControlFilter;
import com.jamiePoint.jamiepoint.hwpMaker.tools.LastPageTextEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.UserImageEditor;
import com.jamiePoint.jamiepoint.hwpMaker.tools.secondPageTextEditor;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.Control;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.objectfinder.ControlFinder;
import kr.dogfoot.hwplib.writer.HWPWriter;

public class IDAndBankPageMaker {
	static public void go(UserInfoForm userInfoForm) throws Exception {	
		String filename = "basic_hwp" + File.separator + "jamie-point-6.hwp";
		HWPFile hwpFile = HWPReader.fromFile(filename);
        if (hwpFile != null) {
            MyControlFilter myFilter = new MyControlFilter();
            ArrayList<Control> result = ControlFinder.find(hwpFile, myFilter);
            
            ControlTable curCtr = (ControlTable) result.get(0);
            
            UserImageEditor.UserImageToHwp(curCtr, hwpFile, userInfoForm);
            

            
            String writePath = "test_hwp" + File.separator + "result-jamie-point-userImage.hwp";
            HWPWriter.toFile(hwpFile, writePath);
        }
	}
}
