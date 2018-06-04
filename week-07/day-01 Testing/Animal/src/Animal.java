/*
Create an Animal class
Every animal has a hunger value, which is a whole number
Every animal has a thirst value, which is a whole number
  when creating a new animal object these values are created with the default 50 value
Every animal can eat() which decreases their hunger by one
Every animal can drink() which decreases their thirst by one
Every animal can play() which increases both by one
*/

public class Animal {
    int hunger;
    int thirst;

    public Animal() {
        this.hunger = 50;
        this.thirst = 50;
    }

    public void eat() {
        if (!(this.hunger == 0)) {
            hunger--;
        }
    }

    public void drink() {
        if (!(this.thirst == 0)) {
            thirst--;
        }
    }

    public void play() {
        hunger++;
        thirst++;
    }

}