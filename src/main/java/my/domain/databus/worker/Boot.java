package my.domain.databus.worker;

import org.dbpedia.databus_mods.lib.worker.execution.Extension;
import org.dbpedia.databus_mods.lib.worker.execution.ModProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Import({org.dbpedia.databus_mods.lib.worker.AsyncWorker.class})
public class Boot {

    @Component
    public class Processor implements ModProcessor {

        public void process(Extension extension) {
            // TODO
            extension.setType("http://my.domain/ns#DatabusMod");
            // File resultFile = extension.createModResult();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Boot.class);
    }
}
