package com.krishna.app.files;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

public class FileCountByTypeTask extends RecursiveTask<Map<String, Integer>> {

    private final String directory;
    private Map<String, Integer> countByTypeMap;
    public FileCountByTypeTask(String directory, Map<String, Integer> countByTypeMap) {
        this.directory = directory;
        this.countByTypeMap = countByTypeMap;
    }

    @Override
    protected Map<String, Integer> compute() {
        File rootDirectory = new File(directory);
        for (File file : rootDirectory.listFiles()) {
            if(file.isFile()) {
                String extension = FileUtility.getExtension(file.getAbsolutePath());
                //System.out.println(file.getPath() +":"+ extension);
                countByTypeMap.put(extension, countByTypeMap.getOrDefault(extension, 0) + 1);
                // countByTypeMap.merge(extension.get(),1, (V1, V2) -> V1+ V2);
            } else {
                //System.out.println(file.getPath()+":dir");
                FileCountByTypeTask fileCountByTypeTask = new FileCountByTypeTask(file.getAbsolutePath(), countByTypeMap);
                fileCountByTypeTask.fork();
                fileCountByTypeTask.join();
            }
        }
        return countByTypeMap;
    }
}
