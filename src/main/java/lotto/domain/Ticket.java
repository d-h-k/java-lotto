package lotto.domain;

import lotto.exception.TicketNumbersCountException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Ticket {
    private final Set<LottoNumber> numbers;

    public Ticket(Set<Integer> numbers) {
        this.numbers = parseToLottoNumbers(numbers);
        validate();
    }

    public Ticket(String stringNumbers) {
        this.numbers = parseToLottoNumbers(parseToNumbers(stringNumbers));
        validate();
    }

    private static int overlapCount(Set<LottoNumber> copyThisNumbers) {
        return 12 - copyThisNumbers.size();
    }

    private Set<LottoNumber> parseToLottoNumbers(Set<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (Integer integer : numbers) {
            lottoNumbers.add(new LottoNumber(integer));
        }
        return lottoNumbers;
    }

    private Set<Integer> parseToNumbers(String stringNumbers) {
        Set<Integer> numbers = new HashSet<>();
        for (String number : stringNumbers.split(", ")) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private void validate() {
        if (this.numbers.size() != 6) {
            throw new TicketNumbersCountException();
        }
    }

    public int countMatchNumbers(Ticket otherTicket) {
        Set<LottoNumber> copyThisNumbers = new HashSet<>(this.numbers);
        copyThisNumbers.addAll(otherTicket.numbers);
        return overlapCount(copyThisNumbers);
    }

    public WinnerTicket winnerTicket(LottoNumber bonusNumber) {
        return new WinnerTicket(this, bonusNumber);
    }

    @Override
    public String toString() {
        return this.numbers
                .stream()
                .map(number -> Integer.toString(number.getLottoNumber()))
                .sorted()
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public Boolean includeNumber(LottoNumber bonusLottoNumber) {
        return this.numbers.contains(bonusLottoNumber);
    }
}
