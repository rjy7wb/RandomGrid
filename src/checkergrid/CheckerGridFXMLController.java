/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkergrid;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author dale
 */
public class CheckerGridFXMLController implements Initializable, Startable {
    
    private Stage stage;
    
    private int numRows = 8;
    private int numColumns = 8;
    
    private Color[] colors = {Color.RED, Color.BLACK, Color.ORANGE, Color.GREEN};
    
    private grid.CheckerGrid checkerGrid;
   
    @FXML
    private VBox vBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } 

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        
        checkerGrid = new grid.CheckerGrid(numRows, numColumns,800.00,600.00);
        vBox.getChildren().add(checkerGrid.getBoard());
        
        /*
        this.gridPane.widthProperty().addListener(new ChangeListener<Number>() {
            @Override 
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
                refresh();
            }
        });
        
        this.gridPane.heightProperty().addListener(new ChangeListener<Number>() {
            @Override 
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) {
                refresh();
            }
        });
        */
        
        this.stage.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        });
        
        this.stage.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        });
        
        
        ChangeListener<Number> lambdaChangeListener;
        lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh();
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        refresh();

        
    }

    @FXML
    private void handleRefresh(ActionEvent event) {
        refresh();
    }
    
    @FXML
    private void handleClear(ActionEvent event) {
        System.out.println("clear");
        clearGridPane();
    }
    
    @FXML
    private void setAltColor(ActionEvent event) {
        refresh();
    }
    
    @FXML
    private void setDefaultColor(ActionEvent event) {
        
        refresh();
    }
    
    @FXML
    private void handleAbout(Event event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("RandomGrid");
        alert.setContentText("This application was developed by Dale Musser for CS4330/7330 at the University of Missouri.  This is based on the code provided at http://code.makery.ch/blog/javafx-dialogs-official/");
        alert.showAndWait();
    }
    
    @FXML
    private void handle16by16(ActionEvent event) {
        this.numColumns = 16;
        this.numRows = 16;
        refresh();
    }
    
    @FXML
    private void handle8by8(ActionEvent event) {
        this.numColumns = 8;
        this.numRows = 8;
        refresh();
    }
    
    @FXML
    private void handle10by10(ActionEvent event) {
        this.numColumns = 16;
        this.numRows = 16;
        refresh();
    }
    
    @FXML
    private void handle3by3(ActionEvent event) {
        this.numColumns = 3;
        this.numRows = 3;
        refresh();
    }
    
    private void refresh() {
        checkerGrid.build(stage.getWidth(), stage.getHeight());
    }
    
    private void clearGridPane() {
        checkerGrid.clear();
    }
}
