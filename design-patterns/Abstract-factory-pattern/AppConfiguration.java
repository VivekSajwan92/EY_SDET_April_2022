package gui;

import org.example.App;

public class AppConfiguration {

    public static Application configure(String osName){
        Application app;
        UIFactory factory;
        if(osName.equals("mac")){
            factory = new MacFactory();
             return new Application(factory);
        }else if(osName.equals("windows")){
            factory = new WindowsFactory();
           return new Application(factory);
        }
        return null;
    }

    public static void main(String[] args) {
        Application mac = configure("windows");
        mac.paint();
    }
}
