import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Process {

    DecimalFormat df;
    public Process() {
        df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

    }







    public  List<Siparis> getData() // Get Data from File
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

    public static List<Integer> getUniqueMalzemeId(List<Siparis> siparisList) // Get Unique Values from Sipariş ID
    {
        List<Integer> uniqueValues = siparisList.stream()
                .map(Siparis::getMalNumarasi) // Replace getFieldName with actual getter method
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique values of fieldName: " + uniqueValues);
        return uniqueValues;
    }
    public  void calculateSumBySiparisId(  List<Siparis> siparisList ,  List<Integer> listSiparisId) // Calculate Sum by Sipariş Id
    {
        System.out.println("      SUM BY SIPARIS ID");

        for(Integer siparisId : listSiparisId){
            DoubleSummaryStatistics statistics =  siparisList.stream().filter(siparis -> siparis.getSiparisId().equals(siparisId))
                    .map(siparis -> siparis.getMiktar() * siparis.getBirimFiyat())
                    .mapToDouble(Float::floatValue)
                    .summaryStatistics();
            System.out.println( siparisId + " nolu sipariş --> " + df.format(statistics.getSum() ) );
        }
    }

    public  void calculateSumByMalzemeId(  List<Siparis> siparisList ,  List<Integer> listMalzemeId) // Calculate Sum by Sipariş Id
    {
        System.out.println("      SUM BY MALZEME ID");

        for(Integer siparisId : listMalzemeId){
            DoubleSummaryStatistics statistics =  siparisList.stream().filter(siparis -> siparis.getMalNumarasi().equals(siparisId))
                    .map(siparis -> siparis.getMiktar() * siparis.getBirimFiyat())
                    .mapToDouble(Float::floatValue)
                    .summaryStatistics();
            System.out.println( siparisId + " nolu malzeme --> " + df.format(statistics.getSum() ) );
        }
    }



    public  void calculateAverageBySiparisId(  List<Siparis> siparisList ,  List<Integer> listSiparisId) // Calculate Sum by Sipariş Id
    {
        System.out.println("      AVERAGE BY SIPARIS ID");
        Float total ;
        int count = 0;
        for(Integer siparisId : listSiparisId){
            DoubleSummaryStatistics statistics =  siparisList.stream().filter(siparis -> siparis.getSiparisId().equals(siparisId))
                    .map(siparis -> siparis.getMiktar() * siparis.getBirimFiyat())
                    .mapToDouble(Float::floatValue)
                    .summaryStatistics();
            System.out.println( siparisId + " --> " + df.format( statistics.getAverage()) );
        }


        /*
        for(Integer siparisId : listSiparisId){
            DoubleSummaryStatistics statistics =  siparisList.stream().filter(siparis -> siparis.getSiparisId().equals(siparisId))
                    .map(Siparis::getBirimFiyat)
                    .mapToDouble(Float::floatValue)
                    .summaryStatistics();
            System.out.println( siparisId + " --> " + statistics.getSum());
        }


         */
    }


    public void listMalzemeBySiparisId(List<Siparis> siparisList ,  List<Integer> listSiparisId, List<Integer> listMalzemeId)
    {
        System.out.println("      AVERAGE BY SIPARIS ID");
        Float total ;
        int count = 0;
        for(Integer malzemeId : listMalzemeId){
            System.out.println("MALZEME : " + malzemeId);
            for(Integer siparisId : listSiparisId){
                DoubleSummaryStatistics statistics =  siparisList.stream().
                        filter(siparis -> siparis.getMalNumarasi().equals(malzemeId))
                        .filter(siparis -> siparis.getSiparisId().equals(siparisId))
                        .map(siparis -> siparis.getMiktar())
                        .mapToDouble(Integer::intValue)
                        .summaryStatistics();
                System.out.println( siparisId + " --> " + df.format( statistics.getSum()));

            }


        }
    }



}
