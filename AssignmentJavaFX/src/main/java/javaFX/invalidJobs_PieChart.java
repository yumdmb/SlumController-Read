// 7)Total invalid jobs
package javaFX;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class invalidJobs_PieChart extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Invalid Job");
        stage.setWidth(550);
        stage.setHeight(550);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Qos Specification (157)", 157),
                        new PieChart.Data("Account (52)", 52),
                        new PieChart.Data("MonthJob Id Specified (50)", 50),
                        new PieChart.Data("Partition Name Specified (47)",47),
                        new PieChart.Data("Node Name Specified (4)",4 ),
                        new PieChart.Data("User Id (4)",4 ),
                        new PieChart.Data("Group Id (1)",1));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("TYPES OF INVALID JOB FROM JUNE TO DECEMBER");


        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
