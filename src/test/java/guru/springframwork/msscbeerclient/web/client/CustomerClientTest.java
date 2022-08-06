package guru.springframwork.msscbeerclient.web.client;

import guru.springframwork.msscbeerclient.web.model.CustomerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
        CustomerDto customerById = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerById);
    }

    @Test
    void saveCustomer() {
        CustomerDto user_ka = CustomerDto.builder().name("user Ka").build();

        URI uri = client.saveCustomer(user_ka);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto user_ka = CustomerDto.builder().name("user Ka").build();
        client.updateCustomer(UUID.randomUUID(),user_ka);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}