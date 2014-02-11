package pl.macjankowski.tests.akka.repository;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.02.14
 * Time: 18:34
 * To change this template use File | Settings | File Templates.
 */
public class Helper {

    public static String removeLastSlash(String path) {
        if (path.endsWith("/")) {
            return path.substring(0, path.length());
        }
        return path;
    }

    public static String getParentPath(String path) {
        path = removeLastSlash(path);
        int index = path.lastIndexOf("/");

        return path.substring(0, index);
    }
}
