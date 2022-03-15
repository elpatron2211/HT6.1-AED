package src.main.java;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class main {

    public static Scanner scan=new Scanner(System.in);


    public static void main(String[] args) {
        ArrayList<String> operations = getOperations();

        boolean terminar1=false;

        do{


        
            System.out.println("Hola Bienvenido al ordenador de cartas Map\n\nElija una opción:\n1.HashMap\n2.TreeMap\n3.LinkedHashMap");
            try{
                String Op=scan.nextLine();
                int op=Integer.parseInt(Op);

                if(op==1){
                    HashMap< String,String> hash = new HashMap< String,String>();
                    String[] split;
                    

                    for (String operation: operations) {
                        if (!operation.trim().isEmpty()) { // Verifica que la línea del txt no venga vacía

                            try {
                                //System.out.println(operation);
                                String cartas=operation;
                                split=cartas.split("\\|");
                                String split0=split[0];
                                String split1=split[1];
                                hash.put(split0,split1);
                                //System.out.println(split0+": "+split1);
                            } catch (Exception e) {
                                System.out.println("Operación: " + operation + "\t Operación inválida." + "\t ERROR: " + e.getMessage());
                            }
                        }
                    }
                    Set<Map.Entry<String,String>> st = hash.entrySet();  //returns Set view
                    for(Map.Entry<String,String> me:st){
                        System.out.print(me.getKey()+":");
                        System.out.println(me.getValue());
                    }
                    
                        

                    terminar1=true;
                }else if(op==2){
                    TreeMap<String,String> tree = new TreeMap<String,String>();

                    String[] split;
                    

                    for (String operation: operations) {
                        if (!operation.trim().isEmpty()) { // Verifica que la línea del txt no venga vacía

                            try {
                                //System.out.println(operation);
                                String cartas=operation;
                                split=cartas.split("\\|");
                                String split0=split[0];
                                String split1=split[1];
                                tree.put(split0,split1);
                                //System.out.println(split0+": "+split1);
                            } catch (Exception e) {
                                System.out.println("Operación: " + operation + "\t Operación inválida." + "\t ERROR: " + e.getMessage());
                            }
                        }
                    }
                    Set<Map.Entry<String,String>> st = tree.entrySet();  //returns Set view
                    for(Map.Entry<String,String> me:st){
                        System.out.print(me.getKey()+":");
                        System.out.println(me.getValue());
                    }


                    terminar1=true;
                }else if(op==3){
                    LinkedHashMap<String,String> link = new LinkedHashMap<String,String>();

                    String[] split;
                    

                    for (String operation: operations) {
                        if (!operation.trim().isEmpty()) { // Verifica que la línea del txt no venga vacía

                            try {
                                //System.out.println(operation);
                                String cartas=operation;
                                split=cartas.split("\\|");
                                String split0=split[0];
                                String split1=split[1];
                                link.put(split0,split1);
                                //System.out.println(split0+": "+split1);
                            } catch (Exception e) {
                                System.out.println("Operación: " + operation + "\t Operación inválida." + "\t ERROR: " + e.getMessage());
                            }
                        }
                    }
                    Set<Map.Entry<String,String>> st = link.entrySet();  //returns Set view
                    for(Map.Entry<String,String> me:st){
                        System.out.print(me.getKey()+":");
                        System.out.println(me.getValue());
                    }
                    terminar1=true;
                }else{

                    System.out.println("\nOpción incorrecta vuelva a intentarlo");
                }



            
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("\nOpción incorrecta vuelva a intentarlo");
                
            }
            System.out.println("");
        }while(terminar1==false);
        System.exit(0);
    }

    /**
     *
     * @return
     */
    public static ArrayList<String> getOperations() {
        FileDialog dialog = new FileDialog((Frame) null, "Seleccion el archivo con las operaciones");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String dir = dialog.getDirectory() + dialog.getFile();
        System.out.println(dir);

        try {
            File file = new File(dir);

            if (!file.exists()) {
                file.createNewFile();
            }

            try {
                BufferedReader buffer = new BufferedReader(new FileReader(dir));
                ArrayList<String> data = new ArrayList<>();
                String line = buffer.readLine();

                while (line != null) {
                    data.add(line);
                    line = buffer.readLine();
                }

                return data;
            } catch (FileNotFoundException fnte) {
                fnte.printStackTrace();
                return null;
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }

}
