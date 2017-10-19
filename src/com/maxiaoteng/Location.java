package com.maxiaoteng;

public class Location {
    int x,y;

    public Location() {
        this.x = 0;
        this.y = 0;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Location lo = (Location)obj;
        if(this.getX()==lo.getX() && this.getY()==lo.getY()){
            return true;
        }else
            return false;
    }
}
