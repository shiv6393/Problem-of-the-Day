
public class Solution {
    public record BadUdser(int id,String name) {
    }
    // public static class BadUdser {
    //     int id;
    //     String name;
    //     public BadUdser(int id,String name){
    //         this.id=id;
    //         this.name=name;
    //     }
       
    // }
    public static void main(String[] args) {
        BadUdser user1=new BadUdser(1,"Om");
        BadUdser user2=new BadUdser(1,"Om");
        System.out.println(user1);
       int hashCode= user1.hashCode();
       System.out.println(hashCode);
       System.out.println(user2.hashCode()==hashCode);

    }
    
}
 