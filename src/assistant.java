public class assistant extends Staff{

    assistant(String name,String id){
        super(name,id,"Assistant");
    }

    public void assistMember(Member member) {
        System.out.println("Assistant ("+getName()+") helping: " + member.getName());
    }

    public void assistantInfo(){
        System.out.printf("%11s : %-5s\n","Name",name);
        System.out.printf("%11s : %-5s\n","Staff ID",staffID);
        System.out.printf("%11s : %-5s\n","Staff Role",role);
        System.out.printf("%11s : %-5s\n","Shift Time","9am to 5pm");
        System.out.println("________________________________________");

    }

}
