package ex1;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainApp {
    private static void loadAllProducts(ArrayList<Produs> produse){
        try{
            File productsFile = new File("src/exercitiu/electronice.txt");
            Scanner scanner = new Scanner(productsFile);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] data = line.split(";");

                if(data[5].equals("imprimanta")){
                    Imprimanta imprimanta = new Imprimanta(data[0], Integer.parseInt(data[1]), Float.parseFloat(data[2]), data[5], data[3], Integer.parseInt(data[6]), Integer.parseInt(data[8]), data[9], data[7]);
                    produse.add(imprimanta);
                } else if(data[5].equals("copiator")){
                    Copiator copiator = new Copiator(data[0], Integer.parseInt(data[1]), Float.parseFloat(data[2]), data[4], data[3], Integer.parseInt(data[6]), data[7]);
                    produse.add(copiator);
                } else if(data[5].equals("sistem de calcul")){
                    SistemDeCalcul sistemDeCalcul = new SistemDeCalcul(data[0], Integer.parseInt(data[1]), Float.parseFloat(data[2]), data[4], data[3], data[6], Float.parseFloat(data[7]), data[9], Integer.parseInt(data[8]));
                    produse.add(sistemDeCalcul);
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void showMenu(){
        System.out.println("1. Afiseaza toate echipamentele.");
        System.out.println("2. Afisaza toate imprimantele.");
        System.out.println("3. Afiseaza toate copiatoarele.");
        System.out.println("4. Afiseaza toate sistemele de calcul.");
        System.out.println("5. Modifica starea unui echipament.");
        System.out.println("6. Setarea unui anumit mod de scriere pentru o imprimanta.");
        System.out.println("7. Setarea unui format de copiere pentru copiatoare.");
        System.out.println("8. Instalarea unui anumit sistem de operare pe un sistem de calcul.");
        System.out.println("9. Afişarea echipamentelor vândute.");
    }

    private static void showAllProducts(ArrayList<Produs> produse, Class<? extends Produs> tipProdus){
        for (Produs produs : produse) {
            if (tipProdus.isInstance(produs)) {
                if(tipProdus.equals(Imprimanta.class)){
                    Imprimanta imprimanta = (Imprimanta) produs;
                    System.out.println(imprimanta.toString());
                } else if(tipProdus.equals(Copiator.class)){
                    Copiator copiator = (Copiator) produs;
                    System.out.println(copiator.toString());
                } else if(tipProdus.equals(SistemDeCalcul.class)){
                    SistemDeCalcul sistemDeCalcul = (SistemDeCalcul) produs;
                    System.out.println(sistemDeCalcul.toString());
                }
            }
        }
    }

    private static void showAllSoldProducts(ArrayList<Produs> produse, Class<? extends Produs> tipProdus){
        for (Produs produs : produse) {
            if (tipProdus.isInstance(produs)) {
                if(produs.getState().equals("vandut")){
                    if(tipProdus.equals(Imprimanta.class)){
                        Imprimanta imprimanta = (Imprimanta) produs;
                        System.out.println(imprimanta.toString());
                    } else if(tipProdus.equals(Copiator.class)){
                        Copiator copiator = (Copiator) produs;
                        System.out.println(copiator.toString());
                    } else if(tipProdus.equals(SistemDeCalcul.class)){
                        SistemDeCalcul sistemDeCalcul = (SistemDeCalcul) produs;
                        System.out.println(sistemDeCalcul.toString());
                    }
                }
            }
        }
    }

    private static Produs findOneProduct(ArrayList<Produs> produse, String produsName){
        for(Produs produs : produse){
            if(produs.getDenumire().equals(produsName)){
                return produs;
            }
        }

        return null;
    }

    private static void modifyProduct(ArrayList<Produs> produse){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti denumirea produsului pe care doriti sa il modificati: ");

        String name = scanner.nextLine();
        Produs foundProdus = findOneProduct(produse, name);
        if(foundProdus == null){
            System.out.println("Produsul nu a fost gasit.");
        } else {
            System.out.println("Produsul a fost gasit, mai jos aveti datele acestuia.");
            System.out.println(foundProdus.toString());

            System.out.println("Noua stare ( achizitionat, expus, vandut ): ");
            String stare = scanner.nextLine();

            while(!stare.equals("achizitionat") && !stare.equals("expus") && !stare.equals("vandut")){
                System.out.println("Noua stare poate fi doar de acest tip: achizitionat, expus, vandut");
                stare = scanner.nextLine();
            }

            foundProdus.setState(stare);
            System.out.println("Produsul a fost actualizat cu succes! Noua stare este: " + stare);
        }
    }

    private static void setImprimantaMode(ArrayList<Produs> produse){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti denumirea imprimantei pe care doriti sa o modificati: ");

        String name = scanner.nextLine();
        Produs foundProdus = findOneProduct(produse, name);
        if(foundProdus == null){
            System.out.println("Produsul nu a fost gasit.");
        } else {
            if(foundProdus instanceof Imprimanta){
                Imprimanta imprimanta = (Imprimanta) foundProdus;
                System.out.println("Imprimanta a fost gasita, mai jos aveti datele acesteia.");
                System.out.println(imprimanta.toString());

                System.out.println("Noul mod de scriere: ");
                String mod = scanner.nextLine();

                while(!mod.equals("color") && !mod.equals("alb negru")){
                    System.out.println("Noul mod de scriere poate fi doar de tipul: color sau alb negru.");
                    mod = scanner.nextLine();
                }

                imprimanta.setM_tiparire(mod);
                System.out.println("Imprimanta a fost actualizata, noul mod de scriere este: " + mod);
            }
        }
    }

    private static void setFormatDeCopiere(ArrayList<Produs> produse){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti denumirea copiatorului pe care doriti sa il modificati: ");

        String name = scanner.nextLine();
        Produs foundProdus = findOneProduct(produse, name);
        if(foundProdus == null){
            System.out.println("Produsul nu a fost gasit.");
        } else {
            if(foundProdus instanceof Copiator){
                Copiator copiator = (Copiator) foundProdus;
                System.out.println("Copiatorul a fost gasit, mai jos aveti datele acestuia.");
                System.out.println(copiator.toString());

                System.out.println("Noul format de copiere: ");
                String format = scanner.nextLine();

                while(!format.equals("A3") && !format.equals("A4")){
                    System.out.println("Noul format de copiere poate fi doar de tipul: A3 SAU A4.");
                    format = scanner.nextLine();
                }

                copiator.setFormat(format);
                System.out.println("Formatul de copiere a fost actualizat, noul format este: " + format);
            }
        }
    }

    private static void setSistemDeOperare(ArrayList<Produs> produse){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti denumirea sistemului de calcul pe care doriti sa il modificati: ");

        String name = scanner.nextLine();
        Produs foundProdus = findOneProduct(produse, name);
        if(foundProdus == null){
            System.out.println("Produsul nu a fost gasit.");
        } else {
            if(foundProdus instanceof SistemDeCalcul){
                SistemDeCalcul sistemDeCalcul = (SistemDeCalcul) foundProdus;
                System.out.println("Sistemul de calcul a fost gasit, mai jos aveti datele acestuia.");
                System.out.println(sistemDeCalcul.toString());

                System.out.println("Noul sistem de operare: ");
                String sistemDeOperare = scanner.nextLine();

                while(!sistemDeOperare.equals("windows") && !sistemDeOperare.equals("linux") && !sistemDeOperare.equals("macOS")){
                    System.out.println("Noul sistem de operare poate fi: windows, linux sau macOS.");
                    sistemDeOperare = scanner.nextLine();
                }

                sistemDeCalcul.setSistem_de_operare(sistemDeOperare);
                System.out.println("Sistemul de operare a fost actualizat, noul sistem de operare este: " + sistemDeOperare);
            }
        }
    }

    static void serializeData(Object o, String fis) {
        try {
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Object readSerializedData(String fis) {
        try {
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        ArrayList<Produs> produse = new ArrayList<>();
        loadAllProducts(produse);
        //produse = (ArrayList<Produs>) readSerializedData("echip.bin");

        System.out.println("Toate electronicele au fost incarcate.");
        serializeData(produse, "echip.bin");

        int option;
        Scanner scanner = new Scanner(System.in);
        while(true){
            showMenu();
            System.out.println("Optiunea dvs: ");
            option = scanner.nextInt();

            switch(option){
                case 1: {
                    showAllProducts(produse, Imprimanta.class);
                    showAllProducts(produse, Copiator.class);
                    showAllProducts(produse, SistemDeCalcul.class);
                    break;
                }

                case 2 : {
                    showAllProducts(produse, Imprimanta.class);
                    break;
                }

                case 3 : {
                    showAllProducts(produse, Copiator.class);
                    break;
                }

                case 4 : {
                    showAllProducts(produse, SistemDeCalcul.class);
                    break;
                }

                case 5 : {
                    modifyProduct(produse);
                    break;
                }

                case 6 : {
                    setImprimantaMode(produse);
                    break;
                }

                case 7 : {
                    setFormatDeCopiere(produse);
                    break;
                }

                case 8 : {
                    setSistemDeOperare(produse);
                    break;
                }

                case 9 : {
                    showAllSoldProducts(produse, Imprimanta.class);
                    showAllSoldProducts(produse, Copiator.class);
                    showAllSoldProducts(produse, SistemDeCalcul.class);
                    break;
                }
            }
        }
    }
}
