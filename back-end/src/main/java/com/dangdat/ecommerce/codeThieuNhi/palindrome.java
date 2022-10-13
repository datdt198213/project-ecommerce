package com.dangdat.ecommerce.codeThieuNhi;

public class palindrome {

    public static boolean isPalindrome(String s) {
        boolean result = true;
        StringBuilder sb = new StringBuilder(s.toLowerCase().trim());
        int i = 0;
        while (i < sb.length()) {
            if(sb.charAt(i) < 97 || sb.charAt(i) > 122) { //  [a,z] nam ngoai
                System.out.println(sb.deleteCharAt(i));
                i = i - 1;
            }
            ++i;
        }

        i = 0;
        while(i < sb.length() / 2) {
            System.out.println("sb.charAt(sb.length() - i - 1):\t" + sb.charAt(sb.length() - i - 1));
            if(sb.charAt(i) != sb.charAt(sb.length() - i - 1)) {
                result = false;
                break;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("Result: " + isPalindrome(s));
    }
}
