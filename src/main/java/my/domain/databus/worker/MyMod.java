package my.domain.databus.worker;

import org.dbpedia.databus.mods.model.ModActivity;
import org.dbpedia.databus.mods.model.ModActivityMetadata;
import org.dbpedia.databus.mods.model.ModActivityMetadataBuilder;
import org.dbpedia.databus.mods.model.ModActivityRequest;
import org.dbpedia.databus.mods.worker.springboot.EnableModWorkerApi;
import org.dbpedia.databus.mods.worker.springboot.controller.WorkerApiProfile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableModWorkerApi(profile = WorkerApiProfile.Polling)
public class MyMod {

    @Bean
    public ModActivity getModActivity() {
        return new ModActivity() {
            public ModActivityMetadata perform(ModActivityRequest request, ModActivityMetadataBuilder builder) {
                builder.withStatSummary("My Stat Summary");
                return builder.build();
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(MyMod.class, args);
    }
}
