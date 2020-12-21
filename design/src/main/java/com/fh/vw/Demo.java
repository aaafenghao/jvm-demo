package com.fh.vw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        Demo test = new Demo();
        test.str("smb:\\\\root:root@192.168.103.28\\lee\\农行数据[日期_yyyyMMdd][].rar","2020-11-02");
    }
    void str(String str,String date){
        /*int index = str.lastIndexOf("\\");
        String path = str.substring(0, index + 1);
        String fileName = str.substring(index + 1);
        System.out.println(fileName.replaceAll("\\["+"日期"+"_"+"yyyyMMdd"+"\\]", "yyyyMMdd"));*/
        /*Pattern compile = Pattern.compile("(.*)\\[(.*)\\].(.*)");
        Matcher matcher = compile.matcher(fileName);
        while (matcher.find()){
            int i = matcher.groupCount();
            for (int j = 0; j <= i; j++) {
                System.out.println(matcher.group(j));
            }
        }*/

        String mess = "smb://root:root@192.168.103.28/lee/[日期_yyyyMMdd]/农行数据[日期_yyyyMMdd].rar";
        //[日期_yyyyMMdd]
        Pattern compile = Pattern.compile(".*\\[日期_([A-Za-z]*)\\].*");
        Matcher matcher = compile.matcher(mess);
        if(matcher.matches()){
            System.out.println(matcher.group(1));
            System.out.println("----");
        }else{
            System.out.println("11111");
        }


    }
}