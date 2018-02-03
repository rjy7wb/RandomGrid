/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkergrid;

import javafx.scene.paint.Color;
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
 * @author Randall
 */
public class CheckerGridFXMLController implements Initializable, Startable {
    
    private Stage stage;
    
    private int numRows = 8;
    private int numColumns = 8;
    
    private final Color[] colors = {Color.RED, Color.BLACK, Color.ORANGE, Color.GREEN};
    
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
        clearGridPane();
        checkerGrid = new grid.CheckerGrid(this.numRows, this.numColumns, 800.00,600.00,Color.ORANGE,Color.GREEN);
        vBox.getChildren().add(checkerGrid.getBoard());
        refresh();
    }
    
    @FXML
    private void setDefaultColor(ActionEvent event) {
        clearGridPane();
        checkerGrid = new grid.CheckerGrid(this.numRows, this.numColumns, 800.00,600.00);
        vBox.getChildren().add(checkerGrid.getBoard());
        refresh();
    }
    
    @FXML
    private void handleAbout(Event event) {
    }
    
    @FXML
    private void handle16by16(ActionEvent event) {
        this.numColumns = 16;
        this.numRows = 16;
        clearGridPane();
        checkerGrid = new grid.CheckerGrid(this.numRows, this.numColumns, 800.00,600.00);
        vBox.getChildren().add(checkerGrid.getBoard());
        refresh();
        
    }
    
    @FXML
    private void handle8by8(ActionEvent event) {
        this.numColumns = 8;
        this.numRows = 8;
        clearGridPane();
        checkerGrid = new grid.CheckerGrid(this.numRows, this.numColumns, 800.00,600.00);
        vBox.getChildren().add(checkerGrid.getBoard());
        refresh();
    }
    
    @FXML
    private void handle10by10(ActionEvent event) {
        this.numColumns = 10;
        this.numRows = 10;
        clearGridPane();
        checkerGrid = new grid.CheckerGrid(this.numRows, this.numColumns, 800.00,600.00);
        vBox.getChildren().add(checkerGrid.getBoard());
        refresh();
    }
    
    @FXML
    private void handle3by3(ActionEvent event) {
        this.numColumns = 3;
        this.numRows = 3;
        clearGridPane();
        checkerGrid = new grid.CheckerGrid(this.numRows, this.numColumns, 800.00,600.00);
        vBox.getChildren().add(checkerGrid.getBoard());
        refresh();
    }
    
    private void refresh() {
        checkerGrid.build(stage.getWidth(), stage.getHeight());
    }
    
    private void clearGridPane() {
        checkerGrid.clear();
    }
}
