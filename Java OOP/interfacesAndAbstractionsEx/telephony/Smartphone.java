package interfacesAndAbstractionsEx.telephony;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.setNumbers(numbers);
        this.setUrls(urls);
    }

    public List<String> getNumbers() {
        return this.numbers;
    }

    public List<String> getUrls() {
        return this.urls;
    }

    private void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    private void setUrls(List<String> urls) {
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        getUrls().forEach(u -> {
            if (u.matches("\\D+")) {
                output.append("Browsing: ").append(u).append("!").append(System.lineSeparator());
            } else {
                output.append("Invalid URL!").append(System.lineSeparator());
            }
        });
        return output.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        getNumbers().forEach(e -> {
            if (e.matches("\\d+")) {
                output.append("Calling... ").append(e).append(System.lineSeparator());
            } else {
                output.append("Invalid number!").append(System.lineSeparator());
            }
        });
        return output.toString().trim();
    }
}
