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
    public static void scan(BeanFactory beanFactory, String packageStr)
            throws InvalidPackageException, NoSuitableConstructorForComponentException {
        String packageUrl = packageStr.replace('.', '/');
        URL url = Thread.currentThread().getContextClassLoader().getResource(packageUrl);
        if(url == null) throw new InvalidPackageException(packageStr, null);
        try {
            List<Class> clazzList = Files.list(Paths.get(url.toURI()))
                    .map(Path::getFileName)
                    .map(filePath -> {
                        try {
                            return Thread.currentThread().getContextClassLoader()
                                    .loadClass(packageStr + filePath.toString());
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
}
