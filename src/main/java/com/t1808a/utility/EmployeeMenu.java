package com.t1808a.utility;

import com.t1808a.controller.EmployeeController;
import com.t1808a.entity.Employee;
import com.t1808a.model.EmployeeModel;

import java.util.Scanner;

public class EmployeeMenu {
    EmployeeController controller = new EmployeeController();
    EmployeeModel model = new EmployeeModel();
    Employee emp;
    Scanner scanner = new Scanner(System.in);
    public void createMenu(){
        while (true) {
            System.out.println("-----------------Menu----------------");
            System.out.println("1. Đăng ký.");
            System.out.println("2. Đăng nhập.");
            System.out.println("3. Thoát.");
            System.out.println("-------------------------------------");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Đăng ký.");
                    System.out.println("Vui lòng nhập các thông tin: ");
                    while (true){
                        System.out.println("Tên: ");
                        String name = scanner.nextLine();
                        System.out.println("Địa chỉ: ");
                        String address = scanner.nextLine();
                        System.out.println("Email: ");
                        String email = scanner.nextLine();
                        System.out.println("Tài khoản: ");
                        String account = scanner.nextLine();
                        System.out.println("Mật khẩu: ");
                        String password = scanner.nextLine();
                        System.out.println("Ngày tạo: ");
                        String createdAt = scanner.nextLine();
                        System.out.println("Ngày update: ");
                        String updatedAt = scanner.nextLine();
                        Employee emp = new Employee(name,address,email,account,password,createdAt,updatedAt);
                        if(!model.checkExistAccount(account)) {
                            model.register(emp);
                            break;
                        }
                        System.out.println("Vui lòng nhập lại các thông tin: ");
                    }
                    break;
                case 2:
                    System.out.println("Đăng nhập.");
                    System.out.println("Vui lòng nhập tài khoản và mật khẩu: ");
                    System.out.println("Tài khoản: ");
                    String account = scanner.nextLine();
                    System.out.println("Mật khẩu: ");
                    String password = scanner.nextLine();
                    Employee emp = model.login(account,password);
                    if (emp == null){
                        System.out.println("Sai thông tin tài khoản.");
                    } else {
                        System.out.println("Thông tin nhân viên đăng nhập.");
                        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n","Tên","Địa chỉ","Email","Tài khoản","Mật khẩu","Ngày tạo","Ngày update");
                        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",emp.getName(),emp.getAddress(),emp.getEmail(),emp.getAccount(),emp.getPassword(),emp.getCreatedAt(),emp.getUpdatedAt());
                    }
                    break;
                case 3:
                    System.out.println("Thoát chương trình. Hẹn gặp lại.");
                    break;
                default:
                    System.out.println("Lựa chọn sai. Vui lòng lựa chọn lại trong khoảng từ 1 đến 3.");
                    break;
            }
            if (choice == 3) {
                break;
            }
        }
    }
}
