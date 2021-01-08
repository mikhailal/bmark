package com.mypackage;

public class Workaround {
    public static String replacebuilder(String var) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = var.length();
        while (i < len) {
            if (var.charAt(i) == '[') {
                if ((i < len-1) && (var.charAt(i+1) == ']')) {
                    sb.append('{');
                    sb.append('}');
                    i++;
                } else {
                    sb.append('[');
                }
            } else if (var.charAt(i) == '\n') {
            } else if (var.charAt(i) == '\"') {
                    sb.append('\'');
            } else {
                    sb.append(var.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}
