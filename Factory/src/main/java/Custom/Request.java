package Custom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Валерий on 20.07.2016.
 */
//заглушка для FactoryUsers
    class FactoryUsers{
    FactoryUsers(){

    }
}

@Entity
public class Request {
    @Id
    @GeneratedValue
    private Integer id;
    private Company company;
    private Date requestDate;
    FactoryUsers users;
    private String description;
    private enum requestState {reject, approved, undifined};

}
