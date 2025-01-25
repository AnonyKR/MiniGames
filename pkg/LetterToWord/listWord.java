package pkg.LetterToWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class listWord {
    private ArrayList<String> names;
    private String[][] superList;
    private ArrayList<String> toCheck;
    private ArrayList<String> comment;
    private Scanner sc;
    private HashSet<String> dictionary = new HashSet<>();


    private void loadAllWordFiles(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Invalid SCOWL directory path: " + directoryPath);
            return;
        }

        // Recursively load all files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    loadWordsFromFile(file);
                } else if (file.isDirectory()) {
                    // Process subdirectories recursively
                    loadAllWordFiles(file.getAbsolutePath());
                }
            }
        }
    }

    private void loadWordsFromFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null) {
                dictionary.add(line.trim().toLowerCase());
            }
            System.out.println("Loaded words from file: " + file.getName());
        } catch (IOException e) {
            System.err.println("Error reading file " + file.getName() + ": " + e.getMessage());
        }
    }

    public listWord() {
        toCheck = new ArrayList<>();
        comment = new ArrayList<>();
        String scowlDirectoryPath = "C://Users/Yunu Choi/Downloads/scowl-2020.12.07/final"; // Adjust this to your SCOWL directory path
        loadAllWordFiles(scowlDirectoryPath);
        sc = new Scanner(System.in);
        names = new ArrayList<>();
        superList = null;
    }

    public void addName(String name) {
        this.names.add(name);
    }

    private void populateSuperList() {
        int idx = 0;
        this.superList = new String[this.names.size()][4];
        for (String name: this.names) {
            String[] nameParts = name.split(" ");
            this.superList[idx][0] = nameParts[0].substring(0, 1);
            this.superList[idx][1] = nameParts[0].substring(0, 2);
            this.superList[idx][2] = nameParts[1].substring(0, 1);
            this.superList[idx][3] = nameParts[1].substring(0, 2);
            idx++;
        }

    }

    public void checkAll() {        
        this.populateSuperList();

        int[] order = new int[superList.length];
        ArrayList<Integer> toAdd = new ArrayList<>();
        for (int i = 0; i < superList.length; i++) {
            toAdd.add(i);
        }
        check(order, toAdd);
    }

    public void check(int[] order, ArrayList<Integer> toAdd) {
        if(!toAdd.isEmpty()) {
            for (int obj : toAdd) {
                ArrayList<Integer> copy = (ArrayList<Integer>) toAdd.clone();
                int[] orderCopy = order;
                orderCopy[order.length - toAdd.size()] = obj;
                copy.remove(copy.indexOf(obj));
                check(orderCopy, copy);
            }
        } else {
            checkOrder(order);
        }
    }

    public void checkOrder(int[] order) {
        int[] i = new int[order.length];
        int max = superList[0].length;
        String before = "";
        while(true) {
            String checkStr = "";
            for(int n = 0; n < i.length; n++) {
                checkStr += superList[order[n]][i[n]];
            }
            if (!checkStr.equals(before) && this.checkWord(checkStr)) {
                before = checkStr;
                System.out.print(checkStr + ": ");
                String response = sc.nextLine();
                if(!response.isEmpty()) {                    
                    toCheck.add(checkStr);
                    comment.add(response);
                }
            }
            //Adding
            int k = i.length - 1;
            while (true) { 
                if(i[k] == max - 1) {
                    i[k] = 0;
                    if (k == 0) {
                        return;
                    }
                    k--;
                } else {
                    i[k] += 1;
                    break;
                }
            }
        }
    }

    public boolean checkWord(String word) {
        return dictionary.contains(word.toLowerCase());
    }

    public void printSave() {
        for (int i = 0; i < toCheck.size(); i++) {
            System.out.println(toCheck.get(i));
            System.out.println("Comment: " + comment.get(i) + "\n");
        }
    }
}
