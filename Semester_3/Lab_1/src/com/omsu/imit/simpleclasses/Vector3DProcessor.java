package com.omsu.imit.yana.simpleclasses;



public class Vector3DProcessor {

    public static Vector3D sumVector(Vector3D v1, Vector3D v2) {
        return new Vector3D(v1.getX() + v2.getX(), v1.getY() + v2.getY(), v1.getZ() + v2.getZ());
    }

    public static Vector3D subtractVector(Vector3D v1, Vector3D v2) {
        return new Vector3D(v1.getX() - v2.getX(), v1.getY() - v2.getY(), v1.getZ() - v2.getZ());
    }

    public static double scalarMultiplication(Vector3D v1, Vector3D v2) {
        return v1.getX() * v2.getX() + v1.getY() * v2.getY() + v1.getZ() * v2.getZ();
    }

    public static Vector3D vectorMultiplication(Vector3D v1, Vector3D v2) {
        return new Vector3D(v1.getY() * v2.getZ() - v1.getZ() * v2.getY(),
                v1.getZ() * v2.getX() - v1.getX() * v2.getZ(),
                v1.getX() * v2.getY() - v1.getY() * v2.getX()
        );
    }

    public static boolean checkCollinearity(Vector3D v1, Vector3D v2) {
        if (v2.getX() == 0 && v2.getY() == 0 && v2.getZ() == 0) {
            return true;
        } else if (v2.getX() == 0 || v2.getY() == 0 || v2.getZ() == 0) {
            return false;
        }
        if (v1.getX() / v2.getX() == v1.getY() / v2.getY() && v1.getY() / v2.getY() == v1.getZ() / v2.getZ()) {
            return true;
        }
        return false;
    }
}
