//package com.project.analysis.domain.ui;
//
//import com.project.analysis.global.common.BaseResponse;
//import com.project.analysis.global.exception.RestApiException;
//import com.project.analysis.global.exception.code.status.GlobalErrorStatus;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.UUID;
//
//@Slf4j
//@RestController
//@RequestMapping("/api/v1/edf")
//@RequiredArgsConstructor
//@Tag(name = "EDF File", description = "EDF 파일 업로드 및 분석 API")
//public class EdfFileController {
//
//    // 임시 파일 저장 경로 (실제 환경에서는 설정 파일로 관리)
//    private static final String UPLOAD_DIR = "uploads/edf/";
//
//    @Operation(summary = "EDF 파일 업로드", description = "뇌파 데이터 EDF 파일을 업로드합니다.")
//    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<BaseResponse<String>> uploadEdfFile(
//            @Parameter(description = "업로드할 EDF 파일", required = true)
//            @RequestParam("file") MultipartFile file) {
//
//        try {
//            // 파일 검증
//            validateEdfFile(file);
//
//            // 파일 저장
//            String savedFilePath = saveEdfFile(file);
//
//            log.info("EDF 파일 업로드 성공: {}", savedFilePath);
//
//            return ResponseEntity.ok(BaseResponse.onSuccess("EDF 파일이 성공적으로 업로드되었습니다.", savedFilePath));
//
//        } catch (IOException e) {
//            log.error("EDF 파일 업로드 중 IO 에러 발생: {}", e.getMessage(), e);
//            throw new RestApiException(GlobalErrorStatus._INTERNAL_SERVER_ERROR);
//        } catch (Exception e) {
//            log.error("EDF 파일 업로드 중 예상치 못한 에러 발생: {}", e.getMessage(), e);
//            throw new RestApiException(GlobalErrorStatus._INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @Operation(summary = "EDF 파일 분석", description = "업로드된 EDF 파일을 분석합니다.")
//    @PostMapping("/analyze")
//    public ResponseEntity<BaseResponse<String>> analyzeEdfFile(
//            @Parameter(description = "분석할 EDF 파일 경로", required = true)
//            @RequestParam("filePath") String filePath) {
//
//        try {
//            // 파일 존재 여부 확인
//            Path path = Paths.get(filePath);
//            if (!Files.exists(path)) {
//                throw new RestApiException(GlobalErrorStatus._NOT_FOUND);
//            }
//
//            // EDF 파일 분석 로직 (여기에 실제 분석 로직 구현)
//            String analysisResult = performEdfAnalysis(filePath);
//
//            log.info("EDF 파일 분석 완료: {}", filePath);
//
//            return ResponseEntity.ok(BaseResponse.onSuccess("EDF 파일 분석이 완료되었습니다.", analysisResult));
//
//        } catch (Exception e) {
//            log.error("EDF 파일 분석 중 에러 발생: {}", e.getMessage(), e);
//            throw new RestApiException(GlobalErrorStatus._INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    /**
//     * EDF 파일 검증
//     */
//    private void validateEdfFile(MultipartFile file) {
//        if (file.isEmpty()) {
//            throw new RestApiException(GlobalErrorStatus._BAD_REQUEST);
//        }
//
//        // 파일 확장자 검증
//        String originalFilename = file.getOriginalFilename();
//        if (originalFilename == null || !originalFilename.toLowerCase().endsWith(".edf")) {
//            throw new RestApiException(GlobalErrorStatus._BAD_REQUEST);
//        }
//
//        // 파일 크기 검증 (예: 100MB 제한)
//        long maxFileSize = 100 * 1024 * 1024; // 100MB
//        if (file.getSize() > maxFileSize) {
//            throw new RestApiException(GlobalErrorStatus._BAD_REQUEST);
//        }
//
//        // 파일 타입 검증 (EDF 파일의 MIME 타입은 다양할 수 있으므로 기본적인 검증만 수행)
//        String contentType = file.getContentType();
//        if (contentType != null && contentType.equals("application/octet-stream")) {
//            // EDF 파일은 바이너리 파일이므로 application/octet-stream이 일반적
//            log.debug("EDF 파일 타입 확인: {}", contentType);
//        }
//    }
//
//    /**
//     * EDF 파일 저장
//     */
//    private String saveEdfFile(MultipartFile file) throws IOException {
//        // 업로드 디렉토리 생성
//        Path uploadPath = Paths.get(UPLOAD_DIR);
//        if (!Files.exists(uploadPath)) {
//            Files.createDirectories(uploadPath);
//        }
//
//        // 고유한 파일명 생성
//        String originalFilename = file.getOriginalFilename();
//        String fileExtension = originalFilename != null ?
//            originalFilename.substring(originalFilename.lastIndexOf(".")) : ".edf";
//        String uniqueFilename = UUID.randomUUID().toString() + fileExtension;
//
//        // 파일 저장
//        Path filePath = uploadPath.resolve(uniqueFilename);
//        Files.copy(file.getInputStream(), filePath);
//
//        return filePath.toString();
//    }
//
//    /**
//     * EDF 파일 분석 (임시 구현)
//     */
//    private String performEdfAnalysis(String filePath) {
//        // 실제 EDF 파일 분석 로직을 여기에 구현
//        // 예: EDF 파일 헤더 읽기, 채널 정보 추출, 데이터 분석 등
//
//        log.info("EDF 파일 분석 시작: {}", filePath);
//
//        // 임시 응답 (실제로는 분석 결과 객체를 반환해야 함)
//        return "EDF 파일 분석이 완료되었습니다. 분석 결과는 추후 구현 예정입니다.";
//    }
//}
