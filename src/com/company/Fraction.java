package com.company;

public class Fraction {

    public static void main(String[] args) {

        int[] test = {1, 14};
        try {
            System.out.println("Fraction double value is " + (double) test[0] / (double) test[1]);
            System.out.println("Period is " + fracPeriod(test));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    };

    static <T> void arrOut (T[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        };

    };

    static int[] numFetch (int[] arr) {

        if (arr.length < 2) return null;

        if (arr.length == 2) {
            return arr;
        };

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > 0 && arr[i + 1] > 0) {
                int[] result = {arr[i], arr[i + 1]};
                return result;
            };
        };

        return null;

    };

    static String fracPeriod (int[] nums) throws Exception {

        double frac = (double) nums[0] / (double) nums[1];

        String str = String.valueOf(frac);

        //System.out.println("frac to str conversion result is " + str);

        str = str.substring(str.indexOf(".") + 1, str.length() - 1);

        //System.out.println("str whole part formatting result is " + str);

        String temp = "";
        String temp2 = "";

        String tempStr = "";
        String tempStr2 = "";

        for (int i = 0; i < str.length() - 4; i++) {



            temp = str.substring(i, i + 1);

            //System.out.println("i loop; temp value is " + temp);

            for (int j = i + 1; j < str.length() - 1; j++) {

                temp2 = str.substring(j, j + 1);

                //System.out.println("j loop; temp2 value is " + temp2);

                if (temp.equals(temp2)) {

                    tempStr = str.substring(i, j);

                    //System.out.println("first if condition; tempStr value is " + temp);

                    tempStr2 = str.substring(j, str.length());

                    //System.out.println("first if condition; tempStr2 value is " + temp2);

                    int count = 0;

                    while ((tempStr2.length() > tempStr.length()) && count < 30) {
                        if (!tempStr2.startsWith(tempStr))
                            throw new Exception("fracPeriod method error 1");

                        tempStr2 = tempStr2.substring(tempStr.length(), tempStr2.length());
                        //System.out.println("while loop; tempStr2 value is " + tempStr2);

                        count++;
                    };

                    if (tempStr.startsWith(tempStr2))
                        return tempStr;

                };

            };


        };

        throw new Exception("fracPeriod method error 2");

    };

};
