package pl.macjankowski.tests.akka.delete.msg;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.02.14
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
public abstract class DeleteMsg {

    private Long msgId;
    private String path;

    protected DeleteMsg(String path, Long msgId) {
        this.path = path;
        this.msgId = msgId;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

