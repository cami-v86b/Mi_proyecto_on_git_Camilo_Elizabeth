package com.example.Emailback.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String UploadDir;




}
