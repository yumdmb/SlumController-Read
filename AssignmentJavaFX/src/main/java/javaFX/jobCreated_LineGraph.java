// 1)Job Created

package javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


public class jobCreated_LineGraph extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Line Chart ");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");

        final LineChart<String,Number> lineChart =
                new LineChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("JOB CREATED BY MONTH JUN-DEC");

        XYChart.Series series = new XYChart.Series();
        series.setName("TOTAL JOB CREATED : 9966");


        series.getData().add(new XYChart.Data("Jun", 2219));
        series.getData().add(new XYChart.Data("Jul", 1329));
        series.getData().add(new XYChart.Data("Aug", 1485));
        series.getData().add(new XYChart.Data("Sep", 1352));
        series.getData().add(new XYChart.Data("Oct", 1801));
        series.getData().add(new XYChart.Data("Nov", 1181));
        series.getData().add(new XYChart.Data("Dec", 599));


        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}