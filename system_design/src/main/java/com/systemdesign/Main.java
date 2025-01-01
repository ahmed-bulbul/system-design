package com.systemdesign;

public class Main {
    public static void main(String[] args) {

        System.out.println(isValid("()[]{}"));
    }


    public static boolean isValid(String s) {

        char[] arr = new char[s.length()];
        int top = -1;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if( (ch == '(') ||  (ch == '{' ) || (ch == '[') ){
                arr[++top] = ch;

            }else{
                if(ch != arr[top]){
                    return false;
                }
                top--;
            }
        }

        return true;

    }
}