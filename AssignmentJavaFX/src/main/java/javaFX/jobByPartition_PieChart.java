//  2)Total job by partition

package javaFX;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;


public class jobByPartition_PieChart extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Job created");
        stage.setWidth(550);
        stage.setHeight(550);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("GPU-V100s (618) ", 618),
                        new PieChart.Data("GPU-K10 (439)", 439),
                        new PieChart.Data("GPU-Titan (673)", 673),
                        new PieChart.Data("GPU-K40c (301)",301),
                        new PieChart.Data("CPU-Opteron (4920)",4920 ),
                        new PieChart.Data("CPU-EPYC (3015)",3015 ));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("NUMBER OF JOB CREATED BY PARTITONS FROM JUNE TO DECEMBER");


        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
