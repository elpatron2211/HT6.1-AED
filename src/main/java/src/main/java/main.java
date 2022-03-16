package src.main.java;
/**
 * Main
 * Objetivo: Intermediar funciones 
 * 
 * @author Walter Cruz 
 * @author Paulo Sanchez
 * @version 1.0 finalizado 17/03/2022
 */
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
                    /*for(Map.Entry<String,String> me:st){
                        System.out.print(me.getKey()+":");
                        System.out.println(me.getValue());
                    }*/
                    
                    int Menú=MenuPrincipal();
                        
                    System.out.println("Mi opcion "+Menú);

                    if(Menú==1){

                    }else if(Menú==2){

                        System.out.println("\nEscriba el nombre de la carta que desea buscar:");
                        String carta=scan.nextLine();
                        for(Map.Entry<String,String> me:st){

                            if(me.getKey().equals(carta)){

                                System.out.println("Su tipo es de: "+me.getValue());

                            }

                            
                        }

                    }else if(Menú==3){

                    }else if(Menú==4){

                    }else if(Menú==5){

                        for(Map.Entry<String,String> me:st){
                            System.out.print(me.getKey()+":");
                            System.out.println(me.getValue());
                        }

                    }else if(Menú==6){

                        for(Map.Entry<String,String> me:st){

                            if(me.getValue().equals("Monstruo")){

                                System.out.print(me.getKey()+":");
                                System.out.println(me.getValue());

                            }

                            
                        }
                        System.out.print("\n");
                        for(Map.Entry<String,String> me:st){

                            if(me.getValue().equals("Hechizo")){

                                System.out.print(me.getKey()+":");
                                System.out.println(me.getValue());

                            }

                            
                        }
                        System.out.print("\n");
                        for(Map.Entry<String,String> me:st){

                            if(me.getValue().equals("Trampa")){

                                System.out.print(me.getKey()+":");
                                System.out.println(me.getValue());

                            }

                            
                        }

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

    public static int MenuPrincipal(){
        boolean terminar2=false;
        int y=0;;
        do{
            try {
                System.out.println("\nQué desea hacer?\n1.Agregar una carta a la colección del usuario\n2.Mostrar el tipo de una carta específica\n3.Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección\n4.Mostrar el nombre, tipo y cantidad de cada carta que el usuario tiene en su colección, ordenadas por tipo\n5.Mostrar el nombre y tipo de todas las cartas existentes\n6.Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo\n7.Salir");
                String x=scan.nextLine();
                y=Integer.parseInt(x);
                if(y<8&&y>0){
                    terminar2=true;
                }else{
                    System.out.println("\nOpción incorrecta vuelva a intentarlo");
                }
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("\nOpción incorrecta vuelva a intentarlo");
            }


        }while(terminar2==false);
        
        return y;
    }
}
