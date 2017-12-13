package Task11___07_12_2017.library;

import Task11___07_12_2017.Server;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class Librarian implements Runnable {
    private Server mainServer;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public Librarian(Socket socket, Server server) {
        writeToConsole("Start of creating librarian");
        this.socket = socket;
        this.mainServer = server;

    }

    public void writeToConsole(String message) {
        System.out.println("Librarian: " + message);
    }

    @Override
    public void run() {
        try {
            writeToConsole("try to open input");
            input = new DataInputStream(socket.getInputStream());
            writeToConsole("try to open output");
            output = new DataOutputStream(socket.getOutputStream());
//            output.flush();
            writeToConsole("deal with input/output");

            writeToConsole("end of creating librarian");
            // as first message, sends size of the books
            writeToConsole("Start to serve");
            output.writeInt(mainServer.getStorage().getBooks().size());
            output.flush();
            writeToConsole("info about size was sent");

            while (!Thread.currentThread().isInterrupted()) {
                // type: 1 - get book for reading room
                //       2 - get book for home
                writeToConsole("Start reading the command");
                int type = input.readInt();
                if (type == 3) {
                    writeToConsole("End of working with client");
                    break;
                }
                int id = input.readInt();
                writeToConsole("Got the command");

                Book book = null;
                if (id >= mainServer.getStorage().getBooks().size() || id < 0
                        || (book = mainServer.getStorage().getBook(id)) == null) {
                    // 3 - incorrect id
                    output.writeInt(3);
                    output.flush();

                    continue;
                }
                synchronized (book) {

                    switch (type) {
                        case 1: {
                            if (book.isPresent()) {
                                output.writeInt(0);
                                book.setPresent(false);
                                sendBookAsJson(book, output);

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
                                    book.setPresent(false);
                                    sendBookAsJson(book, output);
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

    public static void sendBookAsJson(Book book, DataOutputStream output) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(book);
        output.writeUTF(json);
    }
}
