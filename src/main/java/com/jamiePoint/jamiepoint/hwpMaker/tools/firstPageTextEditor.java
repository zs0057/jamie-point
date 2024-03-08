package com.jamiePoint.jamiepoint.hwpMaker.tools;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;

public class firstPageTextEditor {
	
	// 1페이지 ID 입력 
	public static void idToHwp(ControlTable curCtr, String id) {
		Row firstRow = curCtr.getRowList().get(0);
        Cell firstCell = firstRow.getCellList().get(1);

        try {
			firstCell.getParagraphList().getParagraph(0).getText().insertString(0, id);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	// 1페이지 학과 입력 
	public static void majorToHwp(ControlTable curCtr, String major) {
		Row secondRow = curCtr.getRowList().get(2);
        Cell secondCell = secondRow.getCellList().get(0);

        try {
			secondCell.getParagraphList().getParagraph(0).getText().insertString(0, major);;
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	// 1페이지 학년 입력 
	public static void gradeToHwp(ControlTable curCtr, String grade) {
		 Row thirdRow = curCtr.getRowList().get(2);
         Cell thirdCell = thirdRow.getCellList().get(1);

         try {
				thirdCell.getParagraphList().getParagraph(0).getText().insertString(0, grade);
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	}
	
	// 1페이지 이름 입력 
	public static void nameToHwp(ControlTable curCtr, String name) {
		Row forthRow = curCtr.getRowList().get(2);
        Cell forthCell = forthRow.getCellList().get(2);

        try {
			forthCell.getParagraphList().getParagraph(0).getText().insertString(0, name);

			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        

        Row eighteenthRow = curCtr.getRowList().get(19);
        Cell eighteenthCell = eighteenthRow.getCellList().get(3);

        try {
        	eighteenthCell.getParagraphList().getParagraph(0).getText().insertString(0, name);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	// 1페이지 전화번호 입력
	public static void phoneToHwp(ControlTable curCtr, String phone) {
		 Row fifthRow = curCtr.getRowList().get(2);
         Cell fifthCell = fifthRow.getCellList().get(4);

         try {
				fifthCell.getParagraphList().getParagraph(0).getText().insertString(0, phone);;
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
	}
	
	// 1페이지 이메일 입력 
	public static void emailToHwp(ControlTable curCtr, String email) {
		Row sixthRow = curCtr.getRowList().get(3);
        Cell sixthCell = sixthRow.getCellList().get(1);

        try {
			sixthCell.getParagraphList().getParagraph(0).getText().insertString(0, email);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	// 1페이지 은행명 입력 
	public static void bankNameToHwp(ControlTable curCtr,  String bankName) {
		Row seventhRow = curCtr.getRowList().get(5);
		Cell sevnenthCell = seventhRow.getCellList().get(2);

		try {
			sevnenthCell.getParagraphList().getParagraph(0).getText().insertString(0, bankName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	// 1페이지 계좌번호 입력 
	public static void bankNumberToHwp(ControlTable curCtr, String string) {
		   Row eighthRow = curCtr.getRowList().get(6);
           Cell eighthCell = eighthRow.getCellList().get(1);

           try {
   			eighthCell.getParagraphList().getParagraph(0).getText().insertString(0, string);
   			
   		} catch (UnsupportedEncodingException e) {
   			e.printStackTrace();
   		}
		
	}

	// 1페이지 첫번째 섹션 포인트 입력 
	public static void firstSectionPointToHwp(ControlTable curCtr, String string) {
		 Row ninthRow = curCtr.getRowList().get(10);
         Cell ninthCell = ninthRow.getCellList().get(1);

         try {
 			ninthCell.getParagraphList().getParagraph(0).getText().insertString(0, string);
 			
 		} catch (UnsupportedEncodingException e) {
 			e.printStackTrace();
 		}
		
	}

	// 1페이지 두번째 섹션 포인트 입력
	public static void secondSectionPointToHwp(ControlTable curCtr, String string) {
		 Row tenthRow = curCtr.getRowList().get(11);
         Cell tenthCell = tenthRow.getCellList().get(1);

         try {
 		tenthCell.getParagraphList().getParagraph(0).getText().insertString(0, string);
 			
 		} catch (UnsupportedEncodingException e) {
 			e.printStackTrace();
 		}
		
	}

	// 1페이지 세번째 섹션 포인트 입력
	public static void thirdSectionPointToHwp(ControlTable curCtr, String string) {
		 Row eleventhRow = curCtr.getRowList().get(12);
         Cell eleventhCell = eleventhRow.getCellList().get(1);

         try {
         	eleventhCell.getParagraphList().getParagraph(0).getText().insertString(0, string);
 			
 		} catch (UnsupportedEncodingException e) {
 			e.printStackTrace();
 		}
         
		
	}

	// 1페이지 네번째 섹션 포인트 입력
	public static void forthSectionPointToHwp(ControlTable curCtr, String string) {
		 Row twelvethRow = curCtr.getRowList().get(13);
         Cell twelvethCell = twelvethRow.getCellList().get(1);

         try {
         	twelvethCell.getParagraphList().getParagraph(0).getText().insertString(0, string);
 			
 		} catch (UnsupportedEncodingException e) {
 			e.printStackTrace();
 		}
		
	}

	// 1페이지 전체 섹션 포인트 입력
	public static void totalSectionPointToHwp(ControlTable curCtr, String string) {
		  Row thirteenthRow = curCtr.getRowList().get(14);
          Cell thirteenthCell = thirteenthRow.getCellList().get(1);

          try {
          	thirteenthCell.getParagraphList().getParagraph(0).getText().insertString(0, string);
  			
  		} catch (UnsupportedEncodingException e) {
  			e.printStackTrace();
  		}
		
	}

	// 1페이지 총 수상 수 입력
	public static void prizeNumToHwp(ControlTable curCtr, String string) {
		   Row fourteenthRow = curCtr.getRowList().get(16);
           Cell forteenthCell = fourteenthRow.getCellList().get(1);

           try {
           	forteenthCell.getParagraphList().getParagraph(0).getText().insertString(0, string);
   			
   		} catch (UnsupportedEncodingException e) {
   			e.printStackTrace();
   		}
		
	}

	// 1페이지 년 월 일 입력
	public static void YearToHwp(ControlTable curCtr) {
		
		LocalDate today = LocalDate.now();
        String year = String.valueOf(today.getYear());
        String month = String.valueOf(today.getMonthValue());
        String day = String.valueOf(today.getDayOfMonth());
        
	    Row fifteenthRow = curCtr.getRowList().get(18);
        Cell fifteenthCell = fifteenthRow.getCellList().get(1);

        try {
        	fifteenthCell.getParagraphList().getParagraph(0).getText().insertString(0, year);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        Row sixteenthRow = curCtr.getRowList().get(18);
        Cell sixteenthCell = sixteenthRow.getCellList().get(3);

        try {
        	sixteenthCell.getParagraphList().getParagraph(0).getText().insertString(0, month);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        
        Row seventeenthRow = curCtr.getRowList().get(18);
        Cell seventeenthCell = seventeenthRow.getCellList().get(5);

        try {
        	seventeenthCell.getParagraphList().getParagraph(0).getText().insertString(0, day);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
        
		
		}
	}

	
}
