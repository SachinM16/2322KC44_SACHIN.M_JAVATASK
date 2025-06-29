import java.util.*;

public class InventoryApp {
    public static void main(String[] args) throws Exception {
        ProductDAO dao = new ProductDAO();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Product\n2. View All Products\n3. Search Product\n4. Exit");
            int choice = sc.nextInt(); sc.nextLine();
            if (choice == 1) {
                Product p = new Product();
                System.out.print("Enter name: "); p.setName(sc.nextLine());
                System.out.print("Enter price: "); p.setPrice(sc.nextDouble());
                dao.addProduct(p);
            } else if (choice == 2) {
                for (Product p : dao.viewAll()) {
                    System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
                }
            } else if (choice == 3) {
                System.out.print("Enter name to search: ");
                Product p = dao.searchProduct(sc.nextLine());
                if (p != null) System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
                else System.out.println("Product not found");
            } else {
                dao.close();
                break;
            }
        }
    }
}
