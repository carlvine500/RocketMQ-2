package com.alibaba.rocketmq.example.leetcode;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int nRows) {
        if (nRows % 2 != 1) {
            throw new IllegalArgumentException("nRows should be an odd number");
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        int group = len / (nRows + 1);
        int remaining = len - group * (nRows + 1);
        int columns = -1;

        if (remaining > 0) {
            columns = group * 2 + 1;
        } else {
            columns = group * 2;
        }

        for(int i = 0; i < nRows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == nRows / 2) {
                    if (j > 2 * group) { //handle the last column
                        if (remaining > i) {
                            sb.append(s.charAt(group*2*(nRows+1) + i));
                        }
                    } else {
                        if (j % 2 == 0) {
                            if (j > 0) {
                                sb.append(s.charAt((j - 2) / 2 * (nRows + 1) + i));
                            } else {
                                sb.append(s.charAt(i));
                            }
                        } else {
                            sb.append((j - 1) / 2 * (nRows + 1) + 1);
                        }
                    }
                } else {
                    if (j % 2 == 0) {
                        sb.append(s.charAt(j / 2 * (nRows + 1) + i));
                    }
                }
            }
        }
        return sb.toString();
    }
}
