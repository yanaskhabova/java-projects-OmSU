package com.omsu.imit.yana.simpleclasses;

public class Point3D {
    private double x;
    private double y;
    private double z;

    public Point3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "[" + this.x + "; " + this.y + "; " + this.z + "]";
    }

    public boolean checkEquality(Point3D a) {
        if (a == null) {
            return false;
        }
        return (x == a.x) && (y == a.y) && (z == a.z);
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point3D)) return false;

        Point3D point3D = (Point3D) o;

        if (Double.compare(point3D.getX(), getX()) != 0) return false;
        if (Double.compare(point3D.getY(), getY()) != 0) return false;
        return Double.compare(point3D.getZ(), getZ()) == 0;
    }
}
