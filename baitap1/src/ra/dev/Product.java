package ra.dev;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Product {
    private String productId;
    private String productName;
    private float ImportPrice;
    private float ExportPrice;
    private int quantity;
    private boolean productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice, int quantity, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        ImportPrice = importPrice;
        ExportPrice = exportPrice;
        this.quantity = quantity;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return ImportPrice;
    }

    public void setImportPrice(float importPrice) {
        ImportPrice = importPrice;
    }

    public float getExportPrice() {
        float exportPrice = this.ImportPrice * 1.2f;
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        ExportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, List<Product> list) {
        inputProductId(scanner, list);
        System.out.println("Nhập vào tên sản phẩm!");
        this.productName = scanner.nextLine();
        while (true) {
            System.out.println("Nhập vào giá nhập sản phẩm!");
            try {
                this.ImportPrice = Float.parseFloat(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Vui lòng nhập vào số");
            }
        }
        while (true) {
            System.out.println("Nhập vào số lượng hàng còn lại!");
            try {
                this.quantity = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Vui lòng nhập vào số");
            }
        }

        inputStatus(scanner);
    }

    public boolean inputStatus(Scanner scanner) {
        boolean check = true;
        while (check) {
            System.out.println("Nhập vào trạng thái sản phẩm (Còn hàng/Hết hàng)");
            String status = scanner.nextLine();
            if (status.trim().length() != 0) {
                if (Objects.equals(status.toLowerCase(), "còn hàng")) {
                    this.productStatus = true;
                    check = false;
                } else if (Objects.equals(status.toLowerCase(), "hết hàng")) {
                    this.productStatus = false;
                    check = false;
                } else {
                    System.err.println("Vui lòng nhập vào (Còn hàng/Hết hàng) ");
                }
            } else {
                System.err.println("Không được để trống!!!");
            }

        }
        return this.productStatus;
    }

    public String inputProductId(Scanner scanner, List<Product> list) {

        while (true) {
            System.out.println("Nhập vào mã sản phẩm");
            String productId = scanner.nextLine();
            if (list.size() != 0) {
                    for (int i = 0; i < list.size(); i++) {
                        if (!productId.equals(list.get(i).getProductId())) {
                            this.productId = productId;
                            break;
                        } else {
                            System.err.println("Đã có mã này vui lòng nhập vào mã khác!");
                        }
                    }

            } else {
                this.productId = productId;
                break;
            }
        }
        return this.productId;
    }

    public void displayData() {
        String status = displayStatus();
        System.out.printf("%-10s%-15s%-12f%-12f%-20d%-10s\n", this.productId, this.productName, this.ImportPrice, this.ExportPrice, this.quantity, status);
    }

    public String displayStatus() {
        String status;
        if (this.productStatus) {
            status = "Còn hàng";
        } else {
            status = "Hết hàng";
        }
        return status;
    }
}
