interface SamrtDevice{
    void turnOff();
    void turnOn();

};

class Lights implements SamrtDevice{
    public void turnOff() {System.out.println("Lights Are Off!");}
    public void turnOn() {System.out.println("Lights Are On!");}
    
}


class AirConditioner implements SamrtDevice{
     public void turnOff() {System.out.println("AirConditioner Are Off!");}
    public void turnOn() {System.out.println("AirConditioner Are On!");}

}

class Television implements SamrtDevice{
     public void turnOff() {System.out.println("Television Are Off!");}
    public void turnOn() {System.out.println("Television Are On!");}
}

class SamrtDeviceControl{
    public static void main(String[] args) {
        Lights light = new Lights();
        AirConditioner ac = new AirConditioner();
        Television tv = new Television();

        light.turnOn();
        ac.turnOn();
        tv.turnOn();

        light.turnOff();
        ac.turnOff();
        tv.turnOff();

    }
}