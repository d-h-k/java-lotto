package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class IssuerTest {
    private Issuer issuerFixture;
    @BeforeEach
    public void beforeEach() {
        issuerFixture = new Issuer();
    }

    @DisplayName("발급수량만큼 응모권이 발행된다")
    @Test
    public void issue() {
        //given
        int input = 77;
        //when
        issuerFixture.purchaseTickets(input);
        //then
        assertThat(issuerFixture.purchasedTickets()).hasSize(input);
    }
}