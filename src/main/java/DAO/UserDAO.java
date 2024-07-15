package DAO;

import SQLHelper.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;
import model.User;

/**
 *
 * @author Luu Chi Khanh-CE181175
 */
public class UserDAO {

    public void insert(User user) throws SQLException {
        String sql = "SET IDENTITY_INSERT [user] ON; "
                + "INSERT INTO [user] ([id], [fullname], [gender], [dob]) VALUES (?, ?, ?, ?); "
                + "SET IDENTITY_INSERT [user] OFF;";
        try ( Connection conn = Util.getConnection();  PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getFullname());
            stmt.setString(3, user.getGender());
            stmt.setString(4, user.getDob());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error inserting user", e);
        }
    }

    // Cập nhật thông tin User và liên kết với Account vào database (dùng cho edit-profile)
    public boolean updateUser(User user) {
        String sql = "UPDATE [user] SET fullname=?, gender=?, dob=? WHERE id=?";

        try ( Connection conn = Util.getConnection();  PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, user.getFullname());
            statement.setString(2, user.getGender());
            statement.setString(3, user.getDob());
            statement.setInt(4, user.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public static User getUserByUsername(String username) {
        User user = null;
        try {
            Connection conn = Util.getConnection();
            String query = "SELECT u.*, a.username, a.email, m.type AS membershipType, m.price, m.period, r.type AS rankType " +
                           "FROM [user] u " +
                           "JOIN account a ON u.id = a.id " +
                           "JOIN membership m ON u.membership_id = m.id " +
                           "JOIN rank r ON u.rank_id = r.id " +
                           "WHERE a.username = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setEmail(rs.getString("email"));

                user = new User();
                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setGender(rs.getString("gender"));
                user.setDob(rs.getString("dob"));
                user.setAccount(account);
                user.setMembership(rs.getString("membershipType"));
                user.setPrice(rs.getDouble("price"));
                user.setPeriod(rs.getInt("period"));
                user.setRanktype(rs.getString("rankType"));
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
