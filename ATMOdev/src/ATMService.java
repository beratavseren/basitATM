import java.util.ArrayList;

public interface ATMService {
    void musteriYazdir(Musteri musteri);
    void musteriKayit(ArrayList<Musteri> musteriArrayList);
    void bakiyeSorgula(Musteri musteri);
    void paraTransferi(Musteri gonderenMusteri,Musteri alanM,int tutar);
    void paraYatir(Musteri musteri);
    void paraCek(Musteri musteri);
}
