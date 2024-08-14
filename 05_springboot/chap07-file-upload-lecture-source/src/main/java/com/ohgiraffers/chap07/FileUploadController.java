package com.ohgiraffers.chap07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUploadController {

    /* 설명. build된 곳에 파일 업로드 경로를 지정하기 위해 ResourceLoader의존성 주입 받기 */
    private ResourceLoader resourceLoader;
    // 이 친구를 활용해서 절대 경로를 추출할거야

    @Autowired
    public FileUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /* 설명. multipartform */
    @PostMapping("single-file")
    public String singleFileUpload(@RequestParam MultipartFile singleFile,
                                   @RequestParam String singleFileDescription,
                                   RedirectAttributes rttr) throws IOException {
        System.out.println("singleFile = " + singleFile);
        System.out.println("singleFileDescription = " + singleFileDescription);
        Resource resource = resourceLoader.getResource("classpath:static/uploadFiles/img/single");
        System.out.println("파일 업로드 할 폴더의 절대 경로:" + resource.getFile().getAbsolutePath());

        String filePath = resource.getFile().getAbsolutePath();

        String originalFilename = singleFile.getOriginalFilename();
        System.out.println("originalFilename = " + originalFilename); //원본이름

        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println("ext = " + ext); // 확장자

        String saveName = UUID.randomUUID().toString().replace("-", "") + ext;
        System.out.println("saveName = " + saveName); //랜덤값으로 추출하고 -를 없앰

        /* 설명. 1. 지정된 위치에 업로드된 파일 저장, 2. DB에 저장할 정보 추출(DB 모델링) */
        try {
            singleFile.transferTo(new File(filePath + "/" + saveName));

            /* 설명. 원래라면 이 부분에서 BL(비지니스 로직) 구문 작성 (서비스 계층 <-> DB) */
            /* 설명. BL이 성공하며 redirect 된 페이지를 값을 넘기기 위해 RedirectAttributes로 담는다. (flashAttribute) */
            rttr.addFlashAttribute("message", "파일 업로드 성공!");
            rttr.addFlashAttribute("img", "uploadFiles/img/single/" + saveName);
            rttr.addFlashAttribute("singleFileDescription", singleFileDescription);

        } catch (Exception e) {
            new File((filePath + "/" + saveName)).delete(); //
        }

        return "redirect:/result";
    }
    // 사용자가 수정또는 삽입을 할 것임 삽입의 행위는 리다이렉트로 처리하는것이 좋다. 서버에게 다시 경로로 재요청

    @GetMapping("/result")
    public void result() {
    }


}
