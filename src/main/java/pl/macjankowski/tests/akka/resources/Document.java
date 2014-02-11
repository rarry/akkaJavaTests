package pl.macjankowski.tests.akka.resources;

import pl.macjankowski.tests.akka.repository.Helper;
import pl.macjankowski.tests.akka.repository.Store;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.02.14
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
public class Document implements IResource {

    private final String path;

    public Document(String path) {
        this.path = path;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public IResource getParent() {
        return Store.getInstance().get(Helper.getParentPath(path));
    }
}
