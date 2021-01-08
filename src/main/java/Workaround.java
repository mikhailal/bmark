package com.mypackage;

public class Workaround {
    public static String replacebuilder(String var) {
        StringBuilder sb = new StringBuilder();
        boolean flag_open = false;
        for (int i = 0; i < var.length(); i++) {
            if (var.charAt(i) == '[') {
                if (flag_open) {
                    sb.append('[');
                }
                flag_open = true;
            } else {
                 if (var.charAt(i) == ']') {
                    if (flag_open) {
                        sb.append('{');
                        sb.append('}');
                    } else {
                        sb.append(']');
                    };
                 } else if (var.charAt(i) == '\n') {
                    if (flag_open) {
                        sb.append('[');
                    }
                } else if (var.charAt(i) == '\"') {
                    if (flag_open) {
                        sb.append('[');
                    }
                    sb.append('\'');
                } else {
                    if (flag_open) {
                        sb.append('[');
                    }
                    sb.append(var.charAt(i));
                }
                 flag_open = false;
           }
        }
        if (flag_open) {
            sb.append('[');
        }
        return sb.toString();
    }
}
