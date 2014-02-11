package pl.macjankowski.tests.akka.resources;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.02.14
 * Time: 17:26
 * To change this template use File | Settings | File Templates.
 */
public interface IResource {

    public String getPath();

    public IResource getParent();
}
