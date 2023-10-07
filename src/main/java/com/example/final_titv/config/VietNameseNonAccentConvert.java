package com.example.final_titv.config;

import java.text.Normalizer;

public class VietNameseNonAccentConvert {
    public static String convert(String str){
        str = str.replaceAll("[AÁÀÃẠÂẤẦẪẬĂẮẰẴẶ]", "A");
        str = str.replaceAll("[àáạảãâầấậẩẫăằắặẳẵ]", "a");
        str = str.replaceAll("[EÉÈẼẸÊẾỀỄỆ]", "E");
        str = str.replaceAll("[èéẹẻẽêềếệểễ]", "e");
        str = str.replaceAll("[IÍÌĨỊ]", "I");
        str = str.replaceAll("[ìíịỉĩ]", "i");
        str = str.replaceAll("[OÓÒÕỌÔỐỒỖỘƠỚỜỠỢ]", "O");
        str = str.replaceAll("[òóọỏõôồốộổỗơờớợởỡ]", "o");
        str = str.replaceAll("[UÚÙŨỤƯỨỪỮỰ]", "U");
        str = str.replaceAll("[ùúụủũưừứựửữ]", "u");
        str = str.replaceAll("[YÝỲỸỴ]", "Y");
        str = str.replaceAll("[ỳýỵỷỹ]", "y");
        str = str.replaceAll("Đ", "D");
        str = str.replaceAll("đ", "d");

        // Some system encode Vietnamese combining accent as individual UTF-8 characters
        str = str.replaceAll("[\u0300\u0301\u0303\u0309\u0323]", ""); // Huyền sắc hỏi ngã nặng
        str = str.replaceAll("[\u02C6\u0306\u031B]", ""); // Â, Ê, Ă, Ơ, Ư
//        System.out.println("___" + str);
        return str;
    }
    public static String removeSignOnly (String str){
        str = str.replaceAll("[ÂẤẦẪẬ]", "Â");
        str = str.replaceAll("[ĂẮẰẴẶ]", "Ă");
        str = str.replaceAll("[âầấậẩẫ]", "â");
        str = str.replaceAll("[ăằắặẳẵ]", "ă");
        str = str.replaceAll("[AÁÀÃẠ]", "A");
        str = str.replaceAll("[àáạảã]", "a");

        str = str.replaceAll("[ÊẾỀỄỆ]", "Ê");
        str = str.replaceAll("[êềếệểễ]", "ê");
        str = str.replaceAll("[EÉÈẼẸ]", "E");
        str = str.replaceAll("[èéẹẻẽ]", "e");
        str = str.replaceAll("[IÍÌĨỊ]", "I");
        str = str.replaceAll("[ìíịỉĩ]", "i");

        str = str.replaceAll("[OÓÒÕỌ]", "O");
        str = str.replaceAll("[òóọỏõ]", "o");
        str = str.replaceAll("[ÔỐỒỖỘ]", "Ô");
        str = str.replaceAll("[ƠỚỜỠỢ]", "Ơ");
        str = str.replaceAll("[ôồốộổỗ]", "ô");
        str = str.replaceAll("[ơờớợởỡ]", "ơ");

        str = str.replaceAll("[UÚÙŨỤ]", "U");
        str = str.replaceAll("[ùúụủũ]", "u");
        str = str.replaceAll("[ƯỨỪỮỰ]", "Ư");
        str = str.replaceAll("[ưừứựửữ]", "ư");

        str = str.replaceAll("[YÝỲỸỴ]", "Y");
        str = str.replaceAll("[ỳýỵỷỹ]", "y");

        str = str.replaceAll("[\u0300\u0301\u0303\u0309\u0323]", ""); // Huyền sắc hỏi ngã nặng
//        System.out.println(str);
        return str;
    }

    public static void main(String[] args) {
        String convertStr = "Đây là Đâu, tôi là ai! Trời tối rồi, đi về thôi !";
        String included = "lá";
        System.out.println(convert(convertStr));
        System.out.println("___");
        System.out.println(removeSignOnly(convertStr));
    }
}
