//class tambahan dari modul 5
package com.praktikum.data;

public class Item {

    private String itemName;
    private String description;
    private String location;
    private String status;

    public Item(String itemName, String description, String location, String status) {
        this.itemName = itemName;
        this.description = description;
        this.location = location;
        this.status = status;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayItem() {
        System.out.println("Nama Barang   : " + itemName);
        System.out.println("Deskripsi     : " + description);
        System.out.println("Lokasi        : " + location);
        System.out.println("Status        : " + status);
        System.out.println("-------------------------------");
    }

}
