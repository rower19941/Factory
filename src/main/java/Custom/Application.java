package custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Валерий on 20.07.2016.
 */
@SpringBootApplication
public class Application {
    public static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws ParseException {
        /*String d1 = "23.11.2011";
        String d2 = " 25.11.2011";
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = format.parse(d1);
            date2 = format.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long difference = date1.getTime() - date2.getTime();
        int days = (int) difference / (24 * 60 * 60 * 1000);
        System.out.println("days=" + days);*/

        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner loadData(PersonRepository personRepository,
                                      CarRepository carRepository,
                                      CompanyRepository companyRepository) {
        return (args) -> {
            //компании
            Person testPerson = new Person("Yarik", "Schehvatow", "SPbGTI", "1234");
            Person testPerson1 = new Person("qwer", "qwer", "SPbGTI", "1234");
            companyRepository.save(new Company("lll", testPerson));
            companyRepository.save(new Company("qwer", testPerson1));
            //сохраним персон
            personRepository.save(new Person("Yarik", "Schehvatow", "SPbGTI", "1234"));
            personRepository.save(new Person("Valerii", "Koval", "SPbGTI", "2345"));
            personRepository.save(new Person("Dasha", "Lathisheva", "SPbGTI", "8966"));
            personRepository.save(new Person("Gorge", "Mayster", "ITMO", "8898"));
            //сохраним автомобили
            carRepository.save(new Car("Red", "889", "Toyota"));
            carRepository.save(new Car("Pink", "336", "Nissan"));
            carRepository.save(new Car("Black", "986", "Mercedes"));

          /*
          * Поиск в carRepository
          * */
            log.info("Find all cars");
            log.info("---------------------------------");
            for (Car car : carRepository.findAll()) {
                log.info(car.toString());
            }
            log.info("");

            log.info("Find cars by color");
            log.info("---------------------------------");
            for (Car car : carRepository.findByCarColorStartsWithIgnoreCase("Red")) {
                log.info(car.toString());
            }
            log.info("");

            log.info("Find cars by registrationNumber");
            log.info("---------------------------------");
            for (Car car : carRepository.findByCarRegistrationNumberStartsWithIgnoreCase("889")) {
                log.info(car.toString());
            }
            log.info("");

            log.info("Find cars by carModel");
            log.info("---------------------------------");
            for (Car car : carRepository.findByCarModelStartsWithIgnoreCase("Nissan")) {
                log.info(car.toString());
            }
            log.info("");

          /*
          * Поиск в companyRepository
          * */
            log.info("Find all company");
            log.info("---------------------------------");
            for (Company company : companyRepository.findAll()) {
                log.info(company.toString());
            }
            log.info("");


          /*
          * Поиск в personRepository
          * */

            log.info("Find persons by companyName");
            log.info("---------------------------------");
            for (Person person : personRepository.findByCompanyNameStartsWithIgnoreCase("ITMO")) {
                log.info(person.toString());
            }
            log.info("");

            log.info("Find all persons");
            log.info("---------------------------------");
            for (Person person : personRepository.findAll()) {
                log.info(person.toString());
            }
            log.info("");


        };
    }
}
