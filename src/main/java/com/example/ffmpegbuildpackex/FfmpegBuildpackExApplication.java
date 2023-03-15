package com.example.ffmpegbuildpackex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SpringBootApplication
public class FfmpegBuildpackExApplication {

    @PostMapping(value = "/medias/check-dimension", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public DimensionResponse getMediaDimension(@RequestParam MultipartFile file) {
        return MediaUtils.getDimension(file);
    }

    public static void main(String[] args) {
        SpringApplication.run(FfmpegBuildpackExApplication.class, args);
    }

}
