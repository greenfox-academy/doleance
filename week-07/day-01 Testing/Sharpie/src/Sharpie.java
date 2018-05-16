/*
Create Sharpie class
We should know about each sharpie their color (which should be a string),
width (which will be a floating point number), inkAmount (another floating point number)
When creating one, we need to specify the color and the width
Every sharpie is created with a default 100 as inkAmount
We can use() the sharpie objects
which decreases inkAmount
 */

public class Sharpie {

    String color;
    float width;
    float inkAmount;
    float usingAmount = 0.5f;

    public Sharpie() {
        this.inkAmount = 10.0f;
    }

    public Sharpie(String color, float width) {
        this();
        this.color = color;
        this.width = width;
    }

    public void use() {
        if (inkAmount > usingAmount) {
            inkAmount -= usingAmount;
        } else {
            inkAmount = 0;
        }
    }

}
