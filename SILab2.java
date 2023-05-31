import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) { //1
        if (user==null || user.getPassword()==null || user.getEmail()==null){ //2
            throw new RuntimeException("Mandatory information missing!"); //3
        }//4

        if (user.getUsername()==null){ //5
            user.setUsername(user.getEmail()); //6
        }//7

        int same = 1; //8
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //9
            same = 0; //10
            for (int i=0;i<allUsers.size();i++) { //11
                User existingUser = allUsers.get(i);  //12
                if (existingUser.getEmail() == user.getEmail()) {  //13
                    same += 1; //14
                }//15
                if (existingUser.getUsername() == user.getUsername()) { //16
                    same += 1; //17
                }//18
            }//19
        }//20

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //21
        String password = user.getPassword(); //22
        String passwordLower = password.toLowerCase(); //23

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) { //24
            return false; //25
        }//26
        else { //27
            if (!passwordLower.contains(" ")) { //28
                for (int i = 0; i < specialCharacters.length(); i++) { //29
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //30
                        return same == 0; //31
                    }//32
                }//33
            }//34
        }//35
        return false; //36
    }

}