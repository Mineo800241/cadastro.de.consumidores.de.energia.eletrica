package cadastroConsumidor.Batch;

import cadastroConsumidor.Consumidor.client.ConsumidorClient;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
public class BatchConfig {

    @Bean
    public FlatFileItemReader<ConsumidorBatch> consumidorReader() {

        return new FlatFileItemReaderBuilder<ConsumidorBatch>()
                .name("consumidorReader")
                .resource(new ClassPathResource("batch/consumidores.csv"))
                .linesToSkip(1)
                .delimited().delimiter(";")
                .names("uc", "nome", "endereco", "email", "medidor", "transformador", "chave", "alimentador", "situacao")
                .targetType(ConsumidorBatch.class)
                .build();
    }

    @Bean
    public ItemWriter<ConsumidorRequest>  consumidorApiWriter(ConsumidorClient consumidorClient) {
        return chunk -> {
            for (ConsumidorRequest consumidor : chunk.getItems()){
                System.err.println("[ConsumidorApiWriter] Consumidor enviado para Api = " + consumidor);
                consumidorClient.cadastrarConsumidor(consumidor);}
    };
    }

    @Bean
    public FlatFileItemWriter<ConsumidorBatch> consumidorWriter() {

        return new FlatFileItemWriterBuilder<ConsumidorBatch>()
                .name("consumidorWriter")
                .resource(new FileSystemResource("target/consumidores-processados.csv"))
                .shouldDeleteIfExists(true)
                .headerCallback(writer -> writer.write("uc;nome;endereco;email;medidor;transformador;chave;alimentador;situacao"))
                .delimited().delimiter(";")
                .names("uc",
                        "nome",
                        "endereco",
                        "email",
                        "medidor",
                        "transformador",
                        "chave",
                        "alimentador",
                        "situacao")
                .build();
    }

    @Bean
    public Step importarConsumidoresStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            FlatFileItemReader<ConsumidorBatch> consumidorReader,
            ConsumidorProcessor consumidorProcessor,
            ItemWriter<ConsumidorRequest>  consumidorApiWriter
            )
            {
        return new StepBuilder("importarConsumidoresStep",jobRepository)
                .<ConsumidorBatch, ConsumidorRequest>chunk(3,transactionManager)
                .reader(consumidorReader)
                .processor(consumidorProcessor)
                .writer(consumidorApiWriter)
                .build();
    }

    @Bean
    public Step resumoProcessamentoStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager){
        return new StepBuilder("resumoProcessamentoStep",jobRepository)
                .tasklet((contribution, chunkContext) -> {

                    System.out.println("STEP 2: PROCESSAMENTO DE CONSUMIDOR CONCLUIDO");

                    System.out.println("STEP 2: OS ALUNOS VÁLIDO SERÃO ENVIADO PARA API");

                    return RepeatStatus.FINISHED;
                },transactionManager).build();
    }

//    @Bean
//    public Step importarConsumidoresStep(
//            JobRepository jobRepository,
//            PlatformTransactionManager transactionManager,
//            FlatFileItemReader<ConsumidorBatch> consumidorReader,
//            ConsumidorProcessor consumidorProcessor,
//            FlatFileItemWriter<ConsumidorBatch> consumidorWriter
//    )
//    {
//        return new StepBuilder("importarConsumidoresStep",jobRepository)
//                .<ConsumidorBatch, ConsumidorBatch>chunk(3,transactionManager)
//                .reader(consumidorReader)
//                .processor(consumidorProcessor)
//                .writer(consumidorWriter)
//                .build();
//    }

//    @Bean
    public Job importarConsumidorJob(
            JobRepository jobRepository,
            Step importarConsumidoresStep,
            Step resumoProcessamentoStep
    )
    {
    return new JobBuilder("importarConsumidorJob",jobRepository)
            .incrementer(new RunIdIncrementer())
            .start((importarConsumidoresStep))
            .next(resumoProcessamentoStep)
        .build();
    }


}
