import java.sql.Connection; // JDBCのConnectionクラスをインポート
import java.sql.DriverManager; // JDBCのDriverManagerクラスをインポート
import java.sql.ResultSet; // SQLクエリの結果を保持するResultSetクラスをインポート
import java.sql.SQLException; // SQL例外を扱うSQLExceptionクラスをインポート
import java.sql.Statement; // SQL文を実行するStatementクラスをインポート

public class Main0 { // Main0クラスの定義

	public static void main(String[] args) { // mainメソッド（プログラムのエントリーポイント）
		Connection conn = null; // データベース接続用のConnectionオブジェクトを初期化
		String url = "jdbc:postgresql://localhost:5432/ossdb"; // データベース接続URL
		String user = "postgres"; // データベースユーザー名
		String password = "postgres"; // データベースパスワード

		try {
			// PostgreSQL用の接続URLでデータベースに接続
			conn = DriverManager.getConnection(
					url, user, password);

			Statement stat = conn.createStatement(); // SQL文を実行するためのStatementオブジェクトを作成
			ResultSet rs = stat.executeQuery("SELECT * FROM prod"); // prodテーブルの全データを取得

			while (rs.next()) { // 結果セットの次の行が存在する間ループ
				System.out.printf(
						"%d %s\n",
						rs.getInt(1), // 1列目の値（整数型）を取得
						rs.getString(2) // 2列目の値（文字列型）を取得
				);
			}

			rs.close(); // ResultSetをクローズ
			stat.close(); // Statementをクローズ

		} catch (SQLException ex) { // SQL例外が発生した場合
			ex.printStackTrace(); // スタックトレースを出力
		} finally {
			try {
				if (conn != null && !conn.isClosed()) // Connectionがnullでなく、かつ閉じていない場合
					conn.close(); // Connectionをクローズ
			} catch (SQLException e) { // クローズ時に例外が発生した場合
				e.printStackTrace(); // スタックトレースを出力
			}
		}
	}
}
