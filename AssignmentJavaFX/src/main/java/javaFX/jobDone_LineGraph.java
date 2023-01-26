package javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class jobDone_LineGraph extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Line Chart ");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");

        final LineChart<String,Number> lineChart =
                new LineChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("JOB DONE BY MONTH JUN-DEC");

        XYChart.Series series = new XYChart.Series();
        series.setName("TOTAL JOB DONE : 8479");


        series.getData().add(new XYChart.Data("Jun", 1893));
        series.getData().add(new XYChart.Data("Jul", 1139));
        series.getData().add(new XYChart.Data("Aug", 1186));
        series.getData().add(new XYChart.Data("Sep", 1153));
        series.getData().add(new XYChart.Data("Oct", 1564));
        series.getData().add(new XYChart.Data("Nov", 1092));
        series.getData().add(new XYChart.Data("Dec", 452));


        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}