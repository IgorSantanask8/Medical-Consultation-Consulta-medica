package br.com.Portifolio.Medical.consultations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedicalConsultationsApplicationSemWeb implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MedicalConsultationsApplicationSemWeb.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

    }
}
