public abstract class Staff {
    protected String name;
    protected String staffID;
    protected String role;

    Staff(String name,String staffID, String role){
        this.name = name;
        this.staffID = staffID;
        this.role = role;
    }

    public abstract void assistMember(Member member);

    public String getName(){
        return name;
    }

}
