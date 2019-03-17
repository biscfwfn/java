package com.example.tools.map;

import com.example.tools.entity.GLatLngEntity;

import java.math.BigDecimal;

public class Gis {
    /**
     * 地球半径,单位 m
     */
    private static final double EARTH_RADIUS = 6378137;

    /**
     * 根据经纬度，计算两点间的距离
     *
     * @param g1 第一个点的经度
     * @param g2 第二个点的经度
     * @return 返回距离 单位千米
     */
    public static double getGLtLngDistance(GLatLngEntity g1, GLatLngEntity g2) {
        // 经度
        double lng1 = Math.toRadians(g1.getLongitude().doubleValue());
        double lng2 = Math.toRadians(g2.getLongitude().doubleValue());
        // 纬度
        double lat1 = Math.toRadians(g1.getLatitude().doubleValue());
        double lat2 = Math.toRadians(g2.getLatitude().doubleValue());
        // 纬度之差
        double a = lat1 - lat2;
        // 经度之差
        double b = lng1 - lng2;
        // 计算两点距离的公式
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(b / 2), 2)));
        // 弧长乘地球半径, 返回单位: 米
        return BigDecimal.valueOf(s * EARTH_RADIUS).setScale(2,BigDecimal.ROUND_DOWN).doubleValue();
    }

}
