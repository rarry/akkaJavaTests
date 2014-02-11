package pl.macjankowski.tests.akka.repository;

import pl.macjankowski.tests.akka.resources.IResource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.02.14
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */
public class Store {

    private Map<String, IResource> resources = new HashMap<String, IResource>();
    private static Store instance;

    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    public void put(IResource res) {
        resources.put(res.getPath(), res);
    }

    public IResource get(String path) {
        return resources.get(path);
    }

    public void remove(String path) {
        resources.remove(path);
    }

    public Set<IResource> getChildren(String parentPath) {

        Set<IResource> children = new HashSet<IResource>();
        for (IResource r : resources.values()) {
            if (r.getParent().getPath().equals(parentPath)) {
                children.add(r);
            }
        }
        return children;
    }

}
