package custom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Валерий on 20.07.2016.
 */
public interface CompanyRepository extends JpaRepository<Company,Integer>{
    List<Company> findByNameOfCompany(String companyName);
}
