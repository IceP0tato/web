package web.service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

@Service
public class FileService {
    // 프로젝트 src : 개발자가 코드를 작성하는 폴더
    // 프로젝트 build : 서버 실행 시 컴파일된 코드 (내장 서버가 갖는 실행된 폴더)

    // 현재 프로젝트의 최상위 디렉토리(폴더) 경로 찾기
    String baseDir = System.getProperty("user.dir");
    // 개발자 폴더가 아닌 실행된 서버의 폴더로 업로드 경로 지정
    String uploadPath = baseDir + "/build/resources/main/static/upload/";

    // 파일 업로드
    // multipartFile : 대용량 바이트 조작
    public String fileUpload(MultipartFile multipartFile) {
        // 파일명이 중복일 때, 다른 파일이지만 파일명은 같을 수 있음
        // 파일명 앞에 PK 번호를 붙이거나, 업로드된 날짜/시간 붙여서 구분
        // 또는 UUID (네트워크식별번호) 라이브러리 사용 (난수 문자열 생성)
        String uuid = UUID.randomUUID().toString();
        // 업로드된 파일명과 합치기 (.getOriginalFilename() : 업로드된 파일명)
        // .replaceAll() : 언더바 _를 하이픈 -으로 변경 (uuid와 파일명 구분을 언더바로 하기 위한 내부 규칙)
        String fileName = uuid+"_"+multipartFile.getOriginalFilename().replaceAll("_", "-");
        // 업로드 경로와 파일명 합치기
        String filePath = uploadPath + fileName;
        // upload 폴더가 없으면 생성
        File pathFile = new File(uploadPath);
        if (!pathFile.exists()) {
            pathFile.mkdir();
        }
        // 업로드할 파일 경로를 file 클래스 생성
        File uploadFile = new File(filePath);
        // 업로드 (파일/바이트 이동) (.transferTo(file 객체) : 지정한 file 객체의 경로로 업로드 파일 이동)
        try {
            multipartFile.transferTo(uploadFile);
        } catch (IOException e) {
            // 업로드 실패 시 null 반환
            System.out.println(e);
            return null;
        }
        // 업로드 성공 시 파일 이름 반환
        return fileName;
    }

    // 파일 다운로드
    // 매개변수 : 다운로드받은 파일명, 다운로드를 요청한 사용자의 '응답' 객체
    public void fileDownload(String fileName, HttpServletResponse response) {
        // 파일명과 업로드 경로 조합
        String downloadPath = uploadPath + fileName;
        // 만약 지정한 경로에 파일이 없으면 리턴
        File file = new File(downloadPath);
        if (!file.exists()) {
            return;
        }
        // 업로드 파일을 자바(바이트)로 가져오기
        try {
            // 파일 입력 스트림 객체 생성
            FileInputStream fin = new FileInputStream(downloadPath);
            // 파일 용량만큼 배열 생성, 읽은 바이트들을 저장할 배열변수 선언
            long fileSize = file.length();
            byte[] bytes = new byte[(int)fileSize];
            // 파일 입력 스트림 객체로 파일을 읽어서 배열에 저장
            fin.read(bytes);
            // 스트림 닫기 (스트림 : 바이트가 다니는 (이동)통신 경로)
            fin.close(); // 대용량에서는 안전하게 스트림을 닫는 것이 권장됨

            // 다운로드 형식 지정 (브라우저마다 상이함)
            // .split("문자") : 문자열 내 문자 기준으로 문자열 자르기
            String oldFilename = fileName.split("_")[1];
            // 응답 형식 지정, 다운로드 형식과 다운로드 파일 지정
            // URL은 한글 지원하지 않음 -> URLEncoder.encode(파일명, "UTF-8);
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(oldFilename, "UTF-8"));

            // 업로드 파일을 사용자에게 응답하기
            // 파일 출력 스트림 객체 생성 (서블릿 : 자바 회사에서 만든 HTTP 요청/응답 클래스)
            // response 객체가 출력 스트림 제공
            ServletOutputStream fout = response.getOutputStream();
            // 바이트 배열을 다운로드 요청한 사용자에게 출력
            fout.write(bytes);
            // 스트림 닫기
            fout.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 파일 삭제
    public boolean fileDelete(String fileName) {
        // 삭제할 파일명과 업로드 경로 조합
        String filePath = uploadPath + fileName;
        // 경로에 파일이 존재하면 삭제 (.delete() : 지정한 경로의 파일 삭제)
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
            return true;
        } else {
            return false;
        }
    }
}
