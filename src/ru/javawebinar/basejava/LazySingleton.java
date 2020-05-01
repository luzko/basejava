package ru.javawebinar.basejava;

public class LazySingleton {
    int i;
    volatile private static LazySingleton INSTANCE;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if(INSTANCE == null) {
            synchronized (LazySingleton.class) {
                if(INSTANCE == null) {
                    int i = 13;
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}
