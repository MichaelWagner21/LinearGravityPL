import javax.swing.ImageIcon;

public class ColorsPL {
    static double[][] colorAttractions = new double[5][5];
    //static double[][] colorAttractions = {{1,.5,-.2,-.2,-.4},{-.4,1,.5,-.2,-.2},{-.2,-.4,1,.5,-.2},{-.2,-.2,-.4,1,.5},{.5,-.2,-.2,-.4,1}};
    static String[] colorList = {"red","blue","yellow","green","orange"};
    private static int colorIndex1 = 0;
    private static int colorIndex2 = 0;
    private static int spriteIndex = 0;
    private static int randStringIndex = 0;
    
    public static void setColorAttractors(){
        for (int f = 0; f<colorAttractions.length; f++){
            for (int s = 0; s<colorAttractions.length; s++){
                colorAttractions[f][s] = MainPL.randNumDouble(-0.1,0.1);
            }
        }
    }
    
    public static double getColorAttraction(String colorInput1, String colorInput2){
        for (int i = 0; i<colorList.length; i++){
            if (colorInput1.equals(colorList[i])){
                colorIndex1 = i;
            }
            if (colorInput2.equals(colorList[i])){
                colorIndex2 = i;
            }
        }
        return colorAttractions[colorIndex1][colorIndex2];
    }

    public static ImageIcon getSprite(String color){
        for (int i = 0; i<colorList.length; i++){
            if (color.equals(colorList[i])){
                spriteIndex = i;
            }
        }
        if (spriteIndex == 0){
            return SpritesPL.redCircleSprite();
        }
        else if (spriteIndex == 1){
            return SpritesPL.blueCircleSprite();
        }
        else if (spriteIndex == 2){
            return SpritesPL.yellowCircleSprite();
        }
        else if (spriteIndex == 3){
            return SpritesPL.greenCircleSprite();
        }
        else if (spriteIndex == 4){
            return SpritesPL.orangeCircleSprite();
        }
        else {
            return SpritesPL.randomSprite();
        }
    }

    public static String randColor(){
        randStringIndex = MainPL.randNum(0,4);
        return colorList[randStringIndex];
    }
}
