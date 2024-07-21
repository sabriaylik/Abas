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
    public static  List<Siparis> getData() // Get Data from File
    {
        List<Siparis> siparisList = new ArrayList<Siparis>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("D:\\works\\java\\InterviewWs\\Abas\\src\\main\\java\\data.txt"));
            String line = reader.readLine();
            while (line != null) {
                String [] values = line.split(" ");
                Float x = Float.parseFloat(values[3]);
                siparisList.add(new Siparis( Integer.valueOf(values[0])  ,Integer.valueOf(values[1]) ,Integer.valueOf(values[2]) ,Float.valueOf(values[3])));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return siparisList;

    }

    public static List<Integer> getUniqueSiparisId(List<Siparis> siparisList) // Get Unique Values from Sipariş ID
    {
        List<Integer> uniqueValues = siparisList.stream()
                .map(Siparis::getSiparisId) // Replace getFieldName with actual getter method
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique values of fieldName: " + uniqueValues);
        return uniqueValues;
    }

    public static void calculateSumBySiparisId(  List<Siparis> siparisList ,  List<Integer> listSiparisId) // Calculate Sum by Sipariş Id
    {
        System.out.println("      SUM BY SIPARIS ID");
        for(Integer siparisId : listSiparisId){
            DoubleSummaryStatistics statistics =  siparisList.stream().filter(siparis -> siparis.getSiparisId().equals(siparisId))
                    .map(Siparis::getBirimFiyat)
                    .mapToDouble(Float::floatValue)
                    .summaryStatistics();
            System.out.println( siparisId + " --> " + statistics.getSum());
        }

    }



        public static  void main(String args[]){
            System.out.println("   -----------App is started-----------");
            List<Siparis> siparisList = Main.getData();
            List<Integer> uniqueSiparisId =  Main.getUniqueSiparisId(siparisList);
            Main.calculateSumBySiparisId(  siparisList,uniqueSiparisId);
            System.out.println("   -----------App is finished-----------");


    }
}
