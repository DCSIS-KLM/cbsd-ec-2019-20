package org.glassfish.movieplex7.batch;

import java.util.List;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.glassfish.movieplex7.entities.Sales;

@Named
@Dependent
public class SalesWriter extends AbstractItemWriter {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void writeItems(List list) {
        for (Sales sales : (List<Sales>) list) {
            entityManager.persist(sales);
        }
    }
}
