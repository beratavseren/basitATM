import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        ArrayList<Musteri> musteriArrayList = new ArrayList<>();

        Musteri musteri=new Musteri("Berat","Avseren",250,145603,"Adıyaman/Kahta",12340);
        Musteri musteri1=new Musteri("Eren","Aksu",500,132245,"Malatya/Akpınar",12341);
        Musteri musteri2=new Musteri("Ömer","Körükmez",1000,123658,"Sivas/Kangal",12342);
        Musteri musteri3=new Musteri("Berkay","Çelebi",400,879462,"Ordu/Merkez",12343);

        musteriArrayList.add(musteri);
        musteriArrayList.add(musteri1);
        musteriArrayList.add(musteri2);
        musteriArrayList.add(musteri3);

        ATMMethodlari atmMethodlari=new ATMMethodlari();
        System.out.println("Kayıt olmak için 0'ı tuşlayınız. Kayıt yapmayacaksanız 0 hariç herhangi bir rakama basın.");
        int kayitGirisKontrol=scan.nextInt();
        if (kayitGirisKontrol==0)
        {
            atmMethodlari.musteriKayit(musteriArrayList);
        }

            System.out.println("Giriş yapmak için adınızı giriniz:");

            String girisYapanIsim=scan.next();

            int girisYapanIndex=-1;
            for (int i=0;i<musteriArrayList.size();i++)
            {
                if (musteriArrayList.get(i).isim.equals(girisYapanIsim))
                {
                    girisYapanIndex=i;
                }
            }

        if (girisYapanIndex==-1)
        {
            System.out.println("Kullanıcı bulunamadı!!");
            System.out.println("Adınızı yazarken hata yaptıysanız lütfen programı tekrar çalıştırın.");
        }
        else {

            System.out.println("Müşteri bilgilerinizi görmek için :1");
            System.out.println("Para transferi için:2");
            System.out.println("Para yatırmak için:3");
            System.out.println("Para çekmek için:4");
            System.out.println("Bakiyenizi sorgulamak için:5");
            System.out.println("Çıkış yapmak için:6");

            int durum=-1;

            while (durum!=6){

                durum=scan.nextInt();

                switch (durum){
                    case 1:
                        atmMethodlari.musteriYazdir(musteriArrayList.get(girisYapanIndex));
                        break;
                    case 2:
                        System.out.println("parayı göndermek istediğiniz kişinin adını giriniz:");
                        String aliciAdi=scan.next();
                        System.out.println("göndermek istediğiniz para miktarını giriniz:");
                        int gonderilecekParaMiktari=scan.nextInt();
                        boolean paraTransferKontrol=false;
                        for (int i=0;i<musteriArrayList.size();i++)
                        {
                            if (musteriArrayList.get(i).isim.equals(aliciAdi))
                            {
                                System.out.println("para transferi gerçekleştiriliyor");
                                atmMethodlari.paraTransferi(musteriArrayList.get(girisYapanIndex),musteriArrayList.get(i),gonderilecekParaMiktari);
                                paraTransferKontrol=true;
                            }
                        }
                        if (!paraTransferKontrol)
                        {
                            System.out.println("Transfer yapmak istediğiniz kullanıcı bulunamadı!");
                        }
                        break;
                    case 3:
                        atmMethodlari.paraYatir(musteriArrayList.get(girisYapanIndex));
                        break;
                    case 4:
                        atmMethodlari.paraCek(musteriArrayList.get(girisYapanIndex));
                        break;
                    case 5:
                        atmMethodlari.bakiyeSorgula(musteriArrayList.get(girisYapanIndex));
                        break;
                    case 6:
                        System.out.println("Çıkış yapılıyor");
                        break;
                    default:
                        System.out.println("yapmak istediğiniz işlem bulunamadı!");
                        break;
                }
            }
        }
    }
}