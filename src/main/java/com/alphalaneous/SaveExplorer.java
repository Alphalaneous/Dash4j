package com.alphalaneous;

import com.alphalaneous.Exceptions.SaveFileNotLoadedException;
import org.apache.commons.lang3.math.NumberUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Base64;

public class SaveExplorer {

    private static final String dataFolder = System.getenv("LOCALAPPDATA") + "\\GeometryDash";
    private static final String saveFile = System.getenv("LOCALAPPDATA") + "\\GeometryDash\\CCGameManager.dat";
    private static final String levelsFile = System.getenv("LOCALAPPDATA") + "\\GeometryDash\\CCLocalLevels.dat";

    private static final LinkedHashMap<String, Object> gameManager = new LinkedHashMap<>();
    private static final LinkedHashMap<String, Object> localLevels = new LinkedHashMap<>();


    public static String getFolder(){
        return dataFolder;
    }

    public static ArrayList<File> getFolderContents(){

        ArrayList<File> results = new ArrayList<>();

        File[] files = new File(dataFolder).listFiles();

        if(files == null) return null;

        for (File file : files) {
            if (file.isFile()) {
                results.add(file);
            }
        }
        return results;
    }

    private static String getString(String string){
        try {

            String xorDecoded = Encoding.xorBasic(Utilities.readFile(string, StandardCharsets.UTF_8), 11);

            byte[] decodedBytes = Base64.getUrlDecoder().decode(xorDecoded.replace("\0", "").split("=")[0]);

            return Utilities.decompress(decodedBytes).replace("&#26;", "").replace("<plist version=\"1.0\" gjver=\"2.0\">", "").replace("</plist>", "");
        }
        catch (Exception e){
            e.printStackTrace();
            return "";
        }

    }





    public static String getGameManagerString() {

        return getString(saveFile);
    }

    public static String getLocalLevelsString() {
        return getString(levelsFile);
    }

    public static LinkedHashMap<String, Object> parseNodeList(NodeList nodeList){

        LinkedHashMap<String, Object> values = new LinkedHashMap<>();

        boolean name = true;
        String valueName = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);

            String nodeName = nNode.getNodeName();

