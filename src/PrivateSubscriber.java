public class PrivateSubscriber extends Subscriber implements Exportable {
    private int prenumerationsPeriod;
    private int avgiftPP;

    public PrivateSubscriber (){
        this(generateKundnummer(), "",0,0);
    }

    public PrivateSubscriber (long kundnummer, String namn, int prenumerationsPeriod, int avgiftPP){
        super(kundnummer, namn);
        this.prenumerationsPeriod=prenumerationsPeriod;
        this.avgiftPP = avgiftPP;
    }
    public PrivateSubscriber (long kundnummer,
                              String namn,
                              Address address,
                              Address semesterAddress,
                              int prenumerationsPeriod,
                              int avgiftPP){
        super(kundnummer, namn, address, semesterAddress);
        this.prenumerationsPeriod=prenumerationsPeriod;
        this.avgiftPP=avgiftPP;
    }

    public int getPrenumerationsPeriod() {
        return prenumerationsPeriod;
    }
    public void setPrenumerationsPeriod(int prenumerationsPeriod) {
        this.prenumerationsPeriod = prenumerationsPeriod;
    }

    public int getAvgiftPP() {
        return avgiftPP;
    }
    public void setAvgiftPP(int avgiftPP) {
        this.avgiftPP = avgiftPP;
    }

    @Override
    public String toKommasepareratFormat(){
        return super.toKommasepareratFormat()+", \""+prenumerationsPeriod+"\", \""+avgiftPP+"\"";
    }
    @Override
    public String toXMLFormat(){
        return super.toXMLFormat();
    }
    @Override
    public String toXMLFormatInner(){
        String XMLadd = String.format("\t<prenumerationsperiod>%d</prenumerationsperiod>" +
                "\n\t<avgift-pp>%d</avgift-pp>\n",
                prenumerationsPeriod, avgiftPP);
        return super.toXMLFormatInner()+XMLadd;
    }

    public int calculateYearCost (){
        if (prenumerationsPeriod!=0){
        int fakturaAvgift = 15;
        return (12/prenumerationsPeriod)*(avgiftPP+fakturaAvgift);}
        else return 0;
    }

    @Override
    public void printDetails(){
        super.printDetails();
        if (prenumerationsPeriod==0)
            System.out.println("Information om prenumerationsperiod saknas.");
        else if(avgiftPP==0)
            System.out.println("Avgift per prenumerationsperiod är satt till 0 kr.");
        else
        System.out.printf("Prenumerationsperiod: %d à %d kr per månad, total årskostnad %d kr.", prenumerationsPeriod, avgiftPP, calculateYearCost());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
