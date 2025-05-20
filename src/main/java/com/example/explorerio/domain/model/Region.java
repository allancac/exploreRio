package com.example.explorerio.domain.model;

public enum Region {
    SOUTH("south"),
    NORTH("north"),
    WEST("west");

    private final String label;
    private Region(String label) {
        this.label = label;
    }

    public  static Region findByLabel(String lbl){
        for(var r: Region.values()){
            if (r.label.equalsIgnoreCase(lbl)){
                return r;
            }
        }
        return null;
    }
}
