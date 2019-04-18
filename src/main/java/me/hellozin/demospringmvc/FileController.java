package me.hellozin.demospringmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileController {

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

}
