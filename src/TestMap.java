import java.util.*;

public class TestMap {
    public static void main (String[] args){
        PrivateSubscriber pS1 = new PrivateSubscriber();
        PrivateSubscriber pS2 = new PrivateSubscriber();
        CompanySubscriber cS1 = new CompanySubscriber();
        CompanySubscriber cS2 = new CompanySubscriber();

        Map<Long, Subscriber> map = new HashMap<>();

        map.put(pS1.getKundnummer(),pS1);
        map.put(pS2.getKundnummer(),pS2);
        map.put(cS1.getKundnummer(),cS1);
        map.put(cS2.getKundnummer(),cS2);

//        System.out.println(map.get(4L));
        //varför blir det null om man skickar in nyckeln i fel typ?
//        System.out.println(map.get(Integer.valueOf(4)));

        List<Subscriber> listOO = new ArrayList<>();
        listOO.add(pS2);
        listOO.add(cS2);
        listOO.add(pS1);
        listOO.add(cS1);

        Collections.sort(listOO);

        for (Subscriber s: listOO)
        s.printDetails();

    }
}
