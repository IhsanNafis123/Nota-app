package manage;

import java.io.*;
import java.util.*;
import javax.crypto.CipherOutputStream;

public class NotaManager {
    private List<Serialisasi<String>> daftarNota = new ArrayList<>();

    public void start() {
        System.out.println(LanguageManager.get("app.welcome"));

        ReminderThread reminder = new ReminderThread();
        reminder.start();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(LanguageManager.get("app.menu"));
            String pilih = sc.nextLine();

            if (pilih.equals("1")) {
                tambahNota(sc);
            } else if (pilih.equals("2")) {
                tampilkanNota();
            } else if (pilih.equals("3")) {
                simpanNota();
            } else if (pilih.equals("4")) {
                System.out.println(LanguageManager.get("app.exit"));
                break;
            }
        }
    }

    private void tambahNota(Scanner sc) {
        System.out.print(LanguageManager.get("app.input.id"));
        String id = sc.nextLine();

        System.out.print(LanguageManager.get("app.input.tanggal"));
        String tanggal = sc.nextLine();

        System.out.print(LanguageManager.get("app.input.isi"));
        String isi = sc.nextLine();

        System.out.print(LanguageManager.get("app.input.harga"));
        String harga = sc.nextLine();

        daftarNota.add(new Serialisasi<>(id, tanggal, isi, harga));
    }

    private void tampilkanNota() {
        for (Serialisasi<String> n : daftarNota) {
            System.out.println(n.getId() + " | " + n.getTanggal() + " | " + n.getIsi() + " | " + n.getHarga());
        }
    }
    private void simpanNota() {
        try (FileOutputStream fos = new FileOutputStream("nota.dat");
             CipherOutputStream cos = CryptoUtils.encryptStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(cos)) {
            oos.writeObject(daftarNota);
            System.out.println(LanguageManager.get("app.saved"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
