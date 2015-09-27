package com.canada.victor.criminalintent.database;

/**
 * Created by Víctor Cañada Ojeda on 27/9/15.
 * victorcanoje@gmail.com
 */


public class CrimeDbSchema {
    public static final class CrimeTable {
        public static final String NAME = "crimes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }
}

