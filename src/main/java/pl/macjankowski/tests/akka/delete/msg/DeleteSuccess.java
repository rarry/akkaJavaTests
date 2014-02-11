package pl.macjankowski.tests.akka.delete.msg;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.02.14
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 */
public class DeleteSuccess extends DeleteAnswer {

    public DeleteSuccess(Long msgId, String path) {
        super(msgId, path);
    }
}
