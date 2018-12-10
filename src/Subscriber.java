import java.util.Objects;

public abstract class Subscriber implements Exportable, Comparable<Subscriber> {

    private static int[] kundnummerA = new int[100];

    private final long kundnummer;
    private String namn;
    private Address address;
    private Address addressSemester;

    public Subscriber() {
        this(Subscriber.generateKundnummer(), "");
    }

    public Subscriber(long kundnummer, String namn) {
        this(kundnummer, namn, new Address());
    }

    public Subscriber(long kundnummer, String namn, Address address) {
        this(kundnummer, namn, address, null);
    }

    public Subscriber(long kundnummer, String namn, Address address, Address addressSemester) {
        this.kundnummer = kundnummer;
        setNamn(namn);
        this.address = address;
        this.addressSemester = addressSemester;
    }


    public long getKundnummer() {
        return kundnummer;
    }
    public String getNamn() {
        return namn;
    }
    public void setNamn(String namn) {
        this.namn = namn;
    }


    public void setAddress(Address address) {
        this.address = address;
    }
    public void setAddressSemester(Address adressSemester) {
        this.addressSemester = adressSemester;
    }
    public Address getAddress() {
        return address;
    }
    public Address getAddressSemester() {
        return addressSemester;
    }

    @Override
    public String toKommasepareratFormat() {
        String kommasepareratFormat = kundnummer + ", \"" + namn + "\", \"" + address.getGatuaddress() + "\", \"" + address.getPostnummer() + "\", \"" + address.getPostort() + "\", \"" + address.getLand() + "\"";
        return kommasepareratFormat;
    }

    @Override
    public String toXMLFormat() {
        String XMLString = String.format("<person>\n" + toXMLFormatInner() + "</person>");
        return XMLString;
    }

    public String toXMLFormatInner() {
        String XMLStringInner = String.format("\t<kundnummer>%d</kundnummer>" +
                        "\n\t<namn>%s</namn>" +
                        "\n\t<gatuaddress>%s</gatuaddress>" +
                        "\n\t<postnummer>%d</postnummer>" +
                        "\n\t<postort>%s</postort>" +
                        "\n\t<land>%s</land>\n",
                        kundnummer, namn, address.getGatuaddress(), address.getPostnummer(), address.getPostort(), address.getLand());
        return XMLStringInner;
    }


    public static long generateKundnummer() {
        int kundnummer = -1;
        for (int i = 0; i < kundnummerA.length; i++) {
            if (kundnummerA[i] == 0) {
                kundnummerA[i] += 1 + i;
                kundnummer = kundnummerA[i];
                break;
            }
        }
        return kundnummer;
    }

    public void printDetails() {
        String namn = getNamn();
        if (namn.equals(""))
            namn="Namn okänt";
        System.out.printf("\n\n%s (%d)\n",
                namn,
                getKundnummer());
        if (address == null || address.getPostnummer() == 0)
            System.out.print("Address saknas.\n");
        else
            System.out.printf("%s\n%d %s%s",
                    address.getGatuaddress(),
                    address.getPostnummer(),
                    address.getPostort(),
                    String.format("%s\n", address.getLand()));
        if (addressSemester != null && addressSemester.getPostnummer() != 0)
            System.out.printf("\nSemesteraddress:\n%s\n%d %s%s",
                    addressSemester.getGatuaddress(),
                    addressSemester.getPostnummer(),
                    addressSemester.getPostort(),
                    String.format("\n%s\n", addressSemester.getLand()));
    }

    public abstract int calculateYearCost();

    //vi ska kunna testa med VILKET OBJEKT som helst
    //nydefinierad .equals jämför utifrån en parameter jag väljer som ska skilja objekt
    @Override
    public boolean equals(Object annatObject) {
        // om det är samma objektreferens är objektet samma och equals är true
        if (this == annatObject)
            return true;
        //om objektet jag jämför med är null är det inte equals TY jag vet att jag inte är null
        // (pga är i ett objekt, det kan ej va null pga anledning)
        if (annatObject == null)
            return false;
        //om det är olika klass är det INTE samma
        if (this.getClass() != annatObject.getClass())
            return false;
        //nu vet vi att objektet vi testar är samma klass som den vi befinner oss i
        Subscriber annan = (Subscriber) annatObject;
        //nu testar vi om den valda parametern är samma för objekten som jämförs.
        return Objects.equals(this.getKundnummer(), annan.getKundnummer());
    }

    //acceptera att detta måste göras om jag omdefinierar equals
    //obs att samma parameter används.
    @Override
    public int hashCode() {
        return Objects.hashCode(getKundnummer());
    }


    @Override
    public int compareTo(Subscriber s) {
        return Long.compare(this.getKundnummer(), s.getKundnummer());
        //i klassen Long finns en metod compare
    }


    @Override
    public String toString() {
        String className = getClass().getName();
        return className +
                " kundnummer=" + kundnummer +
                ", namn='" + namn + "'\n";
    }
}