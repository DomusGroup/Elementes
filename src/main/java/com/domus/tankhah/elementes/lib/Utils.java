package com.domus.tankhah.elementes.lib;

/**
 * Created by osati.m on 12/27/2017.
 */

public class Utils {

    public static String persianString(String number) {
        number = number.trim();
        String persianNum = "";
        for (int i = 0; i < number.length(); i++) {
            switch (number.substring(i, i + 1)) {
                case "0":
                    persianNum += "۰";
                    break;
                case "1":
                    persianNum += "۱";
                    break;
                case "2":
                    persianNum += "۲";
                    break;
                case "3":
                    persianNum += "۳";
                    break;
                case "4":
                    persianNum += "۴";
                    break;
                case "5":
                    persianNum += "۵";
                    break;
                case "6":
                    persianNum += "۶";
                    break;
                case "7":
                    persianNum += "۷";
                    break;
                case "8":
                    persianNum += "۸";
                    break;
                case "9":
                    persianNum += "۹";
                    break;
                default:
                    persianNum += number.substring(i, i + 1);
            }
        }
        return persianNum;
    }

    public static String englishString(String number) {
        number = number.trim();
        String persianNum = "";
        for (int i = 0; i < number.length(); i++) {
            switch (number.substring(i, i + 1)) {
                case "۰":
                    persianNum += "0";
                    break;
                case "۱":
                    persianNum += "1";
                    break;
                case "۲":
                    persianNum += "2";
                    break;
                case "۳":
                    persianNum += "3";
                    break;
                case "۴":
                    persianNum += "4";
                    break;
                case "۵":
                    persianNum += "5";
                    break;
                case "۶":
                    persianNum += "6";
                    break;
                case "۷":
                    persianNum += "7";
                    break;
                case "۸":
                    persianNum += "8";
                    break;
                case "۹":
                    persianNum += "9";
                    break;
                default:
                    persianNum += number.substring(i, i + 1);
            }
        }
        return persianNum;
    }

    public static String trimzero(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.substring(0, 1).equals("0") || number.substring(0, 1).equals("۰")) {
                number = number.substring(1);
            } else break;
        }
        return number;
    }

    public static String getNumber(String string){
        String number="";
        for (int i = 0; i < string.length(); i++) {
            if ("۰۱۲۳۴۵۶۷۸۹0123456789".contains(string.substring(i, i + 1)))
                number += string.substring(i, i + 1);
        }
        return number;
    }

    public static String separate3(String sNum) {
        String sSeperat = new String();
        for (int i = sNum.length() - 1; i >= 0; i--) {
            if ((sNum.length() - 1 - i) % 3 == 0 && i != sNum.length() - 1) {
                sSeperat = "," + sSeperat;
            }
            sSeperat = sNum.substring(i, i + 1) + sSeperat;
        }
        return sSeperat;
    }

}
