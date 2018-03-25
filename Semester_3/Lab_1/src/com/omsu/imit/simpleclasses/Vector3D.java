package com.omsu.imit.yana.simpleclasses;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D(Point3D a, Point3D b) {
        this.x = b.getX() - a.getX();
        this.y = b.getY() - a.getY();
        this.z = b.getZ() - a.getZ();
    }

    @Override
    public String toString() {
        return " [" + this.x + "; " + this.y + "; " + this.z + "] ";
    }

    public double lengthVector() {
        return Math.sqrt(getX() * getX() + getY() * getY() + getZ() * getZ());
    }

    public boolean checkEquality(Vector3D a) {
        if (a == null) {
            return false;
        }
        return (x == a.x) && (y == a.y) && (z == a.z);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector3D vector3D = (Vector3D) o;

        if (x != vector3D.x) return false;
        if (y != vector3D.y) return false;
        return z == vector3D.z;
    }
}
