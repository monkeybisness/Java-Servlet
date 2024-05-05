package Service;

import model.User;

import java.util.HashMap;
import java.util.Objects;

public class AuthService
{
    private static HashMap<String, User> Users = new HashMap<>()
    {
        {
            put("zxc", new User("zxc", "12345", "zxc@mail.ru"));
            put("asd", new User("asd", "1234", "asd@mail.ru"));
            put("qwe", new User("qwe", "123", "qwe@mail.ru"));
        }
    };
    public static  void CreateUser(User user)
    {
        Users.put(user.getLogin(), user);
    }
    public static User GetUser(String login, String password)
    {
        User user = Users.get(login);

        if( user == null || !Objects.equals(user.getPassword(), password)) return null;

        return user;
    }
}
