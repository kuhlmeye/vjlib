package net.kuhlmeyer.vjlib;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Communicator {


    default short[] sendAndReceive(InputStream is, OutputStream os, short responseLength, short... req) throws IOException {
        return sendAndReceive(is, os, SendMode.Read, responseLength, req);
    }

    short[] sendAndReceive(InputStream is, OutputStream os, SendMode sendMode, short responseLength, short... request) throws IOException;
}
