package com.test.sun;

import com.test.sun.interceptor.UserDefinedInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

@SpringBootApplication
@MapperScan({"com.test.sun.mapper","com.test.sun.dao"})
@ServletComponentScan("com.test.sun.interceptor")
public class SunApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SunApplication.class, args);
        // 扩展启动行为
        SpringApplication bootstrap = new SpringApplication(SunApplication.class);
        bootstrap.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                // 打印图片
                createAsciiPic("C:\\Users\\pc\\Pictures\\timg.jpg");
            }
        });
        bootstrap.setBannerMode(Banner.Mode.CONSOLE);
        bootstrap.run(args);

    }
    /**
     * 注册bean
     */
    @Configuration
    public class InterceptorConfig implements WebMvcConfigurer {

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new UserDefinedInterceptor());
        }
    }

    /**
     * @param path
     *            图片路径
     */
    public static void createAsciiPic(final String path) {
        final String base = "@#&$%*o!;.";// 字符串由复杂到简单
        try {
            final BufferedImage image = ImageIO.read(new File(path));
            for (int y = 0; y < image.getHeight(); y += 2) {
                for (int x = 0; x < image.getWidth(); x++) {
                    final int pixel = image.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);
                    System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                }
                System.out.println();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}

