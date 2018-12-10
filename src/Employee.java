import java.util.Objects;

public class Employee implements Exportable {
    private final long employeeId;
    private String name;
    private String company;


    public Employee() {
        this(0, "", "");
    }
    public Employee(long employeeId, String name, String company) {
        this.employeeId = employeeId;
        this.name = name;
        this.company = company;
    }

    public long getEmployeeId() {
        return employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }


    @Override
    public String toKommasepareratFormat(){
        return employeeId+" , \""+name+"\", \""+company+"\"";
    }

    @Override
    public String toXMLFormat(){
       String XMLString = String.format("<person>\n"+toXMLFormatInner()+"</person>");
        return XMLString;
    }

    public String toXMLFormatInner(){
        String XMLStringInner=String.format("\t<employee-id>%d</employee-id>\n\t<name>%s</name>\n\t<company-name>%s</company-name>\n", employeeId,name,company);
        return XMLStringInner;
    }

    @Override
    public String toString() {
        String className = getClass().getName();
        return String.format("%s[employeeId=%d, name=%s, company=%s]", className, getEmployeeId(), getName(), getCompany());
    }

    @Override
    public boolean equals(Object objekt){
        if (this==objekt)
            return true;
        if (objekt==null)
            return false;
        if (this.getClass()!=objekt.getClass())
            return false;
        Employee employeeObjekt = (Employee)objekt;
        return Objects.equals(this.getEmployeeId(), employeeObjekt.getEmployeeId());
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(getEmployeeId());
    }
}