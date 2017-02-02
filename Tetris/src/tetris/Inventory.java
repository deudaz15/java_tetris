
package tetris;

import java.util.ArrayList;


public class Inventory{

    private ArrayList<Rect> rects;
        
        public Inventory(){
            rects = new ArrayList();
        }
    
    public void add(Rect rc){
            rects.add(rc);
        }
    
    public void remove(int i){
        rects.remove(i);
    }
    
    public void change(int i, Rect r){
        rects.get(i).setClr(r.getClr());
        rects.get(i).setRectCoords(r.getRectCoords());
    }

    public ArrayList<Rect> getRects() {return rects;}

    public void setRects(ArrayList<Rect> rects) { this.rects = rects;}
    
    
}
