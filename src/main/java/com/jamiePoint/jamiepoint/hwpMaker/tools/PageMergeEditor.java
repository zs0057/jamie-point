package com.jamiePoint.jamiepoint.hwpMaker.tools;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jamiePoint.jamiepoint.hwpController.user.UserInfoForm;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.ParagraphListInterface;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.ControlSectionDefine;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.tool.blankfilemaker.EmptyParagraphAdder;
import kr.dogfoot.hwplib.tool.paragraphadder.ParagraphAdder;
import kr.dogfoot.hwplib.writer.HWPWriter;

public class PageMergeEditor {
	
	public static void go(UserInfoForm userInfoForm) throws Exception {
		PageMergeEditor ex = new PageMergeEditor();
	
		ex.cloneSection(userInfoForm);
		String writePath = "test_hwp" + File.separator + "result-jamie-point-merge.hwp";
		HWPFile hwpFile = HWPReader.fromFile(writePath);
		
		
	    HWPWriter.toFile(hwpFile, writePath);
	}

	private HWPFile hwpFile;
	
	public void hwpMerge(String writePath1, String writePath2) {
		try {
			
			int sectionSize = 0;
			
			// 기준 파일
			this.hwpFile = HWPReader.fromFile(writePath1);
			
			HWPFile cloneFile = HWPReader.fromFile(writePath2);
			int cloneSectionSize = cloneFile.getBodyText().getSectionList().size();
		
			
			for(int section=0; section<cloneSectionSize; section++) {
				
				// 섹션 복사
				Section cloneSection = cloneFile.getBodyText().getSectionList().get(section).clone();
				Section newSection = hwpFile.getBodyText().addNewSection();
				
				// 통합 템플릿 섹션 추가
				EmptyParagraphAdder.add(newSection);

				// 새로운 섹션에 대한 여백 설정
				ControlSectionDefine csdClone = (ControlSectionDefine) cloneSection.getParagraph(0).getControlList().get(0);
				ControlSectionDefine csdNew = (ControlSectionDefine) newSection.getParagraph(0).getControlList().get(0);
				
				csdNew.getPageDef().setTopMargin(csdClone.getPageDef().getTopMargin());
				

				csdNew.getPageDef().setTopMargin(10);
				
				csdNew.getPageDef().setBottomMargin(csdClone.getPageDef().getBottomMargin());
				csdNew.getPageDef().setLeftMargin(csdClone.getPageDef().getLeftMargin());
				csdNew.getPageDef().setRightMargin(csdClone.getPageDef().getRightMargin());
				csdNew.getPageDef().setHeaderMargin(csdClone.getPageDef().getHeaderMargin());
				csdNew.getPageDef().setFooterMargin(csdClone.getPageDef().getFooterMargin());
				csdNew.getPageDef().setGutterMargin(csdClone.getPageDef().getGutterMargin());
				
				
				csdNew.getPageDef().getProperty().setPaperDirection(csdClone.getPageDef().getProperty().getPaperDirection());
				
				sectionSize = hwpFile.getBodyText().getSectionList().size();
				ParagraphListInterface targetSection = hwpFile.getBodyText().getSectionList().get(sectionSize - 1);
				
				int paraSize = cloneFile.getBodyText().getSectionList().get(section).getParagraphCount();

				for(int i=0; i<paraSize; i++) {
					Paragraph para = cloneFile.getBodyText().getSectionList().get(section).getParagraph(i);
					ParagraphAdder paraAdder = new ParagraphAdder (hwpFile, targetSection);
					
					paraAdder.add(cloneFile, para);
				}
				
			}
			
			String writePath = "test_hwp" + File.separator + "result-jamie-point-merge.hwp";
		    HWPWriter.toFile(hwpFile, writePath);
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void cloneSection(UserInfoForm userInfoForm) {
		
		try {
			
			
			
			String writePath1 = "test_hwp" + File.separator + "result-jamie-point-1.hwp";
			String writePath2 = "test_hwp" + File.separator + "result-jamie-point-2.hwp";
			String standardPath = "test_hwp" + File.separator + "result-jamie-point-merge.hwp";
			String writePathPs = "test_hwp" + File.separator + "result-jamie-point-PS.hwp";
			String writePathLast = "test_hwp" + File.separator + "result-jamie-point-last.hwp";
			String writePathUser = "test_hwp" + File.separator + "result-jamie-point-userImage.hwp";
			
			
			hwpMerge(writePath1, writePath2);
			
			if(userInfoForm.getPsChk()) {
				hwpMerge(standardPath, writePathPs);
			}
			
			int actPages = (userInfoForm.getNumAcitivties() + 1)/2;
			for (int pageNum = 0; pageNum < actPages; pageNum++) {
				String actPath = "test_hwp" + File.separator + "result-jamie-point-act-" + pageNum + ".hwp";
				hwpMerge(standardPath, actPath);
			}
			
			hwpMerge(standardPath, writePathUser);
			hwpMerge(standardPath, writePathLast);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		return ;
		
	}
	
}
