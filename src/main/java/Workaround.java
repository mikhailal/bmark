package com.mypackage;

public class Workaround {
    public static String replacebuilder(String var) {
        int i = 0;
        int j = 0;
//len of input/output array
        int len = var.length();
        int len_real = len;
//computing len of result array
        while (i < len) {
            if (var.charAt(i) == '\n') {
                len_real--;
            }
            i++;
        }
//substitution
        i = 0;
        char[] char_array = new char[len_real];
        while (i < len) {
            if (var.charAt(i) == '[') {
                if ((i < len-1) && (var.charAt(i+1) == ']')) {
                    char_array[i-j]  = '{';
                    char_array[i-j+1] = '}';
                    i++;
                } else {
                    char_array[i-j] = '[';
                }
            } else if (var.charAt(i) == '\n') {
                j++;
            } else if (var.charAt(i) == '\"') {
                    char_array[i-j] = '\'';
            } else {
                    char_array[i-j] = var.charAt(i);
            }
            i++;
        }

        return new String(char_array);
    }
}
