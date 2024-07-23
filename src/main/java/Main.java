import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

//Datadaki , ile alma hatası giderilecek , yerine . olacak
/*
a. Üç siparişteki malların toplam tutarının çıktısını veren java kodu.
b. Üç siparişteki bütün malların ortalama fiyatını bulan java kodu.
c. Üç siparişteki bütün malların tek tek mal bazlı ortalama fiyatını bulan java kodu.
d. Tek tek mal bazlı, malların hangi siparişlerde kaç adet olduğunun çıktısını veren
java kodu.
*\
 */





        public static  void main(String args[]){
            Process process = new Process();
            System.out.println("   -----------App is started-----------");
            List<Siparis> siparisList = process.getData();
            List<Integer> uniqueSiparisId =  process.getUniqueSiparisId(siparisList);
            List<Integer> uniqueMalzemeId =  process.getUniqueMalzemeId(siparisList);
            process.calculateSumBySiparisId(  siparisList,uniqueSiparisId);
            process.calculateAverageBySiparisId(  siparisList,uniqueSiparisId);
            process.calculateSumByMalzemeId(  siparisList,uniqueMalzemeId);
            process.listMalzemeBySiparisId(siparisList,uniqueSiparisId,uniqueMalzemeId);
            System.out.println("   -----------App is finished-----------");


    }
}
