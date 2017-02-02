
package tetris;

import java.awt.Color;


public class Rect {
    private int rectCoords [];
    private Color clr;
    private int numb = 0;
    
    public Rect(int rc [], Color c, int numb){
        //rectCoords = new int [4];
        rectCoords = rc;
        clr = c;
        this.numb = numb;
    }

    public int[] getRectCoords() {
        return rectCoords;
    }

    public void setRectCoords(int[] rectCoords) {
        this.rectCoords = rectCoords;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public Color getClr() {
        return clr;
    }

    public void setClr(Color clr) {
        this.clr = clr;
    }

    
    
}
