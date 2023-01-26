// 3) Job error bu user

package javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class jobError_Table extends Application {


    @Override
    public void start(Stage primaryStage) {

        TableView tableView = new TableView();

        TableColumn<Person, String> column1 =
                new TableColumn<>("Name");

        column1.setCellValueFactory(
                new PropertyValueFactory<>("Name"));


        TableColumn<Person, String> column2 =
                new TableColumn<>("Error");

        column2.setCellValueFactory(
                new PropertyValueFactory<>("Error"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        tableView.getItems().add(
                new Person("farhatabjani", "3"));
        tableView.getItems().add(
                new Person("yatyuen.lim", "1"));
        tableView.getItems().add(
                new Person("aah", "12"));
        tableView.getItems().add(
                new Person("lin0618", "4"));
        tableView.getItems().add(
                new Person("janvik", "4"));
        tableView.getItems().add(
                new Person("xinpeng", "1"));
        tableView.getItems().add(
                new Person("kurk", "1"));
        tableView.getItems().add(
                new Person("htt_felicia", "21"));
        tableView.getItems().add(
                new Person("hva170037", "5"));
        tableView.getItems().add(
                new Person("mk_98", "24"));
        tableView.getItems().add(
                new Person("han", "11"));
        tableView.getItems().add(
                new Person("fairus", "10"));
        tableView.getItems().add(
                new Person("f4ww4z", "4"));
        tableView.getItems().add(
                new Person("manoj", "4"));
        tableView.getItems().add(
                new Person("ongkuanhung", "1"));
        tableView.getItems().add(
                new Person("shahreeza", "6"));
        tableView.getItems().add(
                new Person("liew.wei.shiung", "3"));
        tableView.getItems().add(
                new Person("hass", "1"));
        tableView.getItems().add(
                new Person("hongvin", "9"));
        tableView.getItems().add(
                new Person("chiuling", "2"));
        tableView.getItems().add(
                new Person("lobbeytan", "3"));
        tableView.getItems().add(
                new Person("fahmi8", "1"));
        tableView.getItems().add(
                new Person("aznul", "2"));
        tableView.getItems().add(
                new Person("tingweijing", "2"));
        tableView.getItems().add(
                new Person("noraini", "4"));
        tableView.getItems().add(
                new Person("roland", "4"));

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public class Person {

        private String Name = null;
        private String Error = null;
    
        public Person() {
        }
    
        public Person(String Name, String Error) {
            this.Name = Name;
            this.Error = Error;
        }
    
        public String getName() {
            return Name;
        }
    
        public void setName(String Name) {
            this.Name = Name;
        }
    
        public String getError() {
            return Error;
        }
    
        public void setError(String Error) {
            this.Error= Error;
        }
    }

    public static void main(String[] args) {
        launch();
    }

}


 