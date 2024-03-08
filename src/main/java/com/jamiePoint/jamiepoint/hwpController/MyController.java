package com.jamiePoint.jamiepoint.hwpController;

import java.io.File;
import java.nio.file.Path;

import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jamiePoint.jamiepoint.hwpController.user.UserInfoForm;
import com.jamiePoint.jamiepoint.hwpMaker.ActivityPageMaker;
import com.jamiePoint.jamiepoint.hwpMaker.FirstPageMaker;
import com.jamiePoint.jamiepoint.hwpMaker.IDAndBankPageMaker;
import com.jamiePoint.jamiepoint.hwpMaker.LastPageMaker;
import com.jamiePoint.jamiepoint.hwpMaker.PsPageMaker;
import com.jamiePoint.jamiepoint.hwpMaker.SecondPageMaker;
import com.jamiePoint.jamiepoint.hwpMaker.tools.PageMergeEditor;

@RestController
public class MyController {

	@PostMapping("/zs")
    public ResponseEntity<UrlResource> receiveAndOutputJson(@RequestBody UserInfoForm userInfoForm) {
        // 받은 JSON 데이터를 그대로 출력
        String jsonString = userInfoForm.toString();
        System.out.println("Received JSON data:\n" + jsonString);
        
        try {
            FirstPageMaker.go(userInfoForm);
            SecondPageMaker.go(userInfoForm);
            IDAndBankPageMaker.go(userInfoForm);
            PsPageMaker.go(userInfoForm);
            ActivityPageMaker.go(userInfoForm);
            LastPageMaker.go(userInfoForm);
            PageMergeEditor.go(userInfoForm);
    
            
            String filePath = "test_hwp" + File.separator + "result-jamie-point-merge.hwp";
            
            // 파일을 리소스로 읽어오기
            Path path = Path.of(filePath);
            UrlResource resource = new UrlResource(path.toUri());
            // 파일이 존재하고 읽을 수 있는 경우 응답으로 파일을 전송
            if (resource.exists() && resource.isReadable()) {
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "jamiepoint.hwp");
                return ResponseEntity.ok()
                        .headers(headers)
                        .contentLength(resource.contentLength())
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .body(resource);
            } else {
                // 파일이 존재하지 않거나 읽을 수 없는 경우 404 에러 응답
                return ResponseEntity.notFound().build();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
