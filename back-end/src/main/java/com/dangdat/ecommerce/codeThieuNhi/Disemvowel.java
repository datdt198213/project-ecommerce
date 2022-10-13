package com.dangdat.ecommerce.codeThieuNhi;

public class Disemvowel {

    public static String disemvowel(String z) {
        return z.replaceAll("(?i)[aeiou]" , "");
    }

    public static String disemvowel2(String str) {
        return str.replaceAll("[aAuUiIeEoO]", "");
    }

    public static String disemvowel3(String str) {

        String tmp = "";

        for(int i = 0 ; i < str.length(); i ++) {
            char charTmp = str.charAt(i);
            boolean check = false;
            switch (charTmp) {
                case 'A':
                case 'I':
                case 'U':
                case 'O':
                case 'E':
                case 'a':
                case 'i':
                case 'u':
                case 'o':
                case 'e':
                    check = true;
                    break;
                default:
                    break;
            }
            if(!check) {
                tmp += str.charAt(i);
            }
        }

        return tmp;
    }

    public static void main(String[] args) {
        String x = "No offense but,\nYour writing is among the worst I've ever read";

        System.out.println(disemvowel3(x));o
    }
}
