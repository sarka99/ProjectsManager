
package io;

import model.Project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hints on how to implement serialization and deserialization
 * of lists of projects and users.
 */


public class ProjectsFileIO {

    /**
     * Call this method before the application exits, to store the users and projects,
     * in serialized form.
     */


    public static void serializeToFile(File file, List<Project> data) throws IOException {
        // ...
        // and then, make sure the file always get closed
        FileOutputStream fout = null;

        // Serialize to file
        try {
            fout = new FileOutputStream("projects.ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);

            out.writeObject(data);
            fout.close();

            System.out.println("Serializing successfully completed");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try {
                if(fout != null) fout.close();
            }
            catch(IOException e) {

            }
        }
    }



    /**
     * Call this method at startup of the application, to deserialize the users and
     * from file the specified file.
     */


    @SuppressWarnings("unchecked")
    public static List<Project> deSerializeFromFile(File file) throws IOException, ClassNotFoundException {
        // ...
        // and then, make sure the file always get closed
        FileInputStream fin = null;

        try {

            fin = new FileInputStream("projects.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);

            ArrayList<Project> projects = (ArrayList<Project>) ois.readObject(); // Downcast from Object
            ois.close();
            fin.close();
            System.out.println("Deserializing successfully completed");
            for(Project c: projects) {
                System.out.println(c.toString());
            }
        return projects;
        }
        catch (IOException e) {
            System.out.println(e);
        }
        catch (ClassNotFoundException e) { // !!!
            System.out.println("Class for the object in file not known!!!");
        }
        finally {
            try {
                if(fin != null) {
                    fin.close();
                }

            }
            catch(IOException e) {

            }

        }

        return null;
    }

    private ProjectsFileIO() {

    }
}
