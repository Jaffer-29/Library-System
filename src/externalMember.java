public class externalMember extends Member{

    externalMember(String name, String id){
        super(name,id,3);
    }

    public void externalMemberInfo(){
        System.out.printf("%11s : %-5s\n","Name",name);
        System.out.printf("%11s : %-5s\n","Member ID",iD);
        System.out.printf("%11s : %-5s\n","Book Limits",borrowingLimit);
    }

    public String role(){
        return "(is a External Member)";
    }

}
