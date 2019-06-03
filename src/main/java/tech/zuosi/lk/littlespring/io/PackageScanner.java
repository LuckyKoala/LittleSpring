package tech.zuosi.lk.littlespring.io;

import tech.zuosi.lk.littlespring.exception.InvalidPackageException;
import tech.zuosi.lk.littlespring.exception.NoSuitableConstructorForComponentException;
import tech.zuosi.lk.littlespring.ioc.BeanFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by luckykoala on 19-2-28.
 */
public class PackageScanner {
    private static final char PACKAGE_SEPRATOR = '.';
    private static final char PATH_SEPARATOR = '/';
    private static final String CLASS_FILE_SUFFIX = ".class";

    /**
     * 遍历查找指定包下的class文件，加载并读取配置
     * @param beanFactory bean工厂实例
     * @param packageStr 包名
     * @throws InvalidPackageException 找不到指定的包
     * @throws NoSuitableConstructorForComponentException 找不到合适的构造器来构造组件的实例
     */
    public static void scan(BeanFactory beanFactory, String packageStr)
            throws InvalidPackageException, NoSuitableConstructorForComponentException {
        String packageUrl = packageStr.replace(PACKAGE_SEPRATOR, PATH_SEPARATOR);
        URL url = Thread.currentThread().getContextClassLoader().getResource(packageUrl);
        if(url == null) throw new InvalidPackageException(packageStr, null);
        try {
            List<Class> clazzList = Files.list(Paths.get(url.toURI()))
                    .map(Path::getFileName)
                    .map(filePath -> {
                        try {
                            String className = packageStr + PACKAGE_SEPRATOR + withoutSuffix(filePath.toString(),
                                    CLASS_FILE_SUFFIX);
                            return Class.forName(className);
                        } catch (ClassNotFoundException e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull).collect(Collectors.toList());
            for(Class clazz : clazzList) {
                beanFactory.readComponent(clazz);
            }
        } catch (IOException | URISyntaxException e) {
            throw new InvalidPackageException(packageStr, e);
        }
    }

    private static String withoutSuffix(String str, String suffix) {
        if(str.isEmpty() || suffix.isEmpty()) return str;
        if(str.endsWith(suffix)) return str.substring(0, str.length()-suffix.length());
        else return str;
    }
}
