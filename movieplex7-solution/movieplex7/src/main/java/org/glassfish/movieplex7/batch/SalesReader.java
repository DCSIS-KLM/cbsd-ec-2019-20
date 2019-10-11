package org.glassfish.movieplex7.batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import javax.batch.api.chunk.AbstractItemReader;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@Dependent
public class SalesReader extends AbstractItemReader {

    private BufferedReader reader;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        reader = new BufferedReader(
                new InputStreamReader(
                        Thread.currentThread()
                        .getContextClassLoader()
                        .getResourceAsStream("META-INF/sales.csv")));
    }

    @Override
    public String readItem() {
        String line = null;

        try {
            line = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return line;
    }
}
