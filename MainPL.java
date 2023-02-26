import java.util.Random;

import javax.swing.SwingUtilities;


public class MainPL {
    static WindowPL appFrame = new WindowPL();
    
    
    final static int XBOUND = 775;
    final static int YBOUND = 750;
    
    
    final static double TIME = 10;
    final static int DIAMETER = 8;

    private final static int CIRCLEAMOUNT = 50;

    static CirclesPL[] circles = new CirclesPL[CIRCLEAMOUNT];
    
    public static void main(String[] args){

        System.out.print("\033[H\033[2J");

        ColorsPL.setColorAttractors();

        for (int c = 0; c<CIRCLEAMOUNT; c++){
            if (c<CIRCLEAMOUNT/5){
                circles[c] = new CirclesPL("red");
            }
            else if (c<2*CIRCLEAMOUNT/5){
                circles[c] = new CirclesPL("blue");
            }
            else if (c<3*CIRCLEAMOUNT/5){
                circles[c] = new CirclesPL("yellow");
            }
            else if (c<4*CIRCLEAMOUNT/5){
                circles[c] = new CirclesPL("green");
            }
            else {
                circles[c] = new CirclesPL("orange");
            }
            
            appFrame.add(circles[c]);
        }


        while (true){
            refreshAllObjsIn(circles);
            wait((int)TIME);
        }
        


        

    }

    public static void wait(int t){
        try {
            Thread.sleep(t);
          } 
        catch (InterruptedException ex) {
    
            Thread.currentThread().interrupt();
          }
    }

    public static void refresh(WindowPL w){
        SwingUtilities.updateComponentTreeUI(w);
    }

    public static int randNum(double min, double max){
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static double randNumDouble(double min, double max){
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

    public static void refreshAllObjsIn(CirclesPL[] circlesList){
        for (int i = 0; i<circlesList.length; i++){
            circlesList[i].currentBody.refresh();
        }
    }
}