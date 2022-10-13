package ra.run;

import ra.dev.Product;

import java.util.*;

public class ProductManager {
    static List<Product> listProduct = new ArrayList<Product>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("****************MENU*****************");
            System.out.println("1. Thêm sản phẩm mới!");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Hiển thị danh sách sản phẩm");
            System.out.println("4. Xóa sản phẩm theo tên");
            System.out.println("5. Sắp xếp sản phẩm ");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn của bạn là!");
            int choice=0;
            try {
                choice =  Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.err.println("Vui lòng nhập vào số tử 1-6!!!");
            }
            switch (choice){
                case 1:
                    ProductManager.inputProduct(scanner);
                    break;
                case 2:
                    ProductManager.updateProductById(scanner);
                    break;
                case 3:
                    ProductManager.displayProduct();
                    break;
                case 4:
                    ProductManager.seachProductByName(scanner);
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("vui lòng nhập từ 1-6");
            }
        }while (true);
    }
    public static void inputProduct (Scanner scanner){
        System.out.println("Nhập vào số lượng sản phẩm bạn cần thêm trong lần nhập này!!!");
        int number = 0;
        try {
            number =  Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.err.println("Vui lòng nhập vào số tử 1-6!!!");
        }
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập vào sản phẩm thứ " + (i+1));
            Product product = new Product();
            product.inputData(scanner,listProduct);
            listProduct.add(product);
        }
    }
    public static void updateProductById (Scanner scanner) {
        String productIdSeach ;
        int indexForUpdata = -1;
        while (indexForUpdata==-1){
            System.out.println("Nhập vào mã sản phẩm bạn muốn tìm kiếm !!");
            productIdSeach = scanner.nextLine();
            if (productIdSeach.trim().length()!=0){
                for (int i = 0; i < listProduct.size(); i++) {
                    if (listProduct.get(i).getProductId().equals(productIdSeach)){
                        indexForUpdata = i;
                        break;
                    }else {
                        System.err.println("Không có mã này trong danh sách! Vui lòng nhập lại!!!");
                    }
                }
            }else {
                System.err.println("Không để trống!!");
            }
        }
        if (indexForUpdata!=-1){
            System.out.println("Bạn có muốn cập nhật lại tên sản phẩm không? Tên sản phẩm cũ  " + listProduct.get(indexForUpdata).getProductName());
            System.out.println("1. Có");
            System.out.println("2. Không");
            String choice = scanner.nextLine();
            if (choice.equals("1")){
                while (true){
                    System.out.println("Nhập vào tên sản phẩm bạn muốn thay đổi!!!");
                    String name = scanner.nextLine();
                    if (name.trim().length()!=0){
                        listProduct.get(indexForUpdata).setProductName(name);
                        System.out.println("Đã cập nhật tên mới thành công!");
                        break;
                    }else {
                        System.err.println("không được để trống!!!");
                    }
                }
            }
            System.out.println("Bạn có muốn cập nhật lại giá nhập vào sản phẩm không? Giá nhập vào cũ " + listProduct.get(indexForUpdata).getImportPrice());
            System.out.println("1. Có");
            System.out.println("2. Không");
            choice = scanner.nextLine();
            if (choice.equals("1")){
                while (true){
                    System.out.println("Nhập vào giá mới của sản phẩm bạn muốn thay đổi!!!");
                    float importPrice;
                    try {
                        importPrice = Float.parseFloat(scanner.nextLine());
                        listProduct.get(indexForUpdata).setImportPrice(importPrice);
                        System.out.println("Đã cập nhật thành công!");
                        break;
                    }catch (Exception e){
                        System.err.println("không được để trống!!! Vui lòng nhập vào số!!!");
                    }
                }

            }
            System.out.println("Bạn có muốn cập nhật lại số lượng còn lại của sản phẩm không? Số lượng cũ  " + listProduct.get(indexForUpdata).getQuantity());
            System.out.println("1. Có");
            System.out.println("2. Không");
            choice = scanner.nextLine();
            if (choice.equals("1")){
                while (true){
                    System.out.println("Nhập vào giá mới của sản phẩm bạn muốn thay đổi!!!");
                    int importPrice;
                    try {
                        importPrice = Integer.parseInt(scanner.nextLine());
                        listProduct.get(indexForUpdata).setImportPrice(importPrice);
                        System.out.println("Đã cập nhật thành công!");
                        break;
                    }catch (Exception e){
                        System.err.println("không được để trống!!! Vui lòng nhập vào số!!!");
                    }
                }

            }
            System.out.println("Bạn có muốn cập nhật lại trạn thái sản phẩm không? Tên sản phẩm cũ  " + listProduct.get(indexForUpdata).displayStatus());
            System.out.println("1. Có");
            System.out.println("2. Không");
            choice = scanner.nextLine();
            if (choice.equals("1")){
                listProduct.get(indexForUpdata).inputStatus(scanner);
            }
        }
    }
    public static void displayProduct (){
        System.out.printf("%-10s%-15s%-12s%-12s%-20s%-10s\n","Mã sản phẩm","Tên sản phẩm","Giá nhập vào","Giá bán","Số lượng còn lại","Trạng thái");
        for (Product product:listProduct) {
            product.displayData();
        }
    }
    public static void seachProductByName (Scanner scanner){
        while (true){
            System.out.println("Nhập vào tên sản phẩm bạn muốn tìm kiếm!!!");
            String name = scanner.nextLine();
            if (name.trim().length()!=0){
                for (Product product: listProduct) {
                    if (product.getProductName().toLowerCase().contains(name.toLowerCase())){
                        System.out.printf("%-10s%-15s%-12s%-12s%-20s%-10s\n","Mã sản phẩm","Tên sản phẩm","Giá nhập vào","Giá bán","Số lượng còn lại","Trạng thái");
                        listProduct.remove(product);
                        System.out.println("Đã xóa san phẩm thành công!");
                        break;
                    }else {
                        System.err.println("Không có sản phẩm này vui lòng nhập lại!!!");
                    }
                }
            }else {
                System.err.println("Không đuọc để trống!!!");
            }
        }
    }
    public static void sortProductByPrice (Scanner scanner){
        do {
            System.out.println("Bạn muốn sắp xếp sản phẩm theo!");
            System.out.println("1. Sắp xếp sản phẩm theo giá bán tăng dần.");
            System.out.println("2. Sắp xếp sản phẩm theo giá bán giảm dần.");
            System.out.println("Lựa chọn của bạn là!");
            String choice = scanner.nextLine();
            if (choice.equals("1")){
                Collections.sort(listProduct, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return (int) (o2.getExportPrice()-o1.getExportPrice());
                    }
                });
            }else if (choice.equals("2")){
                Collections.sort(listProduct, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return (int) (o1.getExportPrice()-o2.getExportPrice());
                    }
                });
            }else {
                System.err.println("Vui lòng nhập 1 hoặc 2");
            }
        }while (true);
    }
}
