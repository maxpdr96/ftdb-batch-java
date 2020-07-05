package br.com.hidarisoft.ftdb.partitioners;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FilePartitioner implements Partitioner {

    private static final int BATCH_SIZE = 100;
    private static final String PARTITION_KEY = "partition";
    private Resource[] resources = new Resource[0];


    @Override
    public Map<String, ExecutionContext> partition(int gridSize) {
        Map<String, ExecutionContext> map = new HashMap<String, ExecutionContext>();
        int i = 0;
        for(Resource resource : resources){
            if(i == BATCH_SIZE){
                return map;
            }else {
                ExecutionContext context = new ExecutionContext();
                Assert.state(resource.exists(), "Resource does not exists: " + resource);
                try{
                    String inputKeyName = "inputFilePath";
                    context.putString(inputKeyName, resource.getURL().toExternalForm());
                }catch (IOException e){
                    throw new IllegalArgumentException("File could not be located for: " + resource, e);
                }

                map.put(PARTITION_KEY + i, context);
                i++;
            }
        }
        return map;
    }

    public void setResources(Resource[] resources) {
        this.resources = resources;
    }
}
