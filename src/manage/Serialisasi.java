package manage;

import java.io.Serializable;

public class Serialisasi<T> implements Serializable {
    private String id;
    private String tanggal;
    private String isi;
    private T harga;

    public Serialisasi(String id, String tanggal, String isi, T harga) {
        this.id = id;
        this.tanggal = tanggal;
        this.isi = isi;
        this.harga = harga;
    }

    public String getId() { return id; }
    public String getTanggal() { return tanggal; }
    public String getIsi() { return isi; }
    public T getHarga() { return harga; }
}
