package airly;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

public class CmdLineParser {
    private final String[] args;
    private final Map<String, Optional<String>> parsed = new HashMap<>();

    public CmdLineParser(String[] args) {
        this.args = args;

        parse();
    }

    public void parse() {
        IntStream.range(0, args.length).filter(i -> args[i].startsWith("--")).forEach(i ->
                parsed.put(args[i].substring(2), (i+1 < args.length && !args[i+1].startsWith("--")) ? Optional.of(args[i+1]) : Optional.empty()));

    }

    public boolean hasOption(String option) {
        return parsed.containsKey(option);
    }

    public Optional<String> getOption(String option) {
        return parsed.getOrDefault(option, Optional.empty());
    }

}
