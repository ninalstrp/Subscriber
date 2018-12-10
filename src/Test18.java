public class Test18 {
    public static void main(String[] args) {
        Employee e1 = new Employee(12,"Namn på anställd","Namn på företag");
        CompanySubscriber cS10 = new CompanySubscriber(Subscriber.generateKundnummer(),"Namn på företag", 10, 29);
        PrivateSubscriber pS10 = new PrivateSubscriber();

        metod(cS10);
        metod(e1);
        metod(pS10);
    }

    public static void metod(Exportable exportableObject){
        System.out.println(exportableObject.toKommasepareratFormat());
        System.out.println(exportableObject.toXMLFormat());
    }
}
