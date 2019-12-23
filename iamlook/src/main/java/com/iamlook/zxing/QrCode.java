package com.iamlook.zxing;


import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.iamlook.utils.MatrixToImageWriter;

/**
 * 生成和读取二维码.
 *
 * @author yx
 * @version 1.0
 * @since 19-12-23上午9:02
 */
public class QrCode {

    public static String generate() throws Exception {
        String text = "HelloWorld";

        int width = 300;
        int height = 300;

        // 二维码的图片格式
        String format = "png";
        Hashtable<EncodeHintType, String> hints = new Hashtable<>();

        // 内容所使用编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text,
                BarcodeFormat.QR_CODE, width, height, hints);

        // 生成二维码
        File outputFile = new File(
                "/home/sddt/youxun"
                        + File.separator
                        + "qrcode"
                        + File.separator
                        + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")
                        .format(new Date()) + ".png");
        System.out.println("图片生成在:[" + outputFile.getAbsolutePath() + "]");
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
        return outputFile.getAbsolutePath();
    }

    public static void read(String fileName) throws Exception {
        Reader reader = new MultiFormatReader();

        BufferedImage image = ImageIO.read(new File(fileName));

        LuminanceSource source = new BufferedImageLuminanceSource(image);
        Binarizer binarizer = new HybridBinarizer(source);

        BinaryBitmap bitmap = new BinaryBitmap(binarizer);

        Map<DecodeHintType, String> hints = new HashMap<>();

        hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");

        Result result = reader.decode(bitmap);

        System.out.println(result.toString());

    }

    public static void main(String[] args) throws Exception {
        String filePath = generate();
        read(filePath);
    }
}