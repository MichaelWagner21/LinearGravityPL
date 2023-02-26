import java.awt.Color;

import javax.swing.JLabel;


public class CirclesPL extends JLabel{

    int tempCurrentX;
    int tempCurrentY;

    PhysicsPL currentBody;

    String objColor;
    
    
    public CirclesPL(){
        objColor = ColorsPL.randColor();
        int x = MainPL.randNum(0,MainPL.XBOUND);
        int y = MainPL.randNum(0,MainPL.YBOUND);
        this.setIcon(ColorsPL.getSprite(objColor));
        this.setBackground(new Color (0,0,0));
        this.setOpaque(true);
        this.setCoords(x,y);
        currentBody = new PhysicsPL(this);

    }

    public CirclesPL(String spriteColor){
        objColor = spriteColor;
        int x = MainPL.randNum(0,MainPL.XBOUND);
        int y = MainPL.randNum(0,MainPL.YBOUND);
        this.setIcon(ColorsPL.getSprite(objColor));
        this.setBackground(new Color (0,0,0));
        this.setOpaque(true);
        this.setCoords(x,y);
        currentBody = new PhysicsPL(this);

    }


    public CirclesPL(int x, int y){
        objColor = ColorsPL.randColor();
        this.setIcon(ColorsPL.getSprite(objColor));
        this.setBackground(new Color (0,0,0));
        this.setOpaque(true);
        this.setCoords(x, y);
        currentBody = new PhysicsPL(this);

    }


    public CirclesPL(int x, int y, String spriteColor){
        objColor = spriteColor;
        this.setIcon(ColorsPL.getSprite(objColor));
        this.setBackground(new Color (0,0,0));
        this.setOpaque(true);
        this.setCoords(x, y);
        currentBody = new PhysicsPL(this);

    }


    public void setCoords(int x, int y){
        setBounds(x,750-y,MainPL.DIAMETER,MainPL.DIAMETER);
        tempCurrentX = x;
        tempCurrentY = y;
    }

    

}
