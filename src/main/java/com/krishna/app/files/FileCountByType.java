package com.krishna.app.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

public class FileCountByType {
    AtomicInteger count = new AtomicInteger(0);
    AtomicInteger dirCount = new AtomicInteger(0);
    Map<String, Integer> countByTypeMap = new ConcurrentHashMap<>();
    public int countByTypeIO(String rootPath, int level) throws IOException {
        File rootDirectory = new File(rootPath);
        for (File file : rootDirectory.listFiles()) {
         /*   for (int i = 0; i < level; i++)
                System.out.print("\t");*/
            if(file.isFile()) {
                String extension = FileUtility.getExtension(file.getAbsolutePath());
               // System.out.println(file.getPath() +":"+ extension);
                count.getAndIncrement();
                countByTypeMap.put(extension, countByTypeMap.getOrDefault(extension, 0) + 1);
               // countByTypeMap.merge(extension.get(),1, (V1, V2) -> V1+ V2);
            } else {
               // System.out.println(file.getPath());
                dirCount.getAndIncrement();
                countByTypeIO(file.getAbsolutePath(), level+1);
            }
        }
        return count.get();
    }


    public int countByTypeNIO(String rootPath) throws IOException {
        AtomicInteger count = new AtomicInteger(0);
        DirectoryStream<Path> pathDirectoryStream = Files.newDirectoryStream(Paths.get(rootPath));
        pathDirectoryStream.forEach(path -> count.getAndIncrement());
        return count.get();
    }

    public void printHashMap(Map<String, Integer> map) {
       map.entrySet().stream().forEach(System.out::println);
    }

    public  void listByQueue() {
        List<File> allFiles = new ArrayList<File>();
        Queue<File> dirs = new LinkedList<File>();
        dirs.add(new File("/start/dir/"));
        while (!dirs.isEmpty()) {
            for (File f : dirs.poll().listFiles()) {
                if (f.isDirectory()) {
                    dirs.add(f);
                } else if (f.isFile()) {
                    allFiles.add(f);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        String rootPath = "/home/krishnar/Desktop";
        FileCountByType currentObject = new FileCountByType();
        Map<String, Integer> countByTypeMap = new ConcurrentHashMap<>();
        long startTime = System.nanoTime();
        int count = currentObject.countByTypeIO(rootPath, 0);
        long stopTime = System.nanoTime();
        long timeTakenForLoop = stopTime - startTime;
        System.out.println("==============Loop===============");
        System.out.println(count);
        System.out.println(currentObject.dirCount.get());
        currentObject.printHashMap(currentObject.countByTypeMap);
        System.out.println("=================================");
        //System.out.println(currentObject.countByTypeNIO(rootPath));
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long startTimeTwo = System.nanoTime();
        Map<String, Integer> stringIntegerMap = forkJoinPool.invoke(new FileCountByTypeTask(rootPath, countByTypeMap));
        long stopTimeTwo = System.nanoTime();
        long timeTakenForReucrison = stopTimeTwo - startTimeTwo;
        System.out.println("==============Threads===============");
        currentObject.printHashMap(stringIntegerMap);
        System.out.println("=================================");
        System.out.println(stringIntegerMap.equals(currentObject.countByTypeMap));
        System.out.println(timeTakenForLoop);
        System.out.println(timeTakenForReucrison);
        System.out.println(timeTakenForLoop - timeTakenForReucrison);
        System.out.println((timeTakenForLoop - timeTakenForReucrison)/1000000);
    }
}
