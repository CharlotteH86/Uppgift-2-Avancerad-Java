package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    //Path/länk till csv filen
    static String srcPath = "src/sample.csv";
    static ArrayList<ListCsv> csv = new ArrayList<ListCsv>();

    public static void main(String[] args){
        File();
        StartUserInterface();
    }

    //Kör swing interfacet
    public static void StartUserInterface() {
        JFrame frame = new JFrame("CSV DOCUMENT");


        //lägger till information från csv arraylisten
        ArrayList<ArrayList<String>> headList = new ArrayList<ArrayList<String>>();
        for (int i =1; i< csv.size(); i++){
            ArrayList<String> items = new ArrayList<String>();
            items.add(csv.get(i).getOrderDate());
            items.add(csv.get(i).getRegion());
            items.add(csv.get(i).getRep1());
            items.add(csv.get(i).getRep2());
            items.add(csv.get(i).getItem());
            items.add(csv.get(i).getUnits());
            items.add(csv.get(i).getUnitCost());
            items.add(csv.get(i).getTotal());
            headList.add(items);



        }

        //Skapar en string matrix av tabellen(csv) och lägger till i swing UI
        String[][] data = headList.stream().map(item -> item.toArray(new String[0])).toArray(String[][]::new);
        String[] columnNames = { csv.get(0).getOrderDate(), csv.get(0).getRegion(), csv.get(0).getRep1(),
                csv.get(0).getRep2(), csv.get(0).getItem(), csv.get(0).getUnits(), csv.get(0).getUnitCost(),
                csv.get(0).getTotal() };
        JTable table = new JTable(data, columnNames);
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
        };

        //Kod för att sortera kolumnerna
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        
        //lägger till element i UIn
        table.setModel(tableModel);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(30, 30, 820, 500);
        frame.add(pane);

        frame.getContentPane().setBackground(Color.pink);
        frame.setSize(900, 650);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }




    //Läser av CSV dokumentet
    private static void File(){
        String line="";
        try {
            BufferedReader bReader= new BufferedReader(new FileReader(srcPath));
            while (line!= null){
                line = bReader.readLine();
                if (line != null){
                    ListCsv row = new ListCsv(line);
                    csv.add(row);
                }


            }
            bReader.close();
        }catch (FileNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            e.printStackTrace();
        }

    }




}
