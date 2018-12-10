public class Address {
    private String gatuaddress;
    private int postnummer;
    private String postort;
    private String land;

    public Address(){
        this("",0,"","");
    }
    public Address (String gatuaddress, int postnummer, String postort){
        this(gatuaddress,postnummer,postort,"");
    }

    public Address (String gatuaddress, int postnummer, String postort, String land){
        setGatuaddress(gatuaddress);
        setPostnummer(postnummer);
        setPostort(postort);
        setLand(land);
    }

    public String getGatuaddress(){
        return gatuaddress;
    }
    public int getPostnummer(){
        return postnummer;
    }
    public String getPostort(){
        return postort;
    }
    public String getLand(){return land;}
    public void setGatuaddress(String gatuaddress){
        this.gatuaddress=gatuaddress;
    }
    public void setPostnummer(int postnummer){
        this.postnummer=postnummer;
    }
    public void setPostort(String postort){
        this.postort=postort;
    }
    public void setLand (String land) {this.land=land;}
}
