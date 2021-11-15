package com.yurirampazo.workshop_springboot_mongodb.resources.util;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Url {

    public static String decodeParameters( String text) {
       try {
        return URLDecoder.decode(text, "UTF-8");
       } catch (UnsupportedEncodingException e) {
        return "";
       }
    }
}
