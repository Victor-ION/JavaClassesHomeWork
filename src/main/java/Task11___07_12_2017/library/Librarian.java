package Task11___07_12_2017.library;

import Task11___07_12_2017.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Librarian implements Runnable {
    private Server mainServer;
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Librarian(Socket socket, Server server) {
        writeToConsole("Start of creating librarian");
        this.socket = socket;
        this.mainServer = server;

    }

    private void writeToConsole(String message) {
        System.out.println("Librarian: " + message);
    }

    @Override
    public void run() {
        try {
            writeToConsole("try to open output");
            output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            writeToConsole("try to open input");
            input = new ObjectInputStream(socket.getInputStream());
            writeToConsole("deal with input/output");

            writeToConsole("end of creating librarian");
            // as first message, sends size of the books
            writeToConsole("Start to serve");
            output.writeObject(mainServer.getStorage().getBooks().size());
            output.flush();
            writeToConsole("info about size was sent");

            while (!Thread.currentThread().isInterrupted()) {
                // type: 1 - get book for reading room
                //       2 - get book for home
                int type = input.readInt();
                int id = input.readInt();
                writeToConsole("read the command");

                Book book = null;
                if (id >= mainServer.getStorage().getBooks().size() || id < 0
                        || (book = mainServer.getStorage().getBook(id)) == null) {
                    // 3 - incorrect id
                    output.writeInt(3);
                    output.flush();

                    continue;
                }
                switch (type) {
                    case 1: {
                        if (book.isPresent()) {
                            output.writeInt(0);
                            output.writeObject(book);
                            output.flush();

                        } else {
                            // 1 - not present at the moment
                            output.writeInt(1);
                            output.flush();

                        }
                        break;
                    }
                    case 2: {
                        if (book.isPresent()) {
                            if (book.isAvailableForHome()) {
                                output.writeInt(0);
                                output.writeObject(book);
                                output.flush();

                            } else {
                                // 2 - not available for home
                                output.writeInt(2);
                                output.flush();

                            }
                        } else {
                            // 1 -  not present at the moment
                            output.writeInt(1);
                            output.flush();

                        }
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                input.close();
                output.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
