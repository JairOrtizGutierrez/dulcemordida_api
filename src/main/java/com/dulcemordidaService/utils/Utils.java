package com.dulcemordidaService.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class Utils {
    public static Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename).filter(f -> f.contains(".")).map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

    public static File transferImage(MultipartFile image, String prefix, File directory) throws IOException {
        Optional<String> extension = Utils.getExtensionByStringHandling(image.getOriginalFilename());
        if (!extension.isPresent()) throw new RuntimeException();
        File newFile = File.createTempFile(prefix, "." + extension.get(), directory);
        image.transferTo(newFile);
        Thumbnails.of(newFile).scale(1).outputQuality(0.5).toFile(newFile);
        return newFile;
    }
}