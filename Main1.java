// メインクラス
public class Main1 { // Main1クラスの宣言
    public static void main(String[] args) { 
        OssdbDAO dao = new OssdbDAO(); // OssdbDAOクラスのインスタンスを生成
        if (dao.testConnection()) { // testConnectionメソッドで接続テストを実行
            System.out.println("接続に成功しました！"); // 接続成功時のメッセージを表示
        } else {
            System.out.println("接続に失敗しました。"); // 接続失敗時のメッセージを表示
        }
        dao.closeConnection();
    }
}