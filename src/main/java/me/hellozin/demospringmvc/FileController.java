package me.hellozin.demospringmvc;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/files")
    public String fileUploadForm(Model model) {
        return "files/index";
    }

    @PostMapping("/files")
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile,
                             RedirectAttributes attributes) {
//        multipartFile.save()
        String message = multipartFile.getOriginalFilename() + " is uploaded";
        attributes.addFlashAttribute("message", message);
        return "redirect:/files";
    }

    @GetMapping("/files/{filename}")
    public ResponseEntity<Resource> fileDownload(@PathVariable String filename) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + filename);
        File file = resource.getFile();

        /* File 관련 라이브러리 */
        Tika tika = new Tika();
        String mediaType = tika.detect(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\"" + resource.getFilename() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, mediaType)
                .header(HttpHeaders.CONTENT_LENGTH, file.length() + "")
                .body(resource);

                /* Content_Disposition 사용자가 정할 파일이름 대신 정해줌 */
    }

}
