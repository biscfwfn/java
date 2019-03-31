package com.example.tools.map;

import com.example.tools.entity.GLatLngEntity;

import java.math.BigDecimal;

public class TestMain {
    public static void main(String[] args){
        GLatLngEntity n1 = new GLatLngEntity();
        n1.setLongitude(BigDecimal.valueOf(116.40576));
        n1.setLatitude(BigDecimal.valueOf(39.913825));
        GLatLngEntity n2 = new GLatLngEntity();
        n2.setLongitude(BigDecimal.valueOf(117.126277));
        n2.setLatitude(BigDecimal.valueOf(36.660414));
        log("坐标点之间的距离："+Gis.getGLtLngDistance(n1,n2));
        log("==============================================================================");
    }
    private static void log(Object str){
        System.out.println(str);
    }
}
