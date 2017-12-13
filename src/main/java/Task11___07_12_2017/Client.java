package Task11___07_12_2017;

import Task11___07_12_2017.library.Book;
import Task11___07_12_2017.library.UnavailableBookException;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private int size;

    private void writeToConsole(String message) {
        System.out.println("Client: " + message);
    }

    public Client(String ip, int port) throws IOException {
        writeToConsole("Getting socket");
        Socket socket = new Socket(ip, port);
        writeToConsole("Got socket");
        output = new DataOutputStream(socket.getOutputStream());
        output.flush();
        input = new DataInputStream(socket.getInputStream());
        writeToConsole("Client started!");
        size = input.readInt();
        writeToConsole("got size of books: " + size);
    }


    /**
     * for demonstrating abilities
     *
     * @param args
     */
    public static void main(String[] args) {
        Client client = null;
        try {
            client = new Client("localhost", 1234);
            try {
                System.out.println(client.getBookForHome(1));
                client.writeToConsole("got 1 book");
            } catch (UnavailableBookException e) {
                client.writeToConsole(e.getMessage());
            }
            try {
                System.out.println(client.getBookForReadingRoom(3));
                client.writeToConsole("got 3 book");
            } catch (UnavailableBookException e) {
                client.writeToConsole(e.getMessage());
            }
            try {
                System.out.println(client.getBookForHome(3));
                client.writeToConsole("got 3 book");
            } catch (UnavailableBookException e) {
                client.writeToConsole(e.getMessage());
            }
            try {
                System.out.println(client.getBookForReadingRoom(2));
                client.writeToConsole("got 2 book");
            } catch (UnavailableBookException e) {
                client.writeToConsole(e.getMessage());
            }

            client.endDeal();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                try {
                    client.input.close();
                    client.output.close();
                    if (client.socket != null) {
                        client.socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Book getBookForReadingRoom(int id) throws IOException, ClassNotFoundException {
        output.writeInt(1);
        output.flush();

        return getBook(id);
    }

    private Book getBook(int id) throws IOException, ClassNotFoundException {
        output.writeInt(id);
        output.flush();


        int resCode = input.readInt();
        switch (resCode) {
            case 1: {
                throw new UnavailableBookException("Not present at the moment");
            }
            case 2: {
                throw new UnavailableBookException("Not available for home");
            }
            case 3: {
                throw new UnavailableBookException("Incorrect id");
            }
            case 0: {
                Gson gson = new Gson();
                Book book = gson.fromJson(input.readUTF(), Book.class);
                return book;
            }
        }
        return null;
    }

    public Book getBookForHome(int id) throws IOException, ClassNotFoundException {
        output.writeInt(2);
        output.flush();

        return getBook(id);
    }

    public void endDeal() throws IOException {
        output.writeInt(3);
        output.flush();
        writeToConsole("Ending client working");
    }

}
