package ru.geekbrains.lifecycle;

public final class MainPresenter {
    private static MainPresenter instance = null;

    private static final Object syncObj = new Object();

    private int counter;

    private MainPresenter(){
        counter = 0;
    }

    public void counterIncrement(){
        synchronized (syncObj) {
            counter++;
        }
    }

    public int getCounter(){
        return counter;
    }

    public static MainPresenter getInstance(){
        synchronized (syncObj){
            if (instance == null){
                instance = new MainPresenter();
            }
            return instance;
        }
    }

}
