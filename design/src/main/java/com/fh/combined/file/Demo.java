package com.fh.combined.file;

public class Demo {

    /**
     * /
     * /wz/
     * /wz/a.txt
     * /wz/b.txt
     * /wz/movies/
     * /wz/movies/c.avi
     * /xzg/
     * /xzg/docs/
     * /xzg/docs/d.txt
     * @param args
     */
    public static void main(String[] args) {
        Directory root = new Directory("/");
        Directory dir_1 = new Directory("/wz/");
        Directory dir_11 = new Directory("/xzg/");
        root.addSubNode(dir_1);
        root.addSubNode(dir_11);

        File file_1 = new File("/wz/a.txt");
        File file_11 = new File("/wz/b.txt");
        dir_1.addSubNode(file_1);
        dir_1.addSubNode(file_11);

        Directory dir_1_1 = new Directory("/wz/movies/");
        dir_1.addSubNode(dir_1_1);

        Directory dir_11_1 = new Directory("/xzg/docs/");
        dir_11.addSubNode(dir_11_1);

        File file_1_1 = new File("/wz/movies/c.avi");
        dir_1_1.addSubNode(file_1_1);

        File file_11_1 = new File("xzg/docs/d.txt");
        dir_11_1.addSubNode(file_11_1);


    }
}
