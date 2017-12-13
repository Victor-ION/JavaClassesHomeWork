package Task11___07_12_2017;

import Task11___07_12_2017.library.Librarian;
import Task11___07_12_2017.library.Storage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {
    private Storage storage;
    private List<Thread> threads = new LinkedList<>();
    private boolean isEnd = false;
    private ServerSocket serverSocket;

    public Server(Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public static void main(String[] args) {
        Server server = new Server(new Storage());
        server.start(1234);

    }

    public void start(int port) {
        try {
            System.out.println("Starting server!");
            serverSocket = new ServerSocket(port);
            System.out.println("ServerSocket created");
            while (!isEnd) {
                System.out.println("waiting for connection");
                Socket socket = serverSocket.accept();
                System.out.println("Somebody is knocking, librarian preparing");
                Thread t = new Thread(new Librarian(socket, this));
                threads.add(t);
                t.start();
                System.out.println("librarian has been started to serve");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            for (Thread t : threads) {
                t.interrupt();
                try {
                    if (serverSocket != null) serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
