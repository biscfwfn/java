package com.example.tools.draw;

import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * <!-- https://mvnrepository.com/artifact/com.google.zxing/javase -->
 * <dependency>
 *     <groupId>com.google.zxing</groupId>
 *     <artifactId>javase</artifactId>
 *     <version>3.4.0</version>
 * </dependency>
 *
 */
public class QrCode {
    /**
     * 默认二维码宽度
     */
    private static final int WIDTH = 300;
    /**
     * 默认二维码高度
     */
    private static final int HEIGHT = 300;
    /**
     * 默认二维码文件格式
     */
    private static final String FORMAT = "png";
    /**
     * 二维码参数
     */
    private static final Map<EncodeHintType, Object> HINTS = new HashMap();

    static {
        HINTS.put(EncodeHintType.CHARACTER_SET, "utf-8");
        HINTS.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        HINTS.put(EncodeHintType.MARGIN, 0);
    }

    private static BufferedImage drawQrCode(String content, int width, int height){
        return null;
    }
}
