package com.fh.visitor;

import java.util.ArrayList;
import java.util.List;

public class ToolApplication {

    public static void main(String[] args) {
        Extractor extractor = new Extractor();
        List<ResourceFile> files = listAllResourceFile();
        for (ResourceFile file : files) {
            file.accept(extractor);
        }
        Compressor compressor = new Compressor();
        for (ResourceFile file : files) {
            file.accept(compressor);
        }
    }

    private static List<ResourceFile> listAllResourceFile(){
        List<ResourceFile> files = new ArrayList<>();
        files.add(new PdfFile(""));
        files.add(new WordFile(""));
        files.add(new PPTFile(""));
        return files;
    }
}

