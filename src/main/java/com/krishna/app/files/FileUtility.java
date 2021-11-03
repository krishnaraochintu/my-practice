package com.krishna.app.files;

import java.util.Optional;

public class FileUtility {
    public static String getExtension(String fileName)  {
        //return Optional.ofNullable(Files.probeContentType(Paths.get(fileName)));
        return Optional.ofNullable(fileName).filter(f -> f.contains(".")).map(f -> f.substring(f.lastIndexOf(".")+1)).
                orElseGet(() -> "unknown");

    }
}
