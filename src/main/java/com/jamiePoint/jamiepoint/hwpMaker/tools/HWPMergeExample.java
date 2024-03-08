package com.jamiePoint.jamiepoint.hwpMaker.tools;


import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.Section;
import kr.dogfoot.hwplib.object.bodytext.control.ControlSectionDefine;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwplib.writer.HWPWriter;

import java.io.File;

public class HWPMergeExample {
    public static void main(String[] args) {
        try {
            String filename1 = "basic_hwp" + File.separator + "result-jamie-point.hwp";
            String filename2 = "basic_hwp" + File.separator + "result-jamie-point2.hwp";
            String filename3 = "basic_hwp" + File.separator + "result-jamie-point-last.hwp";




            // 첫 번째 HWP 파일 읽기
            HWPFile file1 = HWPReader.fromFile(filename1);

            // 두 번째 HWP 파일 읽기
            HWPFile file2 = HWPReader.fromFile(filename2);
            
            // 두 번째 HWP 파일 읽기
            HWPFile file3 = HWPReader.fromFile(filename3);
   

          
            // 두 번째 HWP 파일의 첫 번째 Section 정보 가져오기
            Section firstSection1 = file1.getBodyText().getSectionList().get(0);

            // 두 번째 HWP 파일의 첫 번째 Section 정보 가져오기
            Section firstSection3 = file3.getBodyText().getSectionList().get(0);
            
            // 첫 번째 HWP 파일의 마지막 Section 뒤에 두 번째 HWP 파일의 첫 번째 Section 추가
            file2.getBodyText().getSectionList().add(firstSection1);
            
            // 첫 번째 HWP 파일의 마지막 Section 뒤에 두 번째 HWP 파일의 첫 번째 Section 추가
//            file1.getBodyText().getSectionList().add(firstSection3.clone());

            // 병합된 HWP 파일 저장

            String writePath = "basic_hwp" + File.separator + "result-zs.hwp";
      
            
            HWPWriter.toFile(file2, writePath);

            System.out.println("HWP 파일 병합이 완료되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