            if (name) valueName = nNode.getTextContent();
            else {
                Object content = nNode.getTextContent();

                if(nodeName.equals("r") || nodeName.equals("i") || nodeName.equals("s")){
                    content = new SaveValue(nodeName.charAt(0), content);
                }

                if (nodeName.equals("t")) {
                    content = new SaveValue(nodeName.charAt(0), true);
                }
                if (nodeName.equals("d")) {
                    NodeList list = nNode.getChildNodes();
                    content = parseNodeList(list);
                }
                values.put(valueName, content);
            }
            name = !name;
        }

        return values;
    }



    static String escapeJson(String raw) {
        return raw.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    public static String convertToJSON(LinkedHashMap<String, Object> values){

        return "{\n" + convertToJSONString(values) + "\n}";
    }
    private static String convertToJSONString(LinkedHashMap<String, Object> values){

        StringBuilder builder = new StringBuilder();

        values.forEach((key, value) -> {
            String valueFormat = "";
            if(value instanceof LinkedHashMap) {
                valueFormat = "{\n" + convertToJSONString((LinkedHashMap<String, Object>) value) + "}";
            }
            else {
                //valueFormat = "\"" + escapeJson(String.valueOf(value)) + "\"";
                if(value instanceof SaveValue){
                    valueFormat = String.valueOf(value);
                }
            }

            String map = "\"" + key + "\" : " + valueFormat + ",\n";
            builder.append(map);
        });

        if(builder.length() > 2){
            return builder.substring(0, builder.length()-2) + "\n";
        }
        else{
            return builder.toString();
        }
    }

    public static String createDictionaryXMLString(LinkedHashMap<String, Object> values){

        StringBuilder builder = new StringBuilder();

        builder.append("<d>");


        values.forEach((key, value) -> {

            if (value instanceof SaveValue || (value instanceof SaveValue && ((SaveValue) value).type.equals("Boolean") && (Boolean)((SaveValue) value).value)) {
                builder.append("<k>");
                builder.append(key);
                builder.append("</k>");
            }

            if(value instanceof LinkedHashMap){
                builder.append("<k>");
                builder.append(key);
                builder.append("</k>");
                builder.append(createDictionaryXMLString((LinkedHashMap<String, Object>) value));
            }
            else if (value instanceof SaveValue){
                String valueType = "";

                switch (((SaveValue) value).type){

                    case "Integer":
                        valueType = "i";
                        break;
                    case "Double":
                        valueType = "r";
                        break;
                    case "String":
                        valueType = "s";
                        break;
                    case "Boolean":
                        valueType = "t";
                        break;
                    default: break;

                }

                if(((SaveValue) value).type.equals("Boolean") && (Boolean)((SaveValue) value).value){
                    builder.append("<t />");
                }
                else{
                    builder.append("<").append(valueType).append(">");
                    if(((SaveValue) value).value instanceof String && ((SaveValue) value).type.equals("String")){
                        builder.append(((String) ((SaveValue) value).value).replace("&", "&#38;")
                                .replace("<", "&#60;")
                                .replace(">", "&#62;")
                                .replace("'", "&#39;")
                                .replace("\"", "&#34;"));
                    }
                    else{
                        builder.append(((SaveValue) value).value);
                    }
                    builder.append("</").append(valueType).append(">");
                }
            }
        });


        builder.append("</d>");

        return builder.toString();
    }

    public static String createSave(LinkedHashMap<String, Object> values){

        StringBuilder builder = new StringBuilder();
        builder.append("<plist version=\"1.0\" gjver=\"2.0\"><?xml version=\"1.0\" encoding=\"UTF-8\"?><dict>");
        values.forEach((key, value) -> {

            if (value instanceof SaveValue || (value instanceof SaveValue && ((SaveValue) value).type.equals("Boolean") && (Boolean)((SaveValue) value).value)) {
                builder.append("<k>");
                builder.append(key);
                builder.append("</k>");
            }

            if (value instanceof LinkedHashMap) {
                builder.append("<k>");
                builder.append(key);
                builder.append("</k>");
                builder.append(createDictionaryXMLString((LinkedHashMap<String, Object>) value));
            } else if (value instanceof SaveValue){
                String valueType = "";

                switch (((SaveValue) value).type) {

                    case "Integer":
                        valueType = "i";
                        break;
                    case "Double":
                        valueType = "r";
                        break;
                    case "String":
                        valueType = "s";
                        break;
                    case "Boolean":
                        valueType = "t";
                        break;
                    default:
                        break;

                }

                if (((SaveValue) value).type.equals("Boolean") && (Boolean)((SaveValue) value).value) {
                    builder.append("<t />");
                } else {
                    builder.append("<").append(valueType).append(">");

                    if(((SaveValue) value).type.equals("String")){

                        builder.append(((String) ((SaveValue) value).value).replace("&", "&#38;")
                                .replace("<", "&#60;")
                                .replace(">", "&#62;")
                                .replace("'", "&#39;")
                                .replace("\"", "&#34;"));
                    }
                    else{
                        builder.append(((SaveValue) value).value);
                    }

                    builder.append("</").append(valueType).append(">");
                }
            }
        });

        builder.append("</dict></plist>");

        /*try {
            Files.write(Paths.get("C:/users/ashton/desktop/testPlist.txt"), builder.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        byte[] compressedString = Utilities.compress(builder.toString());
        byte[] encodedBytes = Base64.getUrlEncoder().encode(compressedString);

        return Encoding.xorBasic(new String(encodedBytes), 11);
    }

    public static void updateGameManager() throws IOException {
        Files.write(Paths.get(saveFile), SaveExplorer.createSave(gameManager).getBytes());
    }

    public static void updateLocalLevels() throws IOException {
        Files.write(Paths.get(levelsFile), SaveExplorer.createSave(localLevels).getBytes());
    }

    public static void load(LinkedHashMap<String, Object> values, byte[] valueBytes, String identifier){

        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setNamespaceAware(false);
            dbFactory.setValidating(false);
            dbFactory.setFeature("http://xml.org/sax/features/namespaces", false);
            dbFactory.setFeature("http://xml.org/sax/features/validation", false);
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(new ByteArrayInputStream(valueBytes));
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getDocumentElement().getChildNodes();

            values.putAll(parseNodeList(nList));
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to load " + identifier);
        }

    }

    public static void main(String... args){
        SaveExplorer.loadSave();
    }

    public static void loadSave() {
        Thread gm = new Thread(() -> load(gameManager,  getGameManagerString().getBytes(StandardCharsets.UTF_8), "save"));
        Thread ll = new Thread(() -> {
            load(localLevels,  getLocalLevelsString().getBytes(StandardCharsets.UTF_8), "levels");
            LevelExplorer.loadLevels();
        });
        gm.start();
        ll.start();
        try {
            gm.join();
            ll.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setDataFromKey(LinkedHashMap<String, Object> values, String key, Object data){
        if(values.isEmpty()) throw new SaveFileNotLoadedException("Save file is not loaded. Reload with SaveExplorer.loadSave();");

        values.put(key, data);
    }

    public static Object getDataFromKey(LinkedHashMap<String, Object> values, String key){
        if(values.isEmpty()) throw new SaveFileNotLoadedException("Save file is not loaded. Reload with SaveExplorer.loadSave();");

        if(key.equalsIgnoreCase("GJA_002")){
            int yes = JOptionPane.showConfirmDialog(null, "This software is accessing your Geometry Dash password.\nAllow?");
            if(yes == 0) return values.get(key);
            else return null;
        }

        return values.get(key);
    }

    public static LinkedHashMap<String, Object> getGameManager(){
        return gameManager;
    }

    public static LinkedHashMap<String, Object> getLocalLevels(){
        return localLevels;
    }

    public static void setUsername(String value){
        setDataFromKey(gameManager, "GJA_001", new SaveValue('s', value));
    }

    public static void setPassword(String value){
        setDataFromKey(gameManager, "GJA_002", new SaveValue('i', value));
    }

    public static void setAccountID(int value){
        setDataFromKey(gameManager, "GJA_003", new SaveValue('i', value));
    }

    public static void setBootups(int value){
        setDataFromKey(gameManager, "bootups", new SaveValue('i', value));
    }

    public static void setResolution(int value){
        setDataFromKey(gameManager, "resolution", new SaveValue('i', value));
    }

    public static void setBinaryVersion(int value){
        setDataFromKey(gameManager, "binaryVersion", new SaveValue('i', value));
    }

    public static void setHasRatedGame(boolean value){
        setDataFromKey(gameManager, "hasRatedGame", new SaveValue('t', value));
    }

    public static void setShownLowDetailDialog(boolean value){
        setDataFromKey(gameManager, "showedLowDetailDialog", new SaveValue('t', value));
    }

    public static void setShownRateStarDialog(boolean value){
        setDataFromKey(gameManager, "showedRateStarDialog", new SaveValue('t', value));
    }

    public static void setShownRateDifficultyDialog(boolean value){
        setDataFromKey(gameManager, "showedRateDiffDialog", new SaveValue('t', value));
    }

    public static void setShownEditorGuide(boolean value){
        setDataFromKey(gameManager, "showedEditorGuide", new SaveValue('t', value));
    }

    public static void setHasClickedPractice(boolean value){
        setDataFromKey(gameManager, "clickedPractice", new SaveValue('t', value));
    }

    public static void setHasClickedName(boolean value){
        setDataFromKey(gameManager, "clickedName", new SaveValue('t', value));
    }

    public static void setHasClickedEditor(boolean value){
        setDataFromKey(gameManager, "clickedEditor", new SaveValue('t', value));
    }

    public static void setHasClickedGarage(boolean value){
        setDataFromKey(gameManager, "clickedGarage", new SaveValue('t', value));
    }

    public static void setIsShowingProgressBar(boolean value){
        setDataFromKey(gameManager, "showProgressBar", new SaveValue('t', value));
    }

    public static String getUsername(){
        return (String) getDataFromKey(gameManager, "GJA_001");
    }

    public static String getPassword(){
        return (String) getDataFromKey(gameManager,"GJA_002");
    }

    public static long getAccountID(){
        return Long.parseLong((String) Objects.requireNonNull(getDataFromKey(gameManager,"GJA_003")));
    }

    public static int getBootups(){
        return Integer.parseInt((String) Objects.requireNonNull(getDataFromKey(gameManager,"bootups")));
    }

    public static int getResolution(){
        return Integer.parseInt((String) Objects.requireNonNull(getDataFromKey(gameManager,"resolution")));
    }

    public static int getBinaryVersion(){
        return Integer.parseInt((String) Objects.requireNonNull(getDataFromKey(gameManager,"binaryVersion")));
    }

    public static boolean hasRatedGame(){
        return Boolean.parseBoolean((String) Objects.requireNonNull(getDataFromKey(gameManager,"hasRatedGame")));
    }

    public static boolean shownLowDetailDialog(){
        return Boolean.parseBoolean((String) Objects.requireNonNull(getDataFromKey(gameManager,"showedLowDetailDialog")));
    }

    public static boolean shownRateStarDialog(){
        return Boolean.parseBoolean((String) Objects.requireNonNull(getDataFromKey(gameManager,"showedRateStarDialog")));
    }

    public static boolean shownRateDifficultyDialog(){
        return Boolean.parseBoolean((String) Objects.requireNonNull(getDataFromKey(gameManager,"showedRateDiffDialog")));
    }

    public static boolean shownEditorGuide(){
        return Boolean.parseBoolean((String) Objects.requireNonNull(getDataFromKey(gameManager,"showedEditorGuide")));
    }

    public static boolean hasClickedPractice(){
        return Boolean.parseBoolean((String) Objects.requireNonNull(getDataFromKey(gameManager,"clickedPractice")));
    }

    public static boolean hasClickedName(){
        return Boolean.parseBoolean((String) Objects.requireNonNull(getDataFromKey(gameManager,"clickedName")));
    }

    public static boolean hasClickedEditor(){
        return Boolean.parseBoolean((String) Objects.requireNonNull(getDataFromKey(gameManager,"clickedEditor")));
    }

    public static boolean hasClickedGarage(){
        return Boolean.parseBoolean((String) Objects.requireNonNull(getDataFromKey(gameManager,"clickedGarage")));
    }

    public static boolean isShowingProgressBar(){
        return Boolean.parseBoolean((String) Objects.requireNonNull(getDataFromKey(gameManager,"showProgressBar")));
    }

}
