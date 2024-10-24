import java.util.ArrayList;
import java.util.Scanner;
public class ATMMethodlari implements ATMService{
    Scanner scan=new Scanner(System.in);
    @Override
    public void musteriYazdir(Musteri musteri){
        System.out.println("Bilgileriniz:");
        System.out.println("İsim: "+musteri.isim);
        System.out.println("Soyisim: "+musteri.soyIsim);
        System.out.println("TC kimlik numarası: "+musteri.TCKNo);
        System.out.println("Adres: "+musteri.adres);
        System.out.println("Müşteri numarası: "+musteri.musteriNo);
        System.out.println("Bakiye: "+musteri.bakiye);
    }

    @Override
    public void musteriKayit( ArrayList<Musteri> musteriArrayList)
    {
        System.out.println("Adınızı giriniz:");
        String ad= scan.next();
        System.out.println("Soyadınızı giriniz:");
        String soyad=scan.next();
        System.out.println("bakiyeniz 0'dır lütfen kaydınızı yaptıktan sonra para yatırın");
        System.out.println("TC kimlik numaranızı giriniz:");
        int TCno= scan.nextInt();
        System.out.println("Adresinizi giriniz:");
        String adres=scan.next();
        System.out.println("Musteri numaranızı giriniz:");
        int musteriNo=scan.nextInt();
        musteriArrayList.addLast(new Musteri(ad,soyad,0,TCno,adres,musteriNo));
    }

    @Override
    public void bakiyeSorgula(Musteri musteri){
        System.out.println("sayın "+musteri.isim+"bakiyeniz: "+musteri.bakiye+"TL");
    }
    @Override
    public void paraTransferi(Musteri gonderenMusteri,Musteri alanMusteri,int tutar){
        if (gonderenMusteri.bakiye>tutar)
        {
            gonderenMusteri.bakiye= gonderenMusteri.bakiye-tutar;
            alanMusteri.bakiye= alanMusteri.bakiye+tutar;
            System.out.println("Yeni bakiyeniz: "+gonderenMusteri.bakiye);
        }
        else
        {
            System.out.println("bakiye yetersizdir! Lütfen önce hesabınıza para yatırın.");
        }
    }
    @Override
    public void paraYatir(Musteri musteri){
        System.out.println("Yatırmak istediğiniz miktarı giriniz:");
        int tutar= scan.nextInt();
        musteri.bakiye= musteri.bakiye+tutar;
    }
    @Override
    public void paraCek(Musteri musteri){
        System.out.println("Çekmek istediğiniz miktarı giriniz:");
        int tutar= scan.nextInt();
        musteri.bakiye= musteri.bakiye-tutar;
    }

}
