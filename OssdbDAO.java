import java.sql.Connection; // JDBCのConnectionクラスをインポート
import java.sql.SQLException; // JDBCのSQLExceptionクラスをインポート
import java.sql.DriverManager; // JDBCのDriverManagerクラスをインポート

// DAOの基底クラス
public class OssdbDAO {
    protected String url = "jdbc:postgresql://localhost:5432/ossdb"; // データベース接続URL
    protected String user = "postgres"; // データベースユーザー名
    protected String password = "postgres"; // データベースパスワード

    // 使い回すコネクション
    private Connection sharedConnection = null; // 共有コネクションのフィールド

    // コネクションを取得（使い回し）
    protected Connection getConnection() throws SQLException { // コネクション取得メソッド
        if (sharedConnection == null || sharedConnection.isClosed()) { // コネクションがnullまたは閉じている場合
            sharedConnection = DriverManager.getConnection(url, user, password); // 新しくコネクションを取得
        }
        return sharedConnection; // コネクションを返す
    }

    // データベース接続テスト用メソッド
    public boolean testConnection() { // 接続テストメソッド
        try (Connection conn = getConnection()) { // コネクションを取得し自動クローズ
            return conn != null && !conn.isClosed(); // コネクションが有効か判定
        } catch (SQLException e) { // 例外発生時
            return false; // falseを返す
        }
    }

    // コネクションの切断
    protected void closeConnection() { // コネクション切断メソッド
        if (sharedConnection != null) { // コネクションがnullでない場合
            try {
                if (!sharedConnection.isClosed()) { // コネクションが開いている場合
                    sharedConnection.close(); // コネクションを閉じる
                }
            } catch (SQLException e) { // 例外発生時
                // 必要に応じてログ出力
            }
        }
    }
}
