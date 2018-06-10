package com.example.kamil.codelearn;

import java.util.ArrayList;

public class DB {
    private static DB instance = null;
    private ArrayList<Lecture> lectures;

    private DB() { 
    }

    /* Static 'instance' method */
    public static DB getInstance( ) {
        return instance;
    }

}
