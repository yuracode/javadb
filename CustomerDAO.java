import java.sql.Connection; // JDBCのConnectionクラスをインポート
import java.sql.PreparedStatement; // プリペアドステートメントをインポート
import java.sql.ResultSet; // 結果セットをインポート
import java.sql.SQLException; // SQL例外をインポート

public class CustomerDAO extends OssdbDAO { // CustomerDAOクラスを定義し、OssdbDAOを継承

    public void printAllCustomer() { // 全顧客情報を表示するメソッド
        String sql = "SELECT customer_id, customer_name FROM customer"; // 顧客IDと名前を取得するSQL
        try (Connection conn = getConnection(); // DB接続を取得
             PreparedStatement ps = conn.prepareStatement(sql); // SQL文を準備
             ResultSet rs = ps.executeQuery()) { // SQLを実行し結果を取得

            while (rs.next()) { // 結果セットを1行ずつ処理
                int customerId = rs.getInt("customer_id"); // 顧客IDを取得
                String customerName = rs.getString("customer_name"); // 顧客名を取得
                System.out.println("ID: " + customerId + ", Name: " + customerName); // 顧客情報を出力
            }
        } catch (SQLException e) { // SQL例外が発生した場合
            e.printStackTrace(); // スタックトレースを出力
        }
    }

    public void insertCustomer(int customerId, String customerName) { // 顧客を追加するメソッド
        String sql = "INSERT INTO customer (customer_id, customer_name) VALUES (?, ?)"; // 顧客追加用SQL
        try (Connection conn = getConnection(); // DB接続を取得
             PreparedStatement ps = conn.prepareStatement(sql)) { // SQL文を準備

            ps.setInt(1, customerId); // 1番目のパラメータに顧客IDをセット
            ps.setString(2, customerName); // 2番目のパラメータに顧客名をセット
            ps.executeUpdate(); // SQLを実行しデータを追加
        } catch (SQLException e) { // SQL例外が発生した場合
            e.printStackTrace(); // スタックトレースを出力
        }
    }
    public void deleteCustomer(int customerId) { // 顧客を削除するメソッド
        String sql = "DELETE FROM customer WHERE customer_id = ?"; // 顧客削除用SQL
        try (Connection conn = getConnection(); // DB接続を取得
             PreparedStatement ps = conn.prepareStatement(sql)) { // SQL文を準備

            ps.setInt(1, customerId); // 1番目のパラメータに顧客IDをセット
            ps.executeUpdate(); // SQLを実行しデータを削除
        } catch (SQLException e) { // SQL例外が発生した場合
            e.printStackTrace(); // スタックトレースを出力
        }
    }
}
