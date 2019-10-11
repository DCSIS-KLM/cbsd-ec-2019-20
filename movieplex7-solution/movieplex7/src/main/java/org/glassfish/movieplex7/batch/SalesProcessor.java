package org.glassfish.movieplex7.batch;

import java.util.StringTokenizer;
import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import org.glassfish.movieplex7.entities.Sales;

@Named
@Dependent
public class SalesProcessor implements ItemProcessor {

    @Override
    public Sales processItem(Object line) {
        Sales sales = new Sales();

        StringTokenizer tokens = new StringTokenizer((String) line, ",");
        sales.setId(Integer.parseInt(tokens.nextToken()));
        sales.setAmount(Float.parseFloat(tokens.nextToken()));

        return sales;
    }
}
