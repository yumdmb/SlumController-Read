// 4) Total job partition each month

package javaFX;

import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
public class jobPartitionByMonth_BarChart extends Application {
    public void start(Stage stage) {
        //Creating X and Y axes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        //Adding labels for the axes
        yAxis.setLabel("Job done");
        xAxis.setLabel("Number of Jobs by Partition Jun-Dec");
        //Creating a Bar chart
        BarChart barChart = new BarChart<>(xAxis, yAxis);

        //Preparing data for the bar chart
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("gpu-v100s");
        series1.getData().add(new XYChart.Data("JUNE", 224));
        series1.getData().add(new XYChart.Data("JULY", 75));
        series1.getData().add(new XYChart.Data("AUGUST", 8));
        series1.getData().add(new XYChart.Data("SEPTEMBR", 30));
        series1.getData().add(new XYChart.Data("OCTOBER", 175));
        series1.getData().add(new XYChart.Data("NOVEMBER", 39));
        series1.getData().add(new XYChart.Data("DECEMBER", 37));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("cpu-opteron");
        series2.getData().add(new XYChart.Data("JUNE", 961));
        series2.getData().add(new XYChart.Data("JULY", 561));
        series2.getData().add(new XYChart.Data("AUGUST", 489));
        series2.getData().add(new XYChart.Data("SEPTEMBR", 808));
        series2.getData().add(new XYChart.Data("OCTOBER", 990));
        series2.getData().add(new XYChart.Data("NOVEMBER", 452));
        series2.getData().add(new XYChart.Data("DECEMBER", 248));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("gpu-k10");
        series3.getData().add(new XYChart.Data("JUNE", 115));
        series3.getData().add(new XYChart.Data("JULY", 63));
        series3.getData().add(new XYChart.Data("AUGUST", 62));
        series3.getData().add(new XYChart.Data("SEPTEMBR", 62));
        series3.getData().add(new XYChart.Data("OCTOBER", 78));
        series3.getData().add(new XYChart.Data("NOVEMBER", 35));
        series3.getData().add(new XYChart.Data("DECEMBER", 13));

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("gpu-titan");
        series4.getData().add(new XYChart.Data("JUNE", 212));
        series4.getData().add(new XYChart.Data("JULY", 89));
        series4.getData().add(new XYChart.Data("AUGUST", 82));
        series4.getData().add(new XYChart.Data("SEPTEMBR", 69));
        series4.getData().add(new XYChart.Data("OCTOBER", 75));
        series4.getData().add(new XYChart.Data("NOVEMBER", 55));
        series4.getData().add(new XYChart.Data("DECEMBER", 58));

        XYChart.Series series5 = new XYChart.Series();
        series5.setName("cpu-epyc");
        series5.getData().add(new XYChart.Data("JUNE", 612));
        series5.getData().add(new XYChart.Data("JULY", 481));
        series5.getData().add(new XYChart.Data("AUGUST", 573));
        series5.getData().add(new XYChart.Data("SEPTEMBR", 233));
        series5.getData().add(new XYChart.Data("OCTOBER", 441));
        series5.getData().add(new XYChart.Data("NOVEMBER", 258));
        series5.getData().add(new XYChart.Data("DECEMBER", 158));

        XYChart.Series series6 = new XYChart.Series();
        series6.setName("gpu-k40c");
        series6.getData().add(new XYChart.Data("JUNE", 67));
        series6.getData().add(new XYChart.Data("JULY", 35));
        series6.getData().add(new XYChart.Data("AUGUST", 18));
        series6.getData().add(new XYChart.Data("SEPTEMBR", 51));
        series6.getData().add(new XYChart.Data("OCTOBER", 19));
        series6.getData().add(new XYChart.Data("NOVEMBER", 68));
        series6.getData().add(new XYChart.Data("DECEMBER", 37));
        //Setting the data to bar chart
        barChart.getData().addAll(series1, series2, series3, series4, series5,series6);
        //Setting the legend on the top
        barChart.setLegendSide(Side.RIGHT);
        //Creating a stack pane to hold the chart
        StackPane pane = new StackPane(barChart);
        //Setting the Scene
        Scene scene = new Scene(pane, 595, 300);
        stage.setTitle("Bar Chart");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
