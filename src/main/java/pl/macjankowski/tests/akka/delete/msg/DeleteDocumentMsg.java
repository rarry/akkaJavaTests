package pl.macjankowski.tests.akka.delete.msg;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.02.14
 * Time: 21:36
 * To change this template use File | Settings | File Templates.
 */
public class DeleteDocumentMsg extends DeleteMsg {
    public DeleteDocumentMsg(String path, Long msgId) {
        super(path, msgId);
    }
}
