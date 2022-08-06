package guru.springframwork.msscbeerclient.web.client;

import guru.springframwork.msscbeerclient.web.model.BeerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        Assertions.assertNotNull(dto);
    }

    @Test
    void saveBeer() {
        BeerDto dto = BeerDto.builder().beerName("beerDark").beerStyle("PORTER").build();
        URI uri = client.saveBeer(dto);
        Assertions.assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        BeerDto dto = BeerDto.builder().beerName("beerDark").beerStyle("PORTER").build();
        client.updateBeer(UUID.randomUUID(), dto);
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }
}