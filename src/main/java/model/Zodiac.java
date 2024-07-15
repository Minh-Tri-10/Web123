/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author locsu
 */
public class Zodiac {

    private int type_id;
    private int zodiac_id;
    private String compatible_signs;
    private String incompatible_signs;
    private String dessciption;

    public Zodiac() {
    }

    public Zodiac(int type_id, int zodiac_id, String compatible_signs, String incompatible_signs, String dessciption) {
        this.type_id = type_id;
        this.zodiac_id = zodiac_id;
        this.compatible_signs = compatible_signs;
        this.incompatible_signs = incompatible_signs;
        this.dessciption = dessciption;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getZodiac_id() {
        return zodiac_id;
    }

    public void setZodiac_id(int zodiac_id) {
        this.zodiac_id = zodiac_id;
    }

    public String getCompatible_signs() {
        return compatible_signs;
    }

    public void setCompatible_signs(String compatible_signs) {
        this.compatible_signs = compatible_signs;
    }

    public String getIncompatible_signs() {
        return incompatible_signs;
    }

    public void setIncompatible_signs(String incompatible_signs) {
        this.incompatible_signs = incompatible_signs;
    }

    public String getDessciption() {
        return dessciption;
    }

    public void setDessciption(String dessciption) {
        this.dessciption = dessciption;
    }

}
