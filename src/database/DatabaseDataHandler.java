package database;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseDataHandler implements DataHandlerInterface{

    public DatabaseDataHandler(){

    }
    @Override
    public void setData(HashMap info) {
        try {
            FileOutputStream f = new FileOutputStream(new File("data.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(info);

            o.close();
            f.close();
        }catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error initializing stream");
        }
    }


    @Override
    public HashMap getData() {
        HashMap<Integer, Object> info = new HashMap<>();
        try {
            FileInputStream fi = new FileInputStream(new File("data.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Write objects to file
            info = (HashMap<Integer, Object>) oi.readObject();

            oi.close();
            fi.close();
        }catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            return info;
        }
    }
}