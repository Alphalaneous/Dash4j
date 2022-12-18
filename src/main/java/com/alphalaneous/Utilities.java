package com.alphalaneous;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Utilities {


    public static void sleep(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean isBetween(float val, float a, float b, float maxDiff) {
        float temp;

        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }

        if (b - a > maxDiff) return false;

        return val >= a && val <= b;
    }

    public static void appendIfExists(StringBuilder builder, Object value, String key, char separator){


        if(value == null) return;
        if(value instanceof Integer){
            if((Integer)value == 0) return;
        }
        if(value instanceof Float){
            if((float)value == 0) return;
        }


        if(value instanceof Boolean) value = Utilities.boolToInt((Boolean) value);
        builder.append(toPair(key, value, separator));

    }

    public static String toPair(String ID, Object value, char separator){

        if(value instanceof Boolean){
            value = boolToInt((Boolean) value);
        }

        return "" + ID + separator + value + separator;
    }

    public static int boolToInt(boolean value){
        return value ? 1 : 0;
    }


    public static String[] splitEveryOther(String s, char c){

        String[] split = s.split(c + "");

        ArrayList<String> recombine = new ArrayList<>();

        int i = 0;
        StringBuilder combine = new StringBuilder();
        for(String s1 : split){

            combine.append(s1);
            i++;

            if((i) % 2 == 0){
                recombine.add(combine.toString());
                combine = new StringBuilder();
                continue;
            }
            combine.append(c);

        }
        return recombine.toArray(new String[0]);
    }

    public static int countOccurrences(String s, char c){
        return s.length() - s.replace(c + "", "").length();
    }

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static byte[] compress(String str){
        try {
            if (str == null || str.length() == 0) {
                return null;
            }
            ByteArrayOutputStream obj = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(obj);
            gzip.write(str.getBytes(StandardCharsets.UTF_8));
            gzip.close();
            return obj.toByteArray();
        }
        catch (Exception e){
            return null;
        }
    }

    public static String decompress(byte[] compressed) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(compressed);
        GZIPInputStream gis;
        gis = new GZIPInputStream(bis);
        BufferedReader br = new BufferedReader(new InputStreamReader(gis, StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        gis.close();
        bis.close();
        return sb.toString();
    }


    public static <T> String join(char delim, T[] array){
        StringBuilder sb = new StringBuilder();
        for (T n : array) {
            if (sb.length() > 0) sb.append(delim);
            sb.append(n);
        }
        return sb.toString();
    }

    public static String generateRS(int amount){
        String allowedChars = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            sb.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
        }

        return sb.toString();
    }

    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }

    public static String generateUDID(){
        return "S" + new Random().nextInt((100000000 - 100000) + 1) + 100000;
    }


}
