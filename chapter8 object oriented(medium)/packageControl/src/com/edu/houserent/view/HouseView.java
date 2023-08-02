package com.edu.houserent.view;

import com.edu.houserent.domain.House;
import com.edu.houserent.service.HouseService;
import com.edu.houserent.utils.Utility;

/**
 * 1. show menu
 * 2. exit
 * 3. call HouseService to finish each operation in House.
 */
public class HouseView {

    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);

    public void mainMenu() {
        do {
            System.out.println("\n========House Rent System========");
            System.out.println("\t\t1. add house");
            System.out.println("\t\t2. find house");
            System.out.println("\t\t3. delete house");
            System.out.println("\t\t4. update house");
            System.out.println("\t\t5. house list");
            System.out.println("\t\t6. exit");
            System.out.print("Please your choice: ");

            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    DelHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
            }

        } while (loop);
    }

    public void addHouse() {
        System.out.println("========add House========");
        System.out.print("name: ");
        String name = Utility.readString(8);

        System.out.print("phone: ");
        String phone = Utility.readString(12);

        System.out.print("address: ");
        String address = Utility.readString(16);

        System.out.print("rent: ");
        int rent = Utility.readInt();

        System.out.print("state: ");
        String state = Utility.readString(10);

        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("========add House success========");
        } else {
            System.out.println("========add House fail========");
        }

    }

    public void DelHouse() {
        System.out.println("========delete House========");
        System.out.print("Please input house id(-1 mean exit delete operation): ");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("========exit delete House operation========");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.delete(delId)) {
                System.out.println("========delete House success========");
            } else {
                System.out.println("========delete House fail========");
            }
        } else {
            System.out.println("========exit delete House operation========");
        }
    }

    public void updateHouse() {
        System.out.println("========update House========");
        System.out.print("Please input house id(-1 mean exit update operation): ");
        int findId = Utility.readInt();
        if (findId == -1) {
            System.out.println("========exit update House operation========");
            return;
        }
        House house = houseService.findById(findId);
        if (house==null){
            System.out.println("input house id doesn't exist!");
            return;
        }

        System.out.print("name:("+house.getName()+"): ");
        String name = Utility.readString(8, "");
        if (!"".equals(name)){
            house.setName(name);
        }

        System.out.print("phone:("+house.getPhone()+"): ");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)){
            house.setPhone(phone);
        }

        System.out.print("address:("+house.getAddress()+"): ");
        String address = Utility.readString(16, "");
        if (!"".equals(address)){
            house.setAddress(address);
        }

        System.out.print("rent:("+house.getRent()+"): ");
        int rent = Utility.readInt(-1);
        if (rent!=-1){
            house.setRent(rent);
        }

        System.out.print("state:("+house.getState()+"): ");
        String state = Utility.readString(10, "");
        if (!"".equals(state)){
            house.setState(state);
        }

        System.out.println("========update House success========");
    }

    public void findHouse() {
        System.out.println("========find House========");
        System.out.print("Please input house id: ");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if (house != null) {
            columnsPrint();
            System.out.println(house);
        } else {
            System.out.println("input house id doesn't exist!");
        }
    }

    public void listHouse() {
        System.out.println("========House list========");
        columnsPrint();
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);

        }
    }

    public void exit() {
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            loop = false;
        }
    }

    public void columnsPrint() {
        System.out.println("id\t\tname\t\tphone\t\taddress\t\trent\t\tstate(rent out/not rent)");
    }
}
