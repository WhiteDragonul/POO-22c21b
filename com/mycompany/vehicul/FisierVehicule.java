package com.mycompany.vehicul;

import java.io.*;
import java.util.List;

public class FisierVehicule {

    // Functia care scrie (serializeaza) lista de vehicule intr-un fisier de octeti
    public static void scrieVehicule(List<Vehicul> vehicule, String numeFisier) {
        // Folosim try-with-resources pentru a inchide automat fluxul
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(numeFisier))) {
            oos.writeObject(vehicule);
            System.out.println("[SUCCESS] Vehiculele au fost scrise in fisierul " + numeFisier);
        } catch (IOException e) {
            System.err.println("[ERROR] Eroare la scrierea in fisier: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Functia care citeste (deserializeaza) lista din fisierul de octeti
    @SuppressWarnings("unchecked")
    public static List<Vehicul> citesteVehicule(String numeFisier) {
        List<Vehicul> lista = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(numeFisier))) {
            lista = (List<Vehicul>) ois.readObject();
            System.out.println("[SUCCESS] Vehiculele au fost citite din fisierul " + numeFisier);
        } catch (FileNotFoundException e) {
            System.err.println("[INFO] Fisierul nu exista inca.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[ERROR] Eroare la citirea din fisier: " + e.getMessage());
        }
        return lista;
    }
}
