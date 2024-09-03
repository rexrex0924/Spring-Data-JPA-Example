package com.springdataJPAexample.jpa;

import com.github.javafaker.Faker;
import com.springdataJPAexample.jpa.Specification.AuthorSpecification;
import com.springdataJPAexample.jpa.models.Author;
import com.springdataJPAexample.jpa.models.Video;
import com.springdataJPAexample.jpa.models.embedded.Address;
import com.springdataJPAexample.jpa.repositories.AuthorRepository;
import com.springdataJPAexample.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository,
											   VideoRepository videoRepository){
		return args -> {
			Faker faker = new Faker();
			for(int i=1; i<=50; i++){
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(20,80))
						.email(faker.name().username() + "@gmail.com")
						.build();
				repository.save(author);
			}

			//update author where id = 1
			var author = Author.builder()
					.id(1)
					.firstName("Rex")
					.lastName("Siu")
					.age(21)
					.email("rexsiu@gmail.com")
					.build();
			//repository.save(author);

			// update Author a set a.age = 22 where a.id = 1
			//repository.updateAuthor(22, 1);
			//repository.updateAllAuthorsAges(22);

			//repository.findByNamedQuery(20).forEach(System.out::println);

			//update with named query
			//repository.updateByNamedQuery(12);

			Specification<Author> spec = Specification
							.where(AuthorSpecification.hasAge(21)
							.or(AuthorSpecification.firstnameLike("M")));
			repository.findAll(spec).forEach(System.out::println);
		};

	}

}
