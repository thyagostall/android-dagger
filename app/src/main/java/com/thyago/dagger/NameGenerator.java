package com.thyago.dagger;

import java.util.Random;

/**
 * Created by thyago on 17/01/2017.
 */

public class NameGenerator {

    private String[] firstNames = new String[] {
            "Joshua", "Daniel", "Matthew",
            "James", "Thomas", "Jack"
    };

    private String[] lastNames = new String[] {
            "Smith", "Martin", "Brown",
            "Johnson"
    };

    public String getName() {
        Random r = new Random();
        int f = r.nextInt(firstNames.length);
        int l = r.nextInt(lastNames.length);

        return firstNames[f] + " " + lastNames[l];
    }
}
