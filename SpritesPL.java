import javax.swing.ImageIcon;


public class SpritesPL {
    public static ImageIcon redCircleSprite(){
        final ImageIcon redTemp = new ImageIcon("RedCircle.png");
        return redTemp;
    } 

    public static ImageIcon blueCircleSprite(){
        final ImageIcon blueTemp = new ImageIcon("BlueCircle.png");
        return blueTemp;
    } 

    public static ImageIcon yellowCircleSprite(){
        final ImageIcon yellowTemp = new ImageIcon("YellowCircle.png");
        return yellowTemp;
    } 

    public static ImageIcon greenCircleSprite(){
        final ImageIcon greenTemp = new ImageIcon("GreenCircle.png");
        return greenTemp;
    } 

    public static ImageIcon orangeCircleSprite(){
        final ImageIcon orangeTemp = new ImageIcon("OrangeCircle.png");
        return orangeTemp;
    } 

    public static ImageIcon randomSprite(){
        System.out.println("Something Went Wrong, randomSprite is an antiquated method");
        int tempRand = (int)Math.floor(Math.random() *(5 - 1 + 1) + 1);
        
        if (tempRand==1){
            return redCircleSprite();
        }
        else if (tempRand==2){
            return blueCircleSprite();
        }
        else if (tempRand==3){
            return yellowCircleSprite();
        }
        else if (tempRand==4){
            return greenCircleSprite();
        }
        else {
            return orangeCircleSprite();
        }
    }
}
