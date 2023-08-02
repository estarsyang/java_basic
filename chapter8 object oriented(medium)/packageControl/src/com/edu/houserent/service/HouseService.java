package com.edu.houserent.service;

import com.edu.houserent.domain.House;

public class HouseService {

    private House[] houses;
    private int houseNum = 0;
    private int houseIdCount = 0;

    public HouseService(int size) {
        this.houses = new House[size];
        // mock
//        houses[0] = new House(1, "jack", "123", "street a", 1000, "rent out");
    }

    public boolean add(House newHouse) {
        // not consider array resize, fix array length.
        if (houseNum >= houses.length) {
            System.out.println("House is fulled, can't not add");
            return false;
        } else {
            // id need to self increase.
            newHouse.setId(++houseIdCount);
            houses[houseNum++] = newHouse;
            return true;

        }
    }

    public boolean delete(int houseId) {
        int delHouseIdx = -1;
        for (int i = 0; i < houseNum; i++) {
            if (houses[i].getId() == houseId) {
                delHouseIdx = i;
            }
        }
        if (delHouseIdx == -1) {
            System.out.println("input house id doesn't exist!");
            return false;
        }
        // delete
        // i is the id of delete house, delete houses[i], and after delete, next house move to empty position.
        for (int i = delHouseIdx; i < houseNum - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNum] = null; // set null to delHouseIdx position.
        houseIdCount--;
        return true;
    }

    public House findById(int houseId){
        for (int i = 0; i < houseNum; i++) {
            if (houses[i].getId()==houseId){
                return houses[i];
            }
        }
        return null;
    }

    public House[] list() {
        return houses;
    }
}
