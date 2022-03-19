package Ceaser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

public class Ceasar24 {
    /*
     Nó chỉ đơn giản là một loại mật mã thay thế, tức là mỗi chữ cái
     của một văn bản nhất định được thay thế bằng một chữ cái với một số vị trí cố định trong bảng chữ cái.
     */
    public static String encrypt(String msg, int key) {
        char arr[] = new char[msg.length()];// create character array from string array
        for (int i = 0; i < msg.length(); i++) { // loop
            int e = (int) msg.charAt(i) + key; // function charAt() find the position of the letter in the alphabet + Key
            e = e > (int) 'Z' ? e - 26 : e; // if e passes the letter z assign e - 26 else e assign e
            arr[i] = (char) e;// put e in array
        }
        return new String(arr); // cast to String
    }

    public static String decrypt(String msg, int key) {
        char arr[] = new char[msg.length()]; // create character array from string array
        for (int i = 0; i < msg.length(); i++) { // loop
            int e = (int) msg.charAt(i) - key; // function charAt() find the position of the letter in the alphabet - Key
            e = e < (int) 'A' ? e + 26 : e;// if e if less than  the letter A assign e + 26 else e assign e
            arr[i] = (char) e; // put e in array
        }
        return new String(arr); // cast to String
    }
    public static void ghifile(String s,String a){
        try {
            Formatter f = new Formatter(a);
            //f.format("Đây là file Vidu\r\n", null);
            f.format("%s ", s + "\r\n");


            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Random r = new Random();
        int key = r.nextInt(26);


        System.out.println("Ma hoa Caesar");

        try {
            File x = new File("file_goc");
            Scanner sc = new Scanner(x);
            String originalMessage = "";
            while(sc.hasNextLine()) {
                originalMessage += sc.nextLine()+"\r\n";
            }
            System.out.println(originalMessage);
            String encryptedMessage = Ceasar24.encrypt(originalMessage, key);
            Ceasar24.ghifile(encryptedMessage,"fileEn.txt");

            String decryptedMessage = Ceasar24.decrypt(encryptedMessage, key);
            Ceasar24.ghifile(decryptedMessage,"fileDe.txt");

            //System.out.println("Original Message: " + originalMessage);
            //System.out.println("Encrypted Message: " + encryptedMessage);
            //System.out.println("Decrypted Message: " + decryptedMessage);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }




}

