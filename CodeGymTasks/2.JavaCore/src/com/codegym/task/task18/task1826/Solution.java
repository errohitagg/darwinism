package com.codegym.task.task18.task1826;

/* 
Encryption

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Wrong number of arguments");
            return;
        }

        String mode = args[0],
                fileName = args[1],
                fileOutputName = args[2];

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileOutputName));
            String result = mode.equals("-e") ? encrypt(bufferedReader) : decrypt(bufferedReader);
            bufferedWriter.write(result);
            bufferedReader.close();
            bufferedWriter.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    private static String encrypt(Reader reader)  throws IOException{

        String result = "";
        while(reader.ready()) {
            result += (char) (reader.read() + 1);
        }
        return result;
    }

    private static String decrypt(Reader reader) throws IOException {

        String result = "";
        while(reader.ready()) {
            result += (char) (reader.read() - 1);
        }
        return result;
    }
}
