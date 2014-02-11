package pl.macjankowski.tests.akka.delete;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RoundRobinRouter;
import pl.macjankowski.tests.akka.delete.msg.DeleteDocumentMsg;
import pl.macjankowski.tests.akka.delete.msg.DeleteFailure;
import pl.macjankowski.tests.akka.delete.msg.DeleteFolderMsg;
import pl.macjankowski.tests.akka.repository.Store;
import pl.macjankowski.tests.akka.resources.Document;
import pl.macjankowski.tests.akka.resources.Folder;
import pl.macjankowski.tests.akka.resources.IResource;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.02.14
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
public class DeleteFolderWorker extends UntypedActor {

    private static Long nextMsgId = 0l;
    private static Long getNextMsgId() {
        return nextMsgId++;
    }


    private final Set<String> undeleted = new HashSet<String>();
    private final Set<Long> waitingFor = new HashSet<Long>();
    private final ActorRef deleteDocumentWorkerRouter;

    public DeleteFolderWorker() {

        deleteDocumentWorkerRouter = this.getContext().actorOf(new Props(DeleteDocumentWorker.class).withRouter(new RoundRobinRouter(10)),
                "workerRouter");
    }

    @Override
    public void onReceive(Object msg) {
        if (msg instanceof DeleteFolderMsg) {
            DeleteFolderMsg deleteMsg = (DeleteFolderMsg) msg;
            String path = deleteMsg.getPath();
            Set<IResource> children = Store.getInstance().getChildren(path);

            if (children.isEmpty()) {
                Store.getInstance().remove(path);
            } else {

                for (IResource resource : children) {
                    if (resource instanceof Folder) {
                        Long msgId = getNextMsgId();
                        waitingFor.add(msgId);
                        getSelf().tell(new DeleteFolderMsg(resource.getPath(), msgId), getSelf());
                    } else if (resource instanceof Document) {
                        Long msgId = getNextMsgId();
                        waitingFor.add(msgId);
                        deleteDocumentWorkerRouter.tell(new DeleteDocumentMsg(resource.getPath(), msgId), getSelf());
                    }
                }
            }

        } else if(msg instanceof DeleteFailure){
            DeleteFailure failure = (DeleteFailure)msg;
            undeleted.add(failure.getPath());
            waitingFor.remove(failure.getMsgId());

            if(waitingFor.isEmpty()){
                 getContext().parent().tell(new DeleteFailure());
            }

        }
    }

    private void
}
