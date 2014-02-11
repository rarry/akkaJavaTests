package pl.macjankowski.tests.akka.repository;

import pl.macjankowski.tests.akka.resources.Document;
import pl.macjankowski.tests.akka.resources.Folder;

/**
 * Created with IntelliJ IDEA.
 * User: mac
 * Date: 11.02.14
 * Time: 18:02
 * To change this template use File | Settings | File Templates.
 */
public class StoreTools {

    public static void initRepository() {

        String[] folders = new String[]{
                "/", "/a/", "/b/", "/c/",
                "/a/documents/", "/a/constracts/", "/a/invoices/",
                "/a/documents"
        };

        String[] documents = new String[]{
                "/a/documents/doc1.txt",
                "/a/documents/doc2.txt",
                "/a/documents/doc3.txt",
                "/a/constracts/contr1.txt",
                "/a/constracts/contr2.txt",
                "/a/constracts/contr3.txt",
                "/a/invoices/inv1.txt" ,
                "/a/invoices/inv2.txt",
                "/a/invoices/inv3.txt"
        };

        for (String path: folders) {
            Store.getInstance().put(new Folder(path));
        }

        for (String path : documents) {
            Store.getInstance().put(new Document(path));
        }
    }
}
