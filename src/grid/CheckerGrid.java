/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Randall
 */
public class CheckerGrid extends Grid {
    
    private Color lightColor;
    private Color darkColor;
    private final Color[] colors = {this.lightColor,this.darkColor};
    public CheckerGrid(int rows, int columns,double boardWidth, double boardHeight) {
        this(rows,columns,boardWidth,boardHeight,Color.RED,Color.BLACK);
    }
    
    public CheckerGrid(int rows, int columns,double boardWidth, double boardHeight,Color lightColor, Color darkColor) {
        super(rows, columns);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
        colors[0] = this.lightColor;
        colors[1] = this.darkColor;        
    }
    
    @Override
    public GridPane build(double width, double height) {
        super.build(width, height);
        int numColors = colors.length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <columns; col++) {
                Color color = colors[(row+col)%2];
                Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight, color);
                
                gridPane.add(rect, row, col);
            }
        }
        
        return gridPane;
    }
    
    public Color getLightColor() {
        return this.lightColor;
    }
    
    public Color getDarkColor() {
        return this.darkColor;
    }
}
