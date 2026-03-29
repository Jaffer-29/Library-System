public class Faculty extends Member{

    Faculty(String name, String id){
        super(name,id,10);
    }

    public void facultyInfo(){
        System.out.printf("%11s : %-5s\n","Name",name);
        System.out.printf("%11s : %-5s\n","Faculty ID",iD);
        System.out.printf("%11s : %-5s\n","Book Limits",borrowingLimit);
    }

    public String role(){
        return "(is a Faculty Member)";
    }

}
