package yurchenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Service service = new Service();
        service.connect();
        boolean console = true;
        while (console) {
            System.out.println("Table products (prod_id, category, title, actor, price, special, common_prod_id)");
            System.out.println("1. Insert new entry");
            System.out.println("2. Update entry");
            System.out.println("3. Search entry by title");
            System.out.println("4. Delete entry");
            System.out.println("5. Exit");

            Scanner scanner = new Scanner(System.in);

            int choose = scanner.nextInt();
            switch (choose) {
                case (1): {
                    System.out.println("Input new title");
                    String title = new Scanner(System.in).nextLine();
                    service.insert(title);
                    log.info("User add new entry with {} title", title);
                    break;
                }
                case (2): {
                    System.out.println("Input product_id");
                    int productId = scanner.nextInt();
                    System.out.println("Input title");
                    String title = new Scanner(System.in).nextLine();
                    service.update(title, productId);
                    log.info("User changed entry with {} id", productId);
                    break;
                }
                case (3): {
                    System.out.println("Input title");
                    String title = new Scanner(System.in).nextLine();
                    service.search(title);
                    log.info("User search entry with {} title", title);
                    break;
                }
                case (4): {
                    System.out.println("Input product_id");
                    int productId = scanner.nextInt();
                    service.delete(productId);
                    log.info("User delete entry with {} product_id", productId);
                    break;
                }
                case (5): {
                    console = false;
                }
            }
        }
        service.disconnect();
    }
}