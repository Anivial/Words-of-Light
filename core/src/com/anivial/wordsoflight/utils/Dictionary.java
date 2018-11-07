package com.anivial.wordsoflight.utils;

import com.badlogic.gdx.utils.Array;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dictionary {

    private static Dictionary instance = null;
    private static Array<String> wordList;

    protected Dictionary(){
    }

    public static Dictionary getInstance() {
        if(instance == null) {
            instance = new Dictionary();
            instance.init();
        }
        return instance;
    }

    private void init(){
        FileInputStream fis = null;
        DataInputStream dis = null;
        BufferedReader br = null;
        wordList = new Array<String>();
        try {
            fis = new FileInputStream("dictionary/ods5.txt");
            dis = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(dis));
            String line = null;
            while((line = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(line, " ,.;:\"");
                while(st.hasMoreTokens()){
                    String tmp = st.nextToken().toLowerCase();
                    wordList.add(tmp);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{if(br != null) br.close();
            }catch(Exception ex){}
        }
    }

    public void test(){
        System.out.println(wordList.contains("etranglera",false));
    }

}
