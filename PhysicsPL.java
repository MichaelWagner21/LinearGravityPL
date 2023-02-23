// Force Range: 0-.1

public class PhysicsPL {
    int currentX;
    int currentY;

    double tempDistance = 0;

    double mass = 1;

    double forceGravity = 0;

    double forceGravityX = 0;
    double forceGravityY = 0;
    double generalForce = 0;

    double sinTheta = 0;
    double cosTheta = 0;

    double gravitationalConstant = 0;

    double forceX = MainPL.randNumDouble(-0.1,0.1);
    double forceY = MainPL.randNumDouble(-0.1,0.1);

    double accelerationX = forceX/mass;
    double accelerationY = forceY/mass;

    double velocityX = accelerationX*(MainPL.TIME);
    double velocityY = accelerationY*(MainPL.TIME);
    double generalVelocity = 0;

    final double TERMINALVELOCITY = 1;

    double displacementX = velocityX*(MainPL.TIME);
    double displacementY = velocityY*(MainPL.TIME);

    int newX;
    int newY;

    CirclesPL currentObj;

    public PhysicsPL(CirclesPL obj){
        currentObj = obj;
        currentX = currentObj.tempCurrentX;
        currentY = currentObj.tempCurrentY;
    }

    public void refresh(){


        //Below:cancels all inertia
        forceX = 0;
        forceY = 0;


        //Below: Calculates force of gravity for all other circles, and finds the sum of forces. 
        for (int c = 0; c<MainPL.circles.length; c++){
            if (twoDimDistance(currentX, currentY, MainPL.circles[c].currentBody.currentX, MainPL.circles[c].currentBody.currentY) > MainPL.DIAMETER){
                gravitationalConstant = ColorsPL.getColorAttraction(currentObj.objColor, MainPL.circles[c].objColor);
                
                if (twoDimDistance(currentX,currentY,MainPL.circles[c].currentBody.currentX,MainPL.circles[c].currentBody.currentY)>100){
                    tempDistance = twoDimDistance(currentX,currentY,MainPL.circles[c].currentBody.currentX,MainPL.circles[c].currentBody.currentY)
                    forceGravity = gravitationalConstant*Math.abs((-1*Math.abs(tempDistance-.75*200)+50)/50);
                }
                else {
                    tempDistance = twoDimDistance(currentX,currentY,MainPL.circles[c].currentBody.currentX,MainPL.circles[c].currentBody.currentY)
                    forceGravity = -0.2*Math.abs((-1*Math.abs(tempDistance-.75*200)+50)/50);
                }
                forceGravity = gravitationalConstant * 
                (twoDimDistance(currentX,currentY,MainPL.circles[c].currentBody.currentX,MainPL.circles[c].currentBody.currentY));


                sinTheta = oneDimDisplacement(currentY, MainPL.circles[c].currentBody.currentY)
                /twoDimDistance(currentX,currentY,MainPL.circles[c].currentBody.currentX,MainPL.circles[c].currentBody.currentY);

                cosTheta = oneDimDisplacement(currentX, MainPL.circles[c].currentBody.currentX)
                /twoDimDistance(currentX,currentY,MainPL.circles[c].currentBody.currentX,MainPL.circles[c].currentBody.currentY);
                
                
                forceGravityX = cosTheta*forceGravity;
                forceGravityY = sinTheta*forceGravity;

                
                forceX+=forceGravityX;
                forceY+=forceGravityY;
            } 
        }

        
        generalForce = Math.sqrt(Math.pow(forceX,2) + Math.pow(forceY,2));

 
        //Below If Statements: If outside edge and headed outside of bounds, bounce off edge.
        if (currentX-MainPL.XBOUND>=0 && forceX>=0){
            forceX = -1*Math.abs(forceX);
        }

        if (currentX<=0 && forceX<=0){
            forceX = Math.abs(forceX);
        }

        if (currentY-MainPL.YBOUND>=-10 && forceY>=0){
            forceY = -1*Math.abs(forceY);
        }

        if (currentY<=0 && forceY<=0){
            forceY = Math.abs(forceY);
        }


        accelerationX = forceX/mass;
        accelerationY = forceY/mass;

        velocityX = accelerationX*MainPL.TIME;
        velocityY = accelerationY*MainPL.TIME;
        generalVelocity = Math.sqrt(Math.pow(velocityX,2)+Math.pow(velocityY,2));

        //Below: Ensures that object velocity is never above terminal velocity

        if (generalVelocity>TERMINALVELOCITY){
            velocityX = (TERMINALVELOCITY/generalVelocity)*velocityX;
            velocityY = (TERMINALVELOCITY/generalVelocity)*velocityY;
            forceX = (velocityX*mass)/MainPL.TIME;
            forceY = (velocityY*mass)/MainPL.TIME;
        }



        displacementX = velocityX*MainPL.TIME;
        displacementY = velocityY*MainPL.TIME;
        
        newX=currentX+(int)Math.round(displacementX);
        newY=currentY+(int)Math.round(displacementY);

        currentObj.setCoords(newX,newY);
        
        //Below: After obj's coords become newX and newY, they also become the current coords. 
        currentX = newX;
        currentY = newY;
        
        MainPL.refresh(MainPL.appFrame);



    }

    public static double twoDimDistance(double x1, double y1, double x2, double y2){
        double verDis = y2-y1;
        double horDis = x2-x1;
        double diagDis = Math.sqrt(verDis*verDis+horDis*horDis);
        return diagDis;
    }

    public static double oneDimDisplacement(double x1, double x2){
        return (x2-x1);
    }
}