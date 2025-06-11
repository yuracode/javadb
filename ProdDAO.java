import java.sql.ResultSet; // ResultSetクラスをインポート
import java.sql.Statement; // Statementクラスをインポート
import java.sql.SQLException; // SQLExceptionクラスをインポート
import java.sql.Connection; // Connectionクラスをインポート

public class ProdDAO extends OssdbDAO { // BaseDaoを継承したProdDaoクラスの定義
    // prodテーブルのprod_id, prod_name, priceフィールドのみを表示するメソッド
    public void printAll() { // printAllメソッドの定義
        String query = "SELECT prod_id, prod_name, price FROM prod"; // SQLクエリを定義
        try (
            Connection conn = getConnection(); // データベース接続を取得
            Statement stmt = conn.createStatement(); // ステートメントを作成
            ResultSet rs = stmt.executeQuery(query); // クエリを実行し結果セットを取得
        ) {
            while (rs.next()) { // 結果セットに次の行がある間ループ
                String prodId = rs.getString("prod_id"); // prod_id列の値を取得
                String prodName = rs.getString("prod_name"); // prod_name列の値を取得
                int price = rs.getInt("price"); // price列の値を取得
                System.out.println(prodId + " | " + prodName + " | " + price); // 取得した値を表示
            }
        } catch (SQLException e) { // SQL例外が発生した場合
            e.printStackTrace(); // スタックトレースを出力
        }
    }
}
