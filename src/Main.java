import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Address aPS1 = new Address("Gatuadress1", 11427, "Stad");
        PrivateSubscriber pS1 = new PrivateSubscriber(Subscriber.generateKundnummer(),"Namn1", 4, 149);
        pS1.setAddress(aPS1);
        Address aPS2 = new Address("Gatuadress5", 12345, "Stad");
        Address a2PS2 = new Address("Gatuadress6", 12345, "City", "Country");
        PrivateSubscriber pS2 = new PrivateSubscriber(Subscriber.generateKundnummer(),"Namn5", aPS2, a2PS2, 3, 169);
        Address aPS3 = new Address("Gatuadress2", 11427, "Stad");
        Address a2PS3=new Address("Gatuadress3", 41274, "Stad", "Land");
        PrivateSubscriber pS3 = new PrivateSubscriber(Subscriber.generateKundnummer(), "Namn Namnsson", aPS3, a2PS3, 2, 199);
        PrivateSubscriber pS4 = new PrivateSubscriber();

        List<Subscriber> privateSubscribers = new ArrayList<>();
        privateSubscribers.add(pS1);
        privateSubscribers.add(pS2);
        privateSubscribers.add(pS3);
        privateSubscribers.add(pS4);

        int sumPS=0;
        for (Subscriber s: privateSubscribers) {
//            s.printDetails();
            sumPS += s.calculateYearCost();
        }
        System.out.printf("\nSumman av årskostnader för Private Subscribers är %d kronor", sumPS);


        Address aCS = new Address("Gatuadress7", 12345, "Stad");
        CompanySubscriber cS1 = new CompanySubscriber(Subscriber.generateKundnummer(), "FöretagsNamn", aCS,"Nina 1", 15, 29);
        CompanySubscriber cS2= new CompanySubscriber();
        Address aCS3 = new Address("Gatan 6", 12345, "AnnanStad");
        CompanySubscriber cS3 = new CompanySubscriber(Subscriber.generateKundnummer(), "FöretagsNamn3", aCS3, "Nina 3", 9, 29);
        CompanySubscriber cS4 = new CompanySubscriber(Subscriber.generateKundnummer(), "Företagsnamn4", 20, 27);
        Address aCS4 = new Address("Gatan 42", 12345, "Staden stad");
        cS4.setAddress(aCS4);
        CompanySubscriber cS5 = new CompanySubscriber();
        Address aCS5 = new Address();
        cS5.setAddress(aCS5);

        //lägger till ett par kontaktpersoner för mina företag
        cS2.setKontaktperson("Nina 2"); cS4.setKontaktperson("Nina 4");


        List<Subscriber> companySubscribers = new ArrayList<>();
        companySubscribers.add(cS1);
        companySubscribers.add(cS2);
        companySubscribers.add(cS3);
        companySubscribers.add(cS4);
        companySubscribers.add(cS5);

        int sumCS=0;
        for (Subscriber cS: companySubscribers){
            sumCS += cS.calculateYearCost();
        }
        System.out.printf("\nSumman av årskostnader för Company Subscribers är %d kronor", sumCS);


        List<Subscriber> subscribersMixed = new ArrayList<>();
        subscribersMixed.add(cS1);
        subscribersMixed.add(pS2);
        subscribersMixed.add(cS3);
        subscribersMixed.add(pS4);

        int sumMix =0;
        for (Subscriber s: subscribersMixed){
            s.printDetails();
            sumMix += s.calculateYearCost();
        }
        System.out.printf("\nÅrskostnad för mixad lista: %d", sumMix);


    }
}
