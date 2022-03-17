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
    //Cracion de objetos
    public static Scanner scan=new Scanner(System.in);
    public static MapFactory<String,String> mFactory= new MapFactory<String,String> ();
    public static Map<String, String> miFac=mFactory.getMap("1");

    public static void main(String[] args) {
        ArrayList<String> operations = getOperations();

        boolean terminar1=false;

        do{


        
            System.out.println("Hola Bienvenido al ordenador de cartas Map\n\nElija una opción:\n1.HashMap\n2.TreeMap\n3.LinkedHashMap");
            try{
                String Op=scan.nextLine();
                int op=Integer.parseInt(Op);
                //Opcion de HashMap
                if(op==1){
                    miFac=mFactory.getMap("1");
                    
                    //Se agregan del archivo de txt al mapa todas las cartas
                    miFac=AgregarMapa(operations);
                    //Creación de variable para imprimir los valores y llaves del mapa
                    Set<Map.Entry<String,String>> st = miFac.entrySet();  //returns Set view
                    
                    //Se crea una variable para un ciclo del menú con opciones para las cartas 
                    //Y se crea una colección para que el usuario pueda guardar sus cartas
                    boolean terminar2=false;
                    ArrayList<ArrayList> Colección=new ArrayList<>();

                    do{
                        //Se imprime el menú y se devuelve la opción del usuario
                        int Menú=MenuPrincipal();
                        
                        System.out.println("Mi opcion "+Menú);

                        //Guarda cartas a la colección del usuario
                        if(Menú==1){
                            System.out.println("\nIngrese el nombre de la carta que desea agregar a su colección: ");

                            String carta=scan.nextLine();

                            boolean encontrado=false;
                            //Revisamos si existe la carta
                            encontrado=ExisteCartaMapa(carta,st,encontrado);



                            //Si existe la carta se agrega a la colección del usuario
                            if(encontrado==true){

                                //Si el usuario todavía no tiene cartas
                                if(Colección.isEmpty()==true){
                                    //Se crea un ArrayList donde la primera posición es el nombre de la carta
                                    ArrayList<String> CartasUsuarios=new ArrayList<>();

                                    CartasUsuarios=BuscarAgregarMapa(carta,st);

                                    //Se agrega nombre, tipo y cantidad a la colección
                                    Colección.add(CartasUsuarios);
                                    
                                //Si el usuario ya tiene cartas
                                }else{
                                    //Se busca si la carta ya existe en la colección
                                    encontrado=false;
                                    for(int i=0;i<Colección.size();i++){
                                        //Si existe la carta en la colección
                                        if(Colección.get(i).get(0).equals(carta)){
                                            //Se suma a la cantidad +1
                                            int cantidad=Integer.parseInt((String) Colección.get(i).get(2))+1;
                                            Colección.get(i).set(2,cantidad+"");
                                            encontrado=true;
                                        }
                                    }
                                    //Si la carta aún no está en la colección
                                    if(encontrado==false){
                                        //Se crra un ArrayList como cuando estaba vacio y se agrega
                                        ArrayList<String> CartasUsuarios=new ArrayList<>();

                                        CartasUsuarios=BuscarAgregarMapa(carta,st);

                                        Colección.add(CartasUsuarios);
                                        encontrado=true;
                                        
                                    }


                                }

                                //Se muestra al usuario la carta que acaba de agregar con tipo y cantidad
                                ImprimirCartaColeccion(Colección, carta);
                            //No existe la carta entonces no se puede agregar a la colección    
                            }else{
                                System.out.println("Carta no reconocida");
                            }

                        //Muestra el tipo de una carta
                        }else if(Menú==2){
                            imprimirMapa(Menú, st);
                        //Muestra todas las cartas del usuario
                        }else if(Menú==3){
                            
                            imprimirColeccion(Menú, Colección);

                        //Muestra todas las cartas de la colección del usuario pero clasificadas por tipo
                        }else if(Menú==4){
                        
                            imprimirColeccion(Menú, Colección);

                        //Imprime todas las cartas y sus tipos
                        }else if(Menú==5){
    
                            imprimirMapa(Menú, st);

                        //Imprime todas las cartas clasificadas por su tipo
                        }else if(Menú==6){
                            imprimirMapa(Menú, st);
                        //Salida
                        }else if(Menú==7){
                            terminar2=true;
                        //Opciones no validas
                        }else{
                            System.out.println("Opción no válida");
                        }

                    }while(terminar2==false);
                    

                    terminar1=true;
                }else if(op==2){
                    miFac=mFactory.getMap("2");
                      
                    //Se agregan del archivo de txt al mapa todas las cartas
                    miFac=AgregarMapa(operations);

                    //Creación de variable para imprimir los valores y llaves del mapa
                    Set<Map.Entry<String,String>> st = miFac.entrySet();  //returns Set view
                    
                    //Se crea una variable para un ciclo del menú con opciones para las cartas 
                    //Y se crea una colección para que el usuario pueda guardar sus cartas
                    boolean terminar2=false;
                    ArrayList<ArrayList> Colección=new ArrayList<>();

                    do{
                        //Se imprime el menú y se devuelve la opción del usuario
                        int Menú=MenuPrincipal();
                        
                        System.out.println("Mi opcion "+Menú);

                        //Guarda cartas a la colección del usuario
                        if(Menú==1){
                            System.out.println("\nIngrese el nombre de la carta que desea agregar a su colección: ");

                            String carta=scan.nextLine();

                            boolean encontrado=false;
                            //Revisamos si existe la carta
                            encontrado=ExisteCartaMapa(carta,st,encontrado);



                            //Si existe la carta se agrega a la colección del usuario
                            if(encontrado==true){

                                //Si el usuario todavía no tiene cartas
                                if(Colección.isEmpty()==true){
                                    //Se crea un ArrayList donde la primera posición es el nombre de la carta
                                    ArrayList<String> CartasUsuarios=new ArrayList<>();

                                    CartasUsuarios=BuscarAgregarMapa(carta,st);

                                    //Se agrega nombre, tipo y cantidad a la colección
                                    Colección.add(CartasUsuarios);
                                    
                                //Si el usuario ya tiene cartas
                                }else{
                                    //Se busca si la carta ya existe en la colección
                                    encontrado=false;
                                    for(int i=0;i<Colección.size();i++){
                                        //Si existe la carta en la colección
                                        if(Colección.get(i).get(0).equals(carta)){
                                            //Se suma a la cantidad +1
                                            int cantidad=Integer.parseInt((String) Colección.get(i).get(2))+1;
                                            Colección.get(i).set(2,cantidad+"");
                                            encontrado=true;
                                        }
                                    }
                                    //Si la carta aún no está en la colección
                                    if(encontrado==false){
                                        //Se crra un ArrayList como cuando estaba vacio y se agrega
                                        ArrayList<String> CartasUsuarios=new ArrayList<>();

                                        CartasUsuarios=BuscarAgregarMapa(carta,st);

                                        Colección.add(CartasUsuarios);
                                        encontrado=true;
                                        
                                    }


                                }
                                //Se muestra al usuario la carta que acaba de agregar con tipo y cantidad
                                ImprimirCartaColeccion(Colección, carta);
                            //No existe la carta entonces no se puede agregar a la colección    
                            }else{
                                System.out.println("Carta no reconocida");
                            }

                        //Muestra el tipo de una carta
                        }else if(Menú==2){
                            imprimirMapa(Menú, st);
                        //Muestra todas las cartas del usuario
                        }else if(Menú==3){
                            
                            imprimirColeccion(Menú, Colección);

                        //Muestra todas las cartas de la colección del usuario pero clasificadas por tipo
                        }else if(Menú==4){
                            
                            imprimirColeccion(Menú, Colección);
                        //Imprime todas las cartas y sus tipos
                        }else if(Menú==5){
    
                            imprimirMapa(Menú, st);

                        //Imprime todas las cartas clasificadas por su tipo
                        }else if(Menú==6){

                            imprimirMapa(Menú, st);

                        //Salida
                        }else if(Menú==7){
                            terminar2=true;
                        //Opciones no validas
                        }else{
                            System.out.println("Opción no válida");
                        }

                    }while(terminar2==false);
                    

                    terminar1=true;
                }else if(op==3){
                    miFac=mFactory.getMap("3");

                    AccionesMenu(miFac,operations);

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

    //Menu opciones 3 y 4
    public static void imprimirColeccion(int Menú, ArrayList<ArrayList> Colección){


        //Muestra todas las cartas del usuario
        if(Menú==3){
                                
            for(int i=0;i<Colección.size();i++){
                
                    
                System.out.println("\n\nCarta "+Colección.get(i).get(0)+"\nSu tipo es el "+Colección.get(i).get(1)+"\nSu cantidad es "+Colección.get(i).get(2));
                
            }

        //Muestra todas las cartas de la colección del usuario pero clasificadas por tipo
        }else if(Menú==4){
            //Imprime todas las cartas de tipo Monstruo
            for(int i=0;i<Colección.size();i++){
                
                if(Colección.get(i).get(1).equals("Monstruo")){
                    System.out.println("\n\nCarta "+Colección.get(i).get(0)+"\nSu tipo es el "+Colección.get(i).get(1)+"\nSu cantidad es "+Colección.get(i).get(2));
                }
                                
                
                
            }
            //Imprime las cartas de tipo Hechizo
            for(int i=0;i<Colección.size();i++){
                
                if(Colección.get(i).get(1).equals("Hechizo")){
                    System.out.println("\n\nCarta "+Colección.get(i).get(0)+"\nSu tipo es el "+Colección.get(i).get(1)+"\nSu cantidad es "+Colección.get(i).get(2));
                }
                                
                
                
            }
            //Imprime las cartas de tipo Trampa
            for(int i=0;i<Colección.size();i++){
                
                if(Colección.get(i).get(1).equals("Trampa")){
                    System.out.println("\n\nCarta "+Colección.get(i).get(0)+"\nSu tipo es el "+Colección.get(i).get(1)+"\nSu cantidad es "+Colección.get(i).get(2));
                }
                                
                
                
            }
        }
    }

    //Menu opciones 2, 5 y 6
    public static void imprimirMapa(int Menú, Set<Map.Entry<String,String>> st){

        if(Menú==2){
            //Escribes el nombre de una carta y te muestra el tipo
            System.out.println("\nEscriba el nombre de la carta que desea buscar:");
            String carta=scan.nextLine();
            boolean existe=false;
            for(Map.Entry<String,String> me:st){

                if(me.getKey().equals(carta)){

                    System.out.println("Su tipo es de: "+me.getValue());
                    existe=true;
                }

                
            }
            if(existe==false){
                System.out.println("Carta no encontrada");
            }



        }else if(Menú==5){
    
            for(Map.Entry<String,String> me:st){
                System.out.print(me.getKey()+":");
                System.out.println(me.getValue());
            }
        //Imprime todas las cartas clasificadas por su tipo
        }else if(Menú==6){
            //Imprime las cartas tipo Monstruo
            for(Map.Entry<String,String> me:st){

                if(me.getValue().equals("Monstruo")){

                    System.out.print(me.getKey()+":");
                    System.out.println(me.getValue());

                }

                
            }
            //Imprime las cartas tipo Hechizo
            System.out.print("\n");
            for(Map.Entry<String,String> me:st){

                if(me.getValue().equals("Hechizo")){

                    System.out.print(me.getKey()+":");
                    System.out.println(me.getValue());

                }

                
            }
            //Imprime las cartas tipo Trampa
            System.out.print("\n");
            for(Map.Entry<String,String> me:st){

                if(me.getValue().equals("Trampa")){

                    System.out.print(me.getKey()+":");
                    System.out.println(me.getValue());

                }

                
            }
        }
    }

    //Opcion 1
    public static boolean ExisteCartaMapa(String carta, Set<Map.Entry<String,String>> st, boolean encontrado){

        //Revisamos si existe la carta
        for(Map.Entry<String,String> me:st){
            //Encontro la carta
            if(me.getKey().equals(carta)){

                encontrado=true;

            }   
        }
        return encontrado;
    }

    //Opcion 1
    public static ArrayList<String> BuscarAgregarMapa(String carta, Set<Map.Entry<String,String>> st){

        //Se crea un ArrayList donde la primera posición es el nombre de la carta
        ArrayList<String> CartasUsuarios=new ArrayList<>();
        CartasUsuarios.add(carta);
        //La segunda posición es el tipo de carta
        for(Map.Entry<String,String> me:st){

            if(me.getKey().equals(carta)){

                CartasUsuarios.add(me.getValue());

            }
            
            
        }
        //La tercera posición es la cantidad de la carta
        CartasUsuarios.add("1");

        return CartasUsuarios;
    }

    //Opcion 1
    public static void ImprimirCartaColeccion(ArrayList<ArrayList> Colección, String carta){

        for(int i=0;i<Colección.size();i++){
            if(Colección.get(i).get(0).equals(carta)){
                
                System.out.println("\nAgregado con éxito:\nSu carta es la "+carta+"\nSu tipo es el "+Colección.get(i).get(1)+"\nSu cantidad es "+Colección.get(i).get(2));
            }
        }
    }

    //General
    public static Map<String, String> AgregarMapa(ArrayList<String> operations){
        String[] split;
        for (String operation: operations) {
            if (!operation.trim().isEmpty()) { // Verifica que la línea del txt no venga vacía

                try {
                    //System.out.println(operation);
                    String cartas=operation;
                    split=cartas.split("\\|");
                    String split0=split[0];
                    String split1=split[1];
                    miFac.put(split0,split1);
                    //System.out.println(split0+": "+split1);
                } catch (Exception e) {
                    System.out.println("Operación: " + operation + "\t Operación inválida." + "\t ERROR: " + e.getMessage());
                }
            }
        }


        return miFac;
    }

    public static void AccionesMenu(Map<String, String> miFac, ArrayList<String> operations){

        //Se agregan del archivo de txt al mapa todas las cartas
        miFac=AgregarMapa(operations);

        //Creación de variable para imprimir los valores y llaves del mapa
        Set<Map.Entry<String,String>> st = miFac.entrySet();  //returns Set view
        
        //Se crea una variable para un ciclo del menú con opciones para las cartas 
        //Y se crea una colección para que el usuario pueda guardar sus cartas
        boolean terminar2=false;
        ArrayList<ArrayList> Colección=new ArrayList<>();

        do{
            //Se imprime el menú y se devuelve la opción del usuario
            int Menú=MenuPrincipal();
            
            System.out.println("Mi opcion "+Menú);

            //Guarda cartas a la colección del usuario
            if(Menú==1){
                System.out.println("\nIngrese el nombre de la carta que desea agregar a su colección: ");

                String carta=scan.nextLine();

                boolean encontrado=false;
                //Revisamos si existe la carta
                encontrado=ExisteCartaMapa(carta,st,encontrado);


                //Si existe la carta se agrega a la colección del usuario
                if(encontrado==true){

                    //Si el usuario todavía no tiene cartas
                    if(Colección.isEmpty()==true){

                        ArrayList<String> CartasUsuarios=new ArrayList<>();
                        CartasUsuarios=BuscarAgregarMapa(carta,st);

                        //Se agrega nombre, tipo y cantidad a la colección
                        Colección.add(CartasUsuarios);
                        
                    //Si el usuario ya tiene cartas
                    }else{
                        //Se busca si la carta ya existe en la colección
                        encontrado=false;
                        for(int i=0;i<Colección.size();i++){
                            //Si existe la carta en la colección
                            if(Colección.get(i).get(0).equals(carta)){
                                //Se suma a la cantidad +1
                                int cantidad=Integer.parseInt((String) Colección.get(i).get(2))+1;
                                Colección.get(i).set(2,cantidad+"");
                                encontrado=true;
                            }
                        }
                        //Si la carta aún no está en la colección
                        if(encontrado==false){
                            //Se crra un ArrayList como cuando estaba vacio y se agrega
                            ArrayList<String> CartasUsuarios=new ArrayList<>();

                            CartasUsuarios=BuscarAgregarMapa(carta,st);

                            Colección.add(CartasUsuarios);
                            encontrado=true;
                            
                        }


                    }
                    //Se muestra al usuario la carta que acaba de agregar con tipo y cantidad
                    ImprimirCartaColeccion(Colección, carta);
                //No existe la carta entonces no se puede agregar a la colección    
                }else{
                    System.out.println("Carta no reconocida");
                }

            //Muestra el tipo de una carta
            }else if(Menú==2){
                imprimirMapa(Menú, st);
            //Muestra todas las cartas del usuario
            }else if(Menú==3){
                
                imprimirColeccion(Menú, Colección);

            //Muestra todas las cartas de la colección del usuario pero clasificadas por tipo
            }else if(Menú==4){

                imprimirColeccion(Menú, Colección);

            //Imprime todas las cartas y sus tipos
            }else if(Menú==5){

                imprimirMapa(Menú, st);
                //Imprime todas las cartas clasificadas por su tipo
            }else if(Menú==6){
               
                imprimirMapa(Menú, st);

            //Salida
            }else if(Menú==7){
                terminar2=true;
            //Opciones no validas
            }else{
                System.out.println("Opción no válida");
            }

        }while(terminar2==false);
        



    }
}
