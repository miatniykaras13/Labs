package Lab_10;

import java.io.*;

public class CustomObjectOutputStream extends ObjectOutputStream {
    public CustomObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}
