import jp.yutil.Input;

public class Main3 {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.insertCustomer(10, "sasaki");
        customerDAO.printAllCustomer();
        int id = Input.getInt("削除する顧客IDを入力してください: ");
        customerDAO.deleteCustomer(id);
        customerDAO.printAllCustomer();
    }
}
