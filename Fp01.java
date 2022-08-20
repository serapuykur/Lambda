package lambda_functional_programming01;

import java.util.ArrayList;
import java.util.List;

public class Fp01 {
    public static void main(String[] args) {
        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);
        System.out.println(liste);//[8, 9, 131, 10, 9, 10, 2, 8]
        listElemanlariniyazdirStructured(liste);//8 9 131 10 9 10 2 8
        System.out.println();
        listElemanlariniyazdirFunctional(liste);
        System.out.println();
        ciftSayilariyazdirStructured(liste);
        System.out.println();
        ciftSayilariyazdirFunctional(liste);//8 10 10 2 8
        System.out.println();
        tekElemanlarinKareleriniYazdir(liste);//81 17161 81
        System.out.println();
        tekrarsizTekElemanlarinkupunuyazdir(liste);//729 2248091
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami(liste);//168
        tekrarsizCiftElemanlarinKupununCarpimi(liste);//4096000
        System.out.println();
        getMaxEleman01(liste);
        System.out.println();
        getMinEleman01(liste);

    }

        //1) Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak
        // yazdıran bir method oluşturun.(Structured)
        public static  void listElemanlariniyazdirStructured(List<Integer>liste){
            for(Integer w:liste){
                System.out.print(w+" ");
            }

        }
    //1)Ardışık list elementlerini aynı satırda aralarında boşluk bırakarak
    // yazdıran bir method oluşturun.(Functional)
    public static void listElemanlariniyazdirFunctional(List<Integer>liste){
        liste.stream().forEach(t-> System.out.print(t+" "));
    }
    //2)Çift sayı olan list elemanlarını aynı satırda aralarında boşluk bırakarak
    // yazdıran bir method oluşturun.(Structured)
    public static void ciftSayilariyazdirStructured(List<Integer>liste){
        for(Integer w:liste){
            if(w%2==0){
                System.out.print(w+" ");
            }
        }
    }
    //2)Çift sayı olan çift list elemanlarını aynı satırda aralarında boşluk bırakarak
    // yazdıran bir method oluşturun.(Functional)

    public static void  ciftSayilariyazdirFunctional(List<Integer>liste){
        liste.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));
    }
    //3) Ardışık tek list elemanlarının karelerini aynı satırda aralarında boşluk
    // bırakarak yazdıran bir method oluşturun.(Functional)
    public static void tekElemanlarinKareleriniYazdir(List<Integer>liste){
        liste.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.print(t+" "));

    }
    //4) Ardışık tek list elementlerinin küplerini tekrarsız olarak aynı satırda aralarında boşluk
    // bırakarak yazdıran bir method oluşturun.
public static void tekrarsizTekElemanlarinkupunuyazdir(List<Integer>liste){
        liste.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).forEach(t-> System.out.print(t+" "));

}
    //5) Tekrarsız çift elemanların karelerinin toplamını hesaplayan bir method oluşturun.

    public static void tekrarsizCiftElemanlarinKareToplami(List<Integer>liste){
       Integer toplam= liste.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0,(t,u)->t+u);
        System.out.println(toplam);
    }
    //6) Tekrarsız çift elemanların küpünün çarpımını hesaplayan bir method oluşturun.
    public static void tekrarsizCiftElemanlarinKupununCarpimi(List<Integer>list){
        Integer carpim=list.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1,(t,u)->t*u);
        System.out.println(carpim);
    }
    //7) List elemanları arasından en büyük değeri bulan bir method oluşturun.
//1.yol:
    public static void getMaxEleman01(List<Integer>list){
        Integer max=list.stream().distinct().reduce(Integer.MIN_VALUE,(t,u)->t>u ? t:u);
        System.out.println();
    }
    //2.yol
    public static void getMaxEleman02(List<Integer>list){
       Integer max= list.stream().distinct().sorted().reduce(Integer.MIN_VALUE,(t,u)->u);
        System.out.println("max = "+max);
    }
    //Ödev
    //8)List elemanları arasından en küçük değeri bulan bir method oluşturun.(2 Yol ile)
    //1.yol:
    public static void getMinEleman01(List<Integer>list){
        Integer min=list.stream().distinct().reduce(Integer.MIN_VALUE,(t,u)->t>u ? t:u);
        System.out.println(min);
    }
    //2.yol
    public static void getMinEleman02(List<Integer>list){
        Integer min= list.stream().distinct().sorted().reduce(Integer.MIN_VALUE,(t,u)->u);
        System.out.println("min = "+min);
    }

    //serap: bu dosyani  devami gelecek
}
