public class CompanySubscriber extends Subscriber implements Exportable {
    private int exemplar;
    private int avgiftPEPM;
    private String kontaktperson = "";

    public CompanySubscriber() {
        this(generateKundnummer(), "", 0, 0);
    }

    public CompanySubscriber(long kundnummer, String namn, int exemplar, int avgiftPEPM) {
        super(kundnummer, namn);
        this.exemplar = exemplar;
        this.avgiftPEPM = exemplar;
    }

    public CompanySubscriber(long kundnummer, String namn, Address address, String kontaktperson, int exemplar, int avgiftPEMP) {
        super(kundnummer, namn, address);
        this.kontaktperson = kontaktperson;
        this.exemplar = exemplar;
        this.avgiftPEPM = avgiftPEMP;
    }

    @Override
    public String toKommasepareratFormat() {
        return super.toKommasepareratFormat()+", \""+getKontaktperson()+"\"";
    }
    @Override
    public String toXMLFormat(){
        return super.toXMLFormat();
    }
    @Override
    public String toXMLFormatInner(){
        String XMLadd = String.format("\t<kontaktperson>%s</kontaktpersoner>" +
                        "\n\t<exemplar>%d</exemplar>" +
                        "\n\t<avgift-pe>%d</avgift-pe>\n",
                kontaktperson,exemplar, avgiftPEPM);
        return super.toXMLFormatInner()+XMLadd;
    }


    public void setKontaktperson(String kontaktperson) {
        this.kontaktperson = kontaktperson;
    }

    public String getKontaktperson() {
        return kontaktperson;
    }

    public int calculateYearCost() {
        int fakturaAvgift = 15;
        if (exemplar == 0)
            return 0;
        if (exemplar <= 10)
            return 12 * (exemplar * avgiftPEPM + fakturaAvgift);
        else
            return 12 * exemplar * avgiftPEPM;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        if (kontaktperson != null && !kontaktperson.equals(""))
            System.out.println("Kontaktperson: " + getKontaktperson());
        if (exemplar == 0)
            System.out.println("Inga exemplar beställda.");
        else if (avgiftPEPM == 0)
            System.out.println("Avgift per exempel och månad saknas.");
        else
            System.out.printf("Årsavgiften för %d exemplar à %d kr/månad är %d.", exemplar, avgiftPEPM, calculateYearCost());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}