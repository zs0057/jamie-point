package com.jamiePoint.jamiepoint.hwpController;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class hwpController {
	
	@GetMapping("/hello-jamie")
	public MyData helloJamie() {
		MyData data = new MyData();
        data.setName("Jamie");
        data.setAge(30);
		return data;
	}
	
	@PostMapping("/generate-hwp")
    public ResponseEntity<byte[]> generateHwpFile(@RequestBody String textData) throws IOException {
    	
    	// HWP 파일의 경로 설정
        String hwpFilePath = "path/to/your/file.hwp";

        // HWP 파일을 바이트 배열로 읽어옴
        byte[] hwpFileBytes = Files.readAllBytes(new File(hwpFilePath).toPath());

        // HTTP 응답 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "example.hwp"); // 다운로드할 파일 이름 설정

        // HWP 파일을 응답 본문에 담아 클라이언트에게 반환
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(hwpFileBytes.length)
                .body(hwpFileBytes);
    }
}

