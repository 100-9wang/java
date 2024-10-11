package api;

public class Member_Equals {
    public String id;

    public Member_Equals(String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member_Equals) {
            Member_Equals member = (Member_Equals) obj;
            if (id.equals(member.id)) {
                return true;
            }
        }
        return false;
    }
}
