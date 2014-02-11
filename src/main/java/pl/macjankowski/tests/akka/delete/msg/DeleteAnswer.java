package pl.macjankowski.tests.akka.delete.msg;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.02.14
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
public class DeleteAnswer {
    protected Long msgId;
    protected String path;

    public DeleteAnswer(Long msgId, String path) {
        this.msgId = msgId;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
}
