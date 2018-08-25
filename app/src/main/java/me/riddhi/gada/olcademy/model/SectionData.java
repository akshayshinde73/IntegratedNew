package me.riddhi.gada.olcademy.model;

import java.util.ArrayList;

public class SectionData {

    private String headerTitle;
    private ArrayList<SingleItem> allItemsInSection;


    public SectionData() {

    }

    public SectionData(String headerTitle, ArrayList<SingleItem> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleItem> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleItem> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }


}
