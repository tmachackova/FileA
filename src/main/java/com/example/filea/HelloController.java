package com.example.filea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private BarChart chart;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws FileNotFoundException {
        Window window = ((Node)event.getTarget()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(window);

        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(new FileInputStream(file));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            stringBuilder.append(line).append("\n");
        }
        String fileContent = stringBuilder.toString();
        Map<Character, Integer> charCounter = new HashMap<>();
        for(int i = 0; i < file.length(); i++) {
            Character character = fileContent.charAt(i);
            if(charCounter.containsKey(character)) {
                Integer count = charCounter.get(character);
                count = count + 1;
                charCounter.put(character, count);
            } else {
                charCounter.put(character, 1);
            }
        }
        System.out.println(charCounter);

        XYChart.Series series=new XYChart.Series<>();

        series.getData().add(new XYChart.Data<>("A",4));
        series.getData().add(new XYChart.Data<>("B",40));
        series.getData().add(new XYChart.Data<>("C",100));
        series.getData().add(new XYChart.Data<>("D",10));
        series.getData().add(new XYChart.Data<>("E",150));
        series.getData().add(new XYChart.Data<>("F",70));
        series.getData().add(new XYChart.Data<>("G",79));
        series.getData().add(new XYChart.Data<>("H",79));
        series.getData().add(new XYChart.Data<>("I",5));
        series.getData().add(new XYChart.Data<>("J",40));
        series.getData().add(new XYChart.Data<>("K",100));
        series.getData().add(new XYChart.Data<>("L",10));
        series.getData().add(new XYChart.Data<>("M",150));
        series.getData().add(new XYChart.Data<>("N",70));
        series.getData().add(new XYChart.Data<>("O",79));
        series.getData().add(new XYChart.Data<>("P",79));
        series.getData().add(new XYChart.Data<>("Q",5));
        series.getData().add(new XYChart.Data<>("R",40));
        series.getData().add(new XYChart.Data<>("S",100));
        series.getData().add(new XYChart.Data<>("T",10));
        series.getData().add(new XYChart.Data<>("U",150));
        series.getData().add(new XYChart.Data<>("V",70));
        series.getData().add(new XYChart.Data<>("W",79));
        series.getData().add(new XYChart.Data<>("X",79));
        series.getData().add(new XYChart.Data<>("Y",79));
        series.getData().add(new XYChart.Data<>("Z",79));

        series.setName("LETTERS");
        chart.getData().add(series);


    }
}