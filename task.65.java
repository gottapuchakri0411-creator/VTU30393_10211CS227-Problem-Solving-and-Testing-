import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

class Singleton{
    private static Singleton singleInstance = null;
    public String str;

    private Singleton() {}

    public static Singleton getSingleInstance() {
        if (singleInstance == null) {
            singleInstance = new Singleton();
        }
        return singleInstance;
    }
}


