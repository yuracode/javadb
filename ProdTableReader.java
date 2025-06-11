import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ProdTableReader {
    public static void main(String[] args) {
        // 接続情報
        String url = "jdbc:postgresql://localhost:5432/ossdb";
        String user = "postgres";
        String password = "postgres";

        // SQL文
        String query = "SELECT * FROM prod";

        try (
            // 接続
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        ) {
            // メタデータで列数を取得（汎用対応）
            int columnCount = rs.getMetaData().getColumnCount();

            // 結果の出力
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i));
                    if (i < columnCount) System.out.print(" | ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
