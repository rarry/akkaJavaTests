package pl.macjankowski.tests.akka.delete;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RoundRobinRouter;
import pl.macjankowski.tests.akka.delete.msg.DeleteDocumentMsg;
import pl.macjankowski.tests.akka.delete.msg.DeleteFolderMsg;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.02.14
 * Time: 18:57
 * To change this template use File | Settings | File Templates.
 */
public class DeleteMaster extends UntypedActor {



    private final ActorRef deleteFolderWorker;

    public DeleteMaster() {


        deleteFolderWorker = this.getContext().actorOf(new Props(DeleteDocumentWorker.class);

    }

    @Override
    public void onReceive(Object msg) {

        if (msg instanceof DeleteFolderMsg) {
            DeleteFolderMsg deleteFolderMsg = (DeleteFolderMsg) msg;
            deleteFolderWorker.tell(new Work(start, nrOfElements), getSelf());

        } else if (msg instanceof DeleteDocumentMsg) {
            DeleteDocumentMsg deleteDocumentMsg = (DeleteDocumentMsg) msg;
        }
    }
