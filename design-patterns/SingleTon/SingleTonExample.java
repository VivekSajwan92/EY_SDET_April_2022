package org.example;

public class SingleTonExample {


    // have a private constructor

    // have a private static memeber in the class

    private static  SingleTonExample singleTonExample=new SingleTonExample();

    public static SingleTonExample singleTonExample1;

    private SingleTonExample(){

    }

    {
        singleTonExample1=new SingleTonExample();
    }

    // have a public static method

    // early instantiation
    //lazy instantation

    public static SingleTonExample getInstance(){
        if(singleTonExample==null){
            singleTonExample= new SingleTonExample();
        }
        return  singleTonExample;

    }

    public static void main(String[] args) {
    }
}
