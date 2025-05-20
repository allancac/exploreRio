package com.example.explorerio.domain.model;

public enum Difficulty {
    EASY("easy",1),
    MEDIUM("medium",2),
    DIFFICULT("difficult",3),
    HARD("hard",4),
    EXTREME("extreme",5);

    private final String label;
    private final int level;

    Difficulty(String label, int level) {
        this.label = label;
        this.level = level;
    }

    public static Difficulty findByLabel(String labelAtt){
        for(var d : Difficulty.values() ){
            if(d.label.equalsIgnoreCase(labelAtt)){
                return d;
            }
        }
        return null;
    }

    public static Difficulty findByLevel(int levelAtt){
        for (var d : Difficulty.values()){
            if(d.level == levelAtt){
                return d;
            }
        }
        return null;
    }


}
