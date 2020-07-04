package br.com.hidarisoft.ftdb.writers;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/*
 * @Param <T>
 */
public class ConsoleItemWriter<T> implements ItemWriter<T> {

    @Override
    public void write(List<? extends T> list) throws Exception {
        for (T item : list) {
            System.out.println(item.toString());
        }
    }
}
