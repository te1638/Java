import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class BasicAuthService{
    public static int id;
    public static AuthService.Record findByLoginAndPassword(String login, String password) {
        System.out.println(login + password);
        Connection connection = DBService.getConnection();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new AuthService.Record(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")

                );
            }id = resultSet.getInt("id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    public static AuthService.Record newName(String newName) throws SQLException {
        System.out.println();
        Connection connection = DBService.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `users` SET `name` = ? WHERE `users`.`id` = ?");
        preparedStatement.setString(1, newName);
        preparedStatement.setString(2, String.valueOf(id));

        return null;
    }
}